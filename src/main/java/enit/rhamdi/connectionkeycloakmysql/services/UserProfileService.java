package enit.rhamdi.connectionkeycloakmysql.services;

import enit.rhamdi.connectionkeycloakmysql.dto.UserCompleteData;
import enit.rhamdi.connectionkeycloakmysql.entity.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserProfileService {
    List<UserProfile> getAllUsers();
    Optional<UserProfile> getUserProfileByUsername(String id);
    UserProfile createUserProfile(UserCompleteData userCompleteData);
    void deleteUserProfile(String id);
}
