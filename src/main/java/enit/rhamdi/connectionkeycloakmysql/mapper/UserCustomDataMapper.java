package enit.rhamdi.connectionkeycloakmysql.mapper;

import enit.rhamdi.connectionkeycloakmysql.dto.UserCompleteData;
import enit.rhamdi.connectionkeycloakmysql.dto.UserCustomData;
import org.springframework.stereotype.Service;

@Service
public class UserCustomDataMapper {

    public UserCustomData from(UserCompleteData data, String id) {
        return UserCustomData.builder()
                .id(id)
                .address(data.address())
                .birthday(data.birthday())
                .phone(data.phone())
                .build();
    }
}
