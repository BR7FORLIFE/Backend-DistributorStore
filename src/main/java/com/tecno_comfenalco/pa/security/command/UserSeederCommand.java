package com.tecno_comfenalco.pa.security.command;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.security.port.IUserRepositoryPort;

@Component
public class UserSeederCommand implements CommandLineRunner {

        @Autowired
        private IUserRepositoryPort userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        public void run(String... args) throws Exception {
                // Seed initial users
                userRepository.save(UserModel.builder().username("admin").password(passwordEncoder.encode("password"))
                                .enabled(true).roles(Set.of("ADMIN")).build());

                userRepository.save(
                                UserModel.builder().username("presales").password(passwordEncoder.encode("password"))
                                                .enabled(true).roles(Set.of("PRESALES")).build());

                userRepository.save(UserModel.builder().username("distributor")
                                .password(passwordEncoder.encode("password")).enabled(true)
                                .roles(Set.of("DISTRIBUTOR")).build());

                userRepository.save(UserModel.builder().username("delivery")
                                .password(passwordEncoder.encode("password")).enabled(true)
                                .roles(Set.of("DELIVERY")).build());

                userRepository.save(UserModel.builder().username("store")
                                .password(passwordEncoder.encode("password")).enabled(true)
                                .roles(Set.of("STORE")).build());

                System.out.println("🟩____Users seeded____🟩");
        }

}
