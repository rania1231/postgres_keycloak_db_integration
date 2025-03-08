package enit.rhamdi.connectionkeycloakmysql.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="user_entity")
public class UserProfile {
    @Id
    private String id;

    private String email;
    private String firstName;
    private String lastName;
    private  String realm_id="14d425fa-9766-4fd6-a74c-eda1f20e1085";
    private boolean enabled=true;

}
