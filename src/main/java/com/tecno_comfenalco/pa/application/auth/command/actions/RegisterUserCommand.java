package com.tecno_comfenalco.pa.application.auth.command.actions;

import java.util.Set;

public record RegisterUserCommand(String username, String password, Set<String> roles, boolean enabled) {

}
