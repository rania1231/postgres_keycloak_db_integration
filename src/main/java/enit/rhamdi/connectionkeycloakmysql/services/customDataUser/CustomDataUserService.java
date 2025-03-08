package enit.rhamdi.connectionkeycloakmysql.services.customDataUser;

import enit.rhamdi.connectionkeycloakmysql.dto.UserCustomData;

import java.util.List;

public interface CustomDataUserService {
    List<UserCustomData> getAllCustomData();
    UserCustomData createCustomData(UserCustomData userCustomData);
    void deleteCustomData(String id);

}
