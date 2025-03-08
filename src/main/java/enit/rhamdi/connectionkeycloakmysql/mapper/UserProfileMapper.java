package enit.rhamdi.connectionkeycloakmysql.mapper;

import enit.rhamdi.connectionkeycloakmysql.dto.UserModel;
import enit.rhamdi.connectionkeycloakmysql.entity.UserProfile;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserProfileMapper {
    public UserModel from(UserProfile userProfile) {
        return new UserModel( userProfile.getFirstName(), userProfile.getLastName(), userProfile.getEmail());
    }
    public UserProfile from(UserModel userModel) {
        return UserProfile.builder()
                .id(UUID.randomUUID().toString())
                .email(userModel.email())
                .firstName(userModel.firstName())
                .lastName(userModel.lastName())
                .realm_id("14d425fa-9766-4fd6-a74c-eda1f20e1085")
                .enabled(true)
                .build();
    }
}
