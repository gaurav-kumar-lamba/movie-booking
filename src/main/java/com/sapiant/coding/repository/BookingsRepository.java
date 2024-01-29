package com.sapiant.coding.repository;

import com.sapiant.coding.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {

}
