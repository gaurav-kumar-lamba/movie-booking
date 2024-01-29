package com.sapiant.coding.model;

import com.sapiant.coding.entity.Movie;
import com.sapiant.coding.entity.Show;
import com.sapiant.coding.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowDao {
    @Autowired
    ShowRepository theShowRepository;

    //	Save the show
    public Show save(Show show)
    {
        return theShowRepository.save(show);
    }

    //	Fetch all show
    public List<Show> fetchAllShow(){
        return theShowRepository.findAll();

    }

    //	Fetch show by ID
    public Show fetchById(long Id) {
        return theShowRepository.getOne(Id);
    }

//	Fetch show by Moive ID

    public List<Show> fetchByMovie(Movie m){
        return theShowRepository.findBytheMovie(m);
    }
}
