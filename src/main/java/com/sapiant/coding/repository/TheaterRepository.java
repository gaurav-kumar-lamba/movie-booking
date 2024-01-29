package com.sapiant.coding.repository;

import java.util.List;

import com.sapiant.coding.entity.City;
import com.sapiant.coding.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

    public List<Theater> findByCity(City ID);
}
