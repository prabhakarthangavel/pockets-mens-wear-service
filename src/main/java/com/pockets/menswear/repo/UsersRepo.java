package com.pockets.menswear.repo;

import com.pockets.menswear.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}
