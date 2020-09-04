package com.example.demo.hotels;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.hotels.hotels;

@Repository
public interface hotelrepository
        extends JpaRepository<hotels, Long> {

}
