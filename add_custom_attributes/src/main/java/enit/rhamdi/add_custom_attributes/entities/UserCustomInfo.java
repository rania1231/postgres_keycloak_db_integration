package enit.rhamdi.add_custom_attributes.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder @Getter  @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name = "user-custom-info")
public class UserCustomInfo {
    @Id
    private String id;

    private LocalDate birthday;
    @Column(unique = true, nullable = false)
    private String phone;
    private String address;
}
