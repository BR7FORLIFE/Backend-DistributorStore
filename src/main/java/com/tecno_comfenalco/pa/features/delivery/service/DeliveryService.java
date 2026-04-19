package com.tecno_comfenalco.pa.features.delivery.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.features.delivery.dto.DeliveryDto;
import com.tecno_comfenalco.pa.features.delivery.dto.request.EditDeliveryRequestDto;
import com.tecno_comfenalco.pa.features.delivery.dto.request.RegisterDeliveryRequestDto;
import com.tecno_comfenalco.pa.features.delivery.dto.response.DeliveryResponseDto;
import com.tecno_comfenalco.pa.features.delivery.dto.response.EditDeliveryResponseDto;
import com.tecno_comfenalco.pa.features.delivery.dto.response.ListDeliveriesResponseDto;
import com.tecno_comfenalco.pa.features.delivery.dto.response.RegisterDeliveryResponseDto;
import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.features.delivery.ports.IDeliveryRepositoryPort;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.features.distributor.ports.IDistributorRepositoryPort;
import com.tecno_comfenalco.pa.security.AuthenticationService;
import com.tecno_comfenalco.pa.security.dto.requests.RegisterUserRequestDto;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.security.port.IUserRepositoryPort;
import com.tecno_comfenalco.pa.shared.utils.result.Result;

@Service
public class DeliveryService {
    @Autowired
    private IDeliveryRepositoryPort deliveryRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private IUserRepositoryPort userRepository;

    @Autowired
    private IDistributorRepositoryPort distributorRepository;

    public Result<RegisterDeliveryResponseDto, Exception> newDelivery(RegisterDeliveryRequestDto dtoDelivery) {

        boolean existsDelivery = deliveryRepository.existsByDocumentNumber(dtoDelivery.documentNumber());

        if (existsDelivery) {
            return Result.error(new Exception("The current delivery is already registered!"));
        }

        try {

            DeliveryModel deliveryModel = new DeliveryModel();
            deliveryModel.setName(dtoDelivery.name());
            deliveryModel.setDocumentType(dtoDelivery.documentType());
            deliveryModel.setDocumentNumber(dtoDelivery.documentNumber());
            deliveryModel.setPhoneNumber(dtoDelivery.phoneNumber());
            deliveryModel.setLicenseNumber(dtoDelivery.licenseNumber());
            deliveryModel.setLicenseType(dtoDelivery.licenseType());

            String userId = authenticationService.registerUser(
                    new RegisterUserRequestDto(dtoDelivery.name().toLowerCase().replace(" ", "_"),
                            "password", Set.of("DELIVERY"), true))
                    .getValue().userId();

            UserModel userEntity = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found!"));

            deliveryModel.setUser(userEntity);

            assignDeliveryToDistributor(deliveryModel);

            deliveryRepository.save(deliveryModel);

            return Result.ok(new RegisterDeliveryResponseDto("Delivery register successful!"));
        } catch (Exception e) {
            return Result.error(new Exception("Error to register delivery!", e));
        }
    }

    public Result<EditDeliveryResponseDto, Exception> editDelivery(String id,
            EditDeliveryRequestDto dtoDelivery) {
        try {
            return deliveryRepository.findById(id)
                    .map(delivery -> {

                        delivery.setName(dtoDelivery.name());
                        delivery.setDocumentType(dtoDelivery.documentTypeEnum());
                        delivery.setDocumentNumber(dtoDelivery.documentnumber());
                        delivery.setPhoneNumber(dtoDelivery.phoneNumber());
                        delivery.setLicenseNumber(dtoDelivery.licenseNumber());
                        delivery.setLicenseType(dtoDelivery.licenseType());

                        deliveryRepository.save(delivery);

                        EditDeliveryResponseDto response = new EditDeliveryResponseDto(
                                "delivery edited successfully!");

                        return Result.ok(response);

                    }).orElseGet(() -> Result.error(new Exception("delivery not found!")));
        } catch (Exception e) {
            return Result.error(new Exception("delivery not exists by id cause!"));
        }
    }

    public Result<ListDeliveriesResponseDto, Exception> listDelivery() {
        List<DeliveryModel> deliveryEntities = deliveryRepository.findAll();

        try {

            List<DeliveryDto> deliverysDto = deliveryEntities.stream()
                    .map(delivery -> new DeliveryDto(delivery.getId(), delivery.getName(), delivery.getDocumentType(),
                            delivery.getDocumentNumber(), delivery.getPhoneNumber(), delivery.getLicenseNumber(),
                            delivery.getLicenseType(), delivery.getUser().getId(), delivery.getDistributor().getId()))
                    .toList();

            return Result.ok(new ListDeliveriesResponseDto(deliverysDto, "deliveries found successfully!"));
        } catch (Exception e) {
            return Result.error(new Exception("Error retrieving deliveries!"));
        }
    }

    public Result<DeliveryResponseDto, Exception> showDelivery(String id) {
        try {
            return deliveryRepository.findById(id).map(delivery -> {

                DeliveryDto deliveryDto = new DeliveryDto(delivery.getId(), delivery.getName(),
                        delivery.getDocumentType(), delivery.getDocumentNumber(), delivery.getPhoneNumber(),
                        delivery.getLicenseNumber(), delivery.getLicenseType(), delivery.getUser().getId(),
                        delivery.getDistributor().getId());

                return Result.ok(new DeliveryResponseDto(deliveryDto, "delivery found successfully"));

            }).orElseThrow();

        } catch (Exception e) {
            return Result.error(new Exception("Error retrieving delivery!"));
        }
    }

    public void assignDeliveryToDistributor(DeliveryModel deliveryModel) {
        try {

            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            var userOpt = userRepository.findByUsername(username);
            if (userOpt.isEmpty()) {
                return;
            }

            UserModel user = userOpt.get();

            var distributorOpt = distributorRepository.findByUser_Id(user.getId());

            if (distributorOpt.isEmpty()) {
                return;
            }

            DistributorModel distributorAuthenticated = distributorOpt.get();

            deliveryModel.setDistributor(distributorAuthenticated);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
