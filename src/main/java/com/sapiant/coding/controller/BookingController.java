package com.sapiant.coding.controller;

import com.sapiant.coding.model.*;
import com.sapiant.coding.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookingController {

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

//	Get the list of City where you can book the movie

    @GetMapping("/city")
    public List<City> getAllCity(){

        return theCityDAO.getCity();
    }


//	GEt list of theater Available against a City

    @GetMapping("/{ID}/theater")
    public List<Theater> getTheaterInCity(@PathVariable(value = "ID") long ID){

        City theCity = theCityDAO.findOne(ID);

        return theTheaterDAO.gettheaterByCityId(theCity);
    }

//	Get Movie available on the theaters

    @GetMapping("/theater/{ID}/movie")
    public List<Object[]> getMovieByTheaterID(@PathVariable(value = "ID") long ID){

        return theMovieDAO.getMovieByTheaterId(ID);
    }

//	Get Available Show for a particular movie

    @GetMapping("/movie/{id}/show")
    public List<Show> geShowByMovieId(@PathVariable(value ="id") long id){

        Movie theMovie = theMovieDAO.findOne(id);

        return theShowDAO.fetchByMovie(theMovie);
    }

//	Get the seat available for a particular Show using the show ID

    @GetMapping("/show/{id}")
    public Bookings getAvailableSeat(@PathVariable ( value = "id") long id)
    {
        return theBookingsDAO.getAvailableSeat(id);
    }

//	Book a Seat using the show id By passing the show POJO to the API

    @PostMapping("show/{id}/bookings")
    public Bookings bookSeatForShow(@PathVariable (value = "id") long id, @Valid @RequestBody Bookings b)
    {
        return theBookingsDAO.bookTheSeat(b);
    }
}
