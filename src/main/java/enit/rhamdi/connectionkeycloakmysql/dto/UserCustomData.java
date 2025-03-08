package enit.rhamdi.connectionkeycloakmysql.dto;

import lombok.Builder;


import java.time.LocalDate;


@Builder

public record UserCustomData(String id, LocalDate birthday, String phone, String address) {
}
