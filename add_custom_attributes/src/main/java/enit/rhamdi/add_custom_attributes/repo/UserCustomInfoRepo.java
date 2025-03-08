package enit.rhamdi.add_custom_attributes.repo;

import enit.rhamdi.add_custom_attributes.entities.UserCustomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCustomInfoRepo extends JpaRepository<UserCustomInfo, String> {
}