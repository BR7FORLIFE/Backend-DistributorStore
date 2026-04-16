package com.tecno_comfenalco.pa.security.entity.mongo;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDocument {

    @Id
    private String id;

    private String username;
    private String password;

    private boolean enabled;

    private Set<String> roles;
}
