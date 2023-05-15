package com.example.money.dao;


import com.example.money.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<Users, Long> {
    @Query("select obj from Users obj where obj.id=:id")
    Users findByID(Long id);
}
