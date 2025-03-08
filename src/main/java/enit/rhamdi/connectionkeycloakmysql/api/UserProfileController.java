package enit.rhamdi.connectionkeycloakmysql.api;


import enit.rhamdi.connectionkeycloakmysql.dto.UserModel;
import enit.rhamdi.connectionkeycloakmysql.entity.UserProfile;
import enit.rhamdi.connectionkeycloakmysql.mapper.UserProfileMapper;
import enit.rhamdi.connectionkeycloakmysql.repo.UserProfileRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserProfileController {
    private final UserProfileRepo userProfileRepo;
    private final UserProfileMapper userProfileMapper;

    public UserProfileController(UserProfileRepo userProfileRepo, UserProfileMapper userProfileMapper) {
        this.userProfileRepo = userProfileRepo;
        this.userProfileMapper = userProfileMapper;
    }

    @PostMapping("/create")
    public UserProfile createUserProfile(@RequestBody UserModel userModel) {
        return userProfileRepo.save( userProfileMapper.from(userModel) );
    }


    @GetMapping("/profiles")
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepo.findAll();
    }
}
