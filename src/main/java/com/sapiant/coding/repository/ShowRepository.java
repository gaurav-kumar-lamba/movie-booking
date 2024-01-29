package com.sapiant.coding.repository;

import java.util.List;

import com.sapiant.coding.entity.Movie;
import com.sapiant.coding.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    public List<Show> findBytheMovie(Movie m);
}
