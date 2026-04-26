package com.tecno_comfenalco.pa.infrastructure.auth.command;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tecno_comfenalco.pa.application.auth.ports.IUserRepositoryPort;
import com.tecno_comfenalco.pa.domain.auth.models.UserModel;

@Component
public class UserSeederCommand implements CommandLineRunner {

    @Autowired
    private IUserRepositoryPort userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Seed initial users
        userRepository
                .save(UserModel.createDraft("admin", passwordEncoder.encode("password"), Set.of("ADMIN"), "", true));

        userRepository.save(
                UserModel.createDraft("presales", passwordEncoder.encode("password"), Set.of("PRESALES"), "", true));

        userRepository.save(UserModel.createDraft("distributor", passwordEncoder.encode("password"),
                Set.of("DISTRIBUTOR"), "", true));

        userRepository.save(
                UserModel.createDraft("delivery", passwordEncoder.encode("password"), Set.of("DELIVERY"), "", true));

        userRepository
                .save(UserModel.createDraft("store", passwordEncoder.encode("password"), Set.of("STORE"), "", true));

        System.out.println("🟩____Users seeded____🟩");
    }

}
