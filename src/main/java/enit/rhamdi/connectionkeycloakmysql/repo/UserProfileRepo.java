package enit.rhamdi.connectionkeycloakmysql.repo;

import enit.rhamdi.connectionkeycloakmysql.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, String> {
}
