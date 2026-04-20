package com.tecno_comfenalco.pa.application.auth.orchestator;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.application.auth.Exceptions.UserNotFoundException;
import com.tecno_comfenalco.pa.application.auth.command.actions.EditUserCommand;
import com.tecno_comfenalco.pa.application.auth.command.actions.LoginUserCommand;
import com.tecno_comfenalco.pa.application.auth.command.actions.RegisterUserCommand;
import com.tecno_comfenalco.pa.application.auth.command.response.DisabledUserCommandResult;
import com.tecno_comfenalco.pa.application.auth.command.response.EditUserCommandResult;
import com.tecno_comfenalco.pa.application.auth.command.response.ListAllUsersCommandResult;
import com.tecno_comfenalco.pa.application.auth.command.response.LoginUserCommandResult;
import com.tecno_comfenalco.pa.application.auth.command.response.RegisterUserCommandResult;
import com.tecno_comfenalco.pa.application.auth.draft.UserDraft;
import com.tecno_comfenalco.pa.application.auth.ports.IUserRepositoryPort;
import com.tecno_comfenalco.pa.application.auth.usecases.AuthenticationUseCase;
import com.tecno_comfenalco.pa.domain.auth.models.UserModel;
import com.tecno_comfenalco.pa.infrastructure.security.CustomUserDetails;

@Service
public class AuthenticationUseCaseImp implements AuthenticationUseCase {

    private final IUserRepositoryPort userRepositoryPort;
    private final AuthenticationManager authenticationManager;

    public AuthenticationUseCaseImp(IUserRepositoryPort iUserRepositoryPort,
            AuthenticationManager authenticationManager) {
        this.userRepositoryPort = iUserRepositoryPort;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public RegisterUserCommandResult registerUser(RegisterUserCommand cmd) {
        boolean existsUser = userRepositoryPort.existsByUsername(cmd.username());

        if (!existsUser) {
            throw new UserNotFoundException();
        }

        UserModel user = UserModel.createDraft(cmd.username(), cmd.password(), cmd.roles(), cmd.enabled());
        userRepositoryPort.save(user);

        return new RegisterUserCommandResult("User registered successfully", user.getId());
    }

    @Override
    public LoginUserCommandResult loginUser(LoginUserCommand cmd) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(cmd.username(), cmd.password()));

        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();
        String role = details.getAuthorities().iterator().next().getAuthority().replace("ROLE_", "");

        return new LoginUserCommandResult(role);
    }

    @Override
    public DisabledUserCommandResult disabledUser(UUID userId) {
        Optional<UserModel> userOpt = userRepositoryPort.findByUserId(userId);

        if (userOpt.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserModel user = userOpt.get();

        // logica de negocio
        user = UserModel.ChangeEnabled(user, false); // servicio del dominio que se encarga de desactivarlo

        userRepositoryPort.save(user);

        return new DisabledUserCommandResult("User disabled successfully", user.getId());
    }

    @Override
    public ListAllUsersCommandResult listUsers() {
        List<UserDraft> usersDraft = userRepositoryPort.findAll()
                .stream()
                .map(usersModel -> new UserDraft(usersModel.getId(), usersModel.getUsername(), usersModel.getRoles(),
                        usersModel.isEnabled()))
                .toList();

        return new ListAllUsersCommandResult("Users retrieved successfully", usersDraft);
    }

    @Override
    public EditUserCommandResult editUser(EditUserCommand cmd) {
        Optional<UserModel> userOpt = userRepositoryPort.findByUserId(cmd.userId());

        if (userOpt.isEmpty()) {
            throw new UserNotFoundException();
        }

        UserModel user = UserModel.createNew(userOpt.get().getId(), cmd.username(), cmd.password(),
                userOpt.get().getRoles(),
                userOpt.get().isEnabled());

        userRepositoryPort.save(user);

        return new EditUserCommandResult("User edited successfully",
                new UserDraft(user.getId(), user.getUsername(), user.getRoles(), user.isEnabled()));
    }

}
