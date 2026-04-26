package com.tecno_comfenalco.pa.application.auth.dto.responses;

import java.util.Set;

public record LoginResponseDto(String message, Set<String> role) {
}
