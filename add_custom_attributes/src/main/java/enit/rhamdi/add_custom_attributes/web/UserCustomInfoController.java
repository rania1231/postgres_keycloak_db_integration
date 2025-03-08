package enit.rhamdi.add_custom_attributes.web;

import enit.rhamdi.add_custom_attributes.entities.UserCustomInfo;
import enit.rhamdi.add_custom_attributes.repo.UserCustomInfoRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/custom-users")
@AllArgsConstructor
public class UserCustomInfoController {
   private UserCustomInfoRepo userCustomInfoRepo;

   @GetMapping
    public List<UserCustomInfo> getAll() {
       return userCustomInfoRepo.findAll();
   }

   @PostMapping("/create")
    public UserCustomInfo create(@RequestBody UserCustomInfo userCustomInfo){
       return userCustomInfoRepo.save(userCustomInfo);
   }

   @DeleteMapping("/delete/{id}")
    public void deleteCustomInfo(@PathVariable String id){
       Optional<UserCustomInfo> userCustomInfo = userCustomInfoRepo.findById(id);
       if(userCustomInfo.isPresent()){
           userCustomInfoRepo.delete(userCustomInfo.get());
       }
       else throw new RuntimeException("Custom info not found");

   }

}
