package com.example.THIRD_SMPL_WEB.repos;

import com.example.THIRD_SMPL_WEB.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
