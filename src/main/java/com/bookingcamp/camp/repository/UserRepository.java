package com.bookingcamp.camp.repository;

import com.bookingcamp.camp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    //private final EntityManager em;

    @Query(value = "SELECT * FROM USER", nativeQuery=true)
    List<UserEntity> findAll();
    //http://localhost:8080/test/search

    @Query(value = "SELECT USER_ID, USER_PASS, USER_NAME, REG_DT FROM USER WHERE NAME = :name", nativeQuery=true)
    List<UserEntity> searchUser(@Param("name") String name);
    //http://localhost:8080/test/searchParamRepo?name=이보람
}