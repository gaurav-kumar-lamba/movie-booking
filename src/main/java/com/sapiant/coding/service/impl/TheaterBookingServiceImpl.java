package com.sapiant.coding.service.impl;

import com.sapiant.coding.model.*;
import com.sapiant.coding.entity.*;
import com.sapiant.coding.exception.MovieNotFoundException;
import com.sapiant.coding.service.TheaterBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TheaterBookingServiceImpl implements TheaterBookingService {

    @Autowired
    CityDao theCityDAO;

    @Autowired
    MovieDao theMovieDAO;

    @Autowired
    TheaterDao theTheaterDAO;

    @Autowired
    ShowDao theShowDAO;

    @Autowired
    BookingDao theBookingsDAO;

    @Override
    public Theater addTheater(long city, HashMap<String, String> requestData) {

        Theater theTheater = new Theater();
        theTheater.setT_name(requestData.get("name"));
        theTheater.setT_area(requestData.get("area"));
        City theCity = theCityDAO.findOne(city);
        theTheater.setCity(theCity);
        return theTheaterDAO.save(theTheater);
    }

    @Override
    public Show addShow(long theaterId, long movieId, HashMap<String, String> map) {

        Theater theTheater = theTheaterDAO.findOne(theaterId);
        Movie theMovie = theMovieDAO.findOne(movieId);
        Show theShow = new Show();
        Show theResponseShow = new Show();
        Bookings theBookings = new Bookings();
        theShow.setShow_time(map.get("time"));
        theShow.setTheMovie(theMovie);
        theShow.setTheTheater(theTheater);
        theResponseShow = theShowDAO.save(theShow);
        theBookings.setShow_id(theResponseShow.getShow_Id());
        theBookingsDAO.bookTheSeat(theBookings);

        return theResponseShow;
    }

    @Override
    public Movie updateMovie(long ID, Movie movie) {
        Movie theMovie = theMovieDAO.findOne(ID);
        if(theMovie == null) {
            throw new MovieNotFoundException(ID, "movie not found");
        }
        theMovie.set_name(movie.get_name());
        theMovie.set_director(movie.get_director());
        theMovie.set_description(movie.get_description());

        return theMovieDAO.save(theMovie);
    }

    @Override
    public Theater updateTheater(long ID, Theater t) {
        Theater theTheater = theTheaterDAO.findOne(ID);
        if(theTheater == null) {
            throw new MovieNotFoundException(ID, "Theater not found");
        }
        theTheater.setT_name(t.getT_name());
        theTheater.setT_area(t.getT_area());
        return theTheaterDAO.save(theTheater);
    }
}
