package enit.rhamdi.connectionkeycloakmysql.services;


import enit.rhamdi.connectionkeycloakmysql.dto.UserCompleteData;
import enit.rhamdi.connectionkeycloakmysql.dto.UserCustomData;
import enit.rhamdi.connectionkeycloakmysql.entity.UserProfile;
import enit.rhamdi.connectionkeycloakmysql.mapper.UserCustomDataMapper;
import enit.rhamdi.connectionkeycloakmysql.mapper.UserProfileMapper;
import enit.rhamdi.connectionkeycloakmysql.repo.UserProfileRepo;
import enit.rhamdi.connectionkeycloakmysql.services.customDataUser.CustomDataUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
    private UserProfileRepo userProfileRepo;
    private CustomDataUserService customDataUserService;
    private UserCustomDataMapper userCustomDataMapper;
    private UserProfileMapper userProfileMapper;
    public UserProfileServiceImpl(UserProfileRepo userProfileRepo, CustomDataUserService customDataUserService, UserCustomDataMapper userCustomDataMapper, UserProfileMapper userProfileMapper) {
        this.userProfileRepo = userProfileRepo;
        this.customDataUserService = customDataUserService;
        this.userCustomDataMapper = userCustomDataMapper;
        this.userProfileMapper = userProfileMapper;
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userProfileRepo.findAll();
    }

    @Override
    public Optional<UserProfile> getUserProfileByUsername(String id) {
        return  userProfileRepo.findById(id);
    }

    @Override
    public UserProfile createUserProfile(UserCompleteData userCompleteData) {
        UserProfile userProfile=userProfileMapper.from(userCompleteData);

        userProfileRepo.save(userProfile);
        UserCustomData userCustomData=userCustomDataMapper.from(userCompleteData,userProfile.getId());
       customDataUserService.createCustomData(userCustomData);
        return userProfile;
    }

    @Override
    public void deleteUserProfile(String id) {

        customDataUserService.deleteCustomData(id);
        userProfileRepo.deleteById(id);

    }
}
