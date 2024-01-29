package com.sapiant.coding.service;

import com.sapiant.coding.entity.Movie;
import com.sapiant.coding.entity.Show;
import com.sapiant.coding.entity.Theater;
import java.util.HashMap;

public interface TheaterBookingService {

    Theater addTheater(long city, HashMap<String, String> map);
    Show addShow(long theaterId, long movieId, HashMap<String, String> map);
    Movie updateMovie(long ID, Movie movie);
    Theater updateTheater(long ID, Theater t);
}
