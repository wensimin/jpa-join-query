package com.example.jpajoinquery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long>{
}
