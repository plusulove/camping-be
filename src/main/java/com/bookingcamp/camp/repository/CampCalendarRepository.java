package com.bookingcamp.camp.repository;

import com.bookingcamp.camp.entity.CampCalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CampCalendarRepository extends JpaRepository<CampCalendarEntity, String> {

    @Query(value = "SELECT BOOK_D, CAMP_NAME, ROOM_C, ALLOC_C, CLOSE_YN, REG_DT FROM CAMPCALENDAR WHERE CAMP_NAME = :name", nativeQuery=true)
    List<CampCalendarEntity> searchCampCalendar(@Param("name") String name);
    //http://localhost:8080/test/searchCampCalendar

    @Query(value = "SELECT BOOK_D, CAMP_NAME, ROOM_C, ALLOC_C, CLOSE_YN, REG_DT FROM CAMPCALENDAR", nativeQuery=true)
    List<CampCalendarEntity> searchCampCalendarAll();
    //http://localhost:8080/test/searchCampCalendarAll

}