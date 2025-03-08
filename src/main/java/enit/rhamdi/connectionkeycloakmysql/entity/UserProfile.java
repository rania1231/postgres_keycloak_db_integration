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
    private String realm_id;
    private boolean enabled;

}
