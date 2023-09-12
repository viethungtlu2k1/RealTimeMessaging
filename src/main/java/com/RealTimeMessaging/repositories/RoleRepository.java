package com.RealTimeMessaging.repositories;

import com.RealTimeMessaging.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role);

//    @Query("select from Role r  ")
//    List<Role> findbyUsername(String username)
}
