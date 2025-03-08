package enit.rhamdi.connectionkeycloakmysql.dto;

import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Builder
public record UserCompleteData (
        String email,
        String firstName,
        String lastName,
        String phone,
        String address,
        LocalDate birthday
)
{}