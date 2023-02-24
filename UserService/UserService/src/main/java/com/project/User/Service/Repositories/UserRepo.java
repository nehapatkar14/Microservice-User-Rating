package com.project.User.Service.Repositories;

//import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
//import com.lcwd.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.User.Service.Entities.*;
public interface UserRepo extends JpaRepository<User,String>{

}
