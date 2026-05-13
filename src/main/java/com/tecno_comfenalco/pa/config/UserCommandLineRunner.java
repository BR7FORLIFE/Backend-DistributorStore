package com.tecno_comfenalco.pa.config;

import java.util.Optional;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tecno_comfenalco.pa.application.auth.ports.IUserRepositoryPort;
import com.tecno_comfenalco.pa.domain.auth.models.UserModel;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

        private final IUserRepositoryPort iUserRepositoryPort;
        private final PasswordEncoder passwordEncoder;

        public UserCommandLineRunner(IUserRepositoryPort userRepositoryPort, PasswordEncoder passwordEncoder) {
                this.iUserRepositoryPort = userRepositoryPort;
                this.passwordEncoder = passwordEncoder;
        }

        @Override
        public void run(String... args) throws Exception {
                Optional<UserModel> optUser = iUserRepositoryPort.findByUsername("jose");

                if (optUser.isPresent()) {
                        return;
                }

                UserModel user = UserModel.createDraft(
                                null,
                                "admin",
                                passwordEncoder.encode("12345678"),
                                Set.of("ADMIN"),
                                "prueba@gmail.com",
                                true);

                iUserRepositoryPort.save(user);

                System.out.println("🟩____Users seeded____🟩");
        }

}
