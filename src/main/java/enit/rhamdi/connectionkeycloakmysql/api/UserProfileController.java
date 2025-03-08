package enit.rhamdi.connectionkeycloakmysql.api;


import enit.rhamdi.connectionkeycloakmysql.dto.UserCompleteData;
import enit.rhamdi.connectionkeycloakmysql.dto.UserModel;
import enit.rhamdi.connectionkeycloakmysql.entity.UserProfile;
import enit.rhamdi.connectionkeycloakmysql.mapper.UserProfileMapper;
import enit.rhamdi.connectionkeycloakmysql.services.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserProfileController {
    private final UserProfileService userProfileService;
    private final UserProfileMapper userProfileMapper;

    public UserProfileController(UserProfileService userProfileService, UserProfileMapper userProfileMapper) {
        this.userProfileService = userProfileService;
        this.userProfileMapper = userProfileMapper;
    }

    @PostMapping("/create")
    public UserProfile createUserProfile(@RequestBody UserCompleteData userCompleteData) {
        return userProfileService.createUserProfile( userCompleteData );
    }


    @GetMapping("/profiles")
    public List<UserProfile> getAllUserProfiles() {
        return userProfileService.getAllUsers();
    }
    @DeleteMapping("/delete")
    public void deleteUserProfile(@RequestParam("id") String id) {
         userProfileService.deleteUserProfile(id);
    }
}
