package edu.sistrans.epsandes.dto;

import java.time.LocalDateTime;

public record AvailabilityScheduleDTO(
    String healthServiceName, LocalDateTime availabilityDate, String ipsName, String doctorName) {}
