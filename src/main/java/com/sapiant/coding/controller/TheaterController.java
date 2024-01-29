package com.sapiant.coding.controller;

import com.sapiant.coding.model.*;
import com.sapiant.coding.entity.*;
import com.sapiant.coding.service.impl.TheaterBookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class TheaterController  {

    @Autowired
    MovieDao theMovieDAO;

    @Autowired
    TheaterBookingServiceImpl bookingService;

    //Add Theater to the table
    @PostMapping("/{city}/theater")
    public ResponseEntity<Theater> addTheater(@PathVariable(value="city") long city, @Valid @RequestBody HashMap<String, String> requestData) {

        Theater theater = bookingService.addTheater(city, requestData);
        return new ResponseEntity<>(theater, HttpStatus.OK);
    }

    @PostMapping("/{ID}/{id}/show")
    public ResponseEntity<Show> addingShow(@PathVariable(value = "ID") long theaterId, @PathVariable(value = "id") long movieId, @Valid @RequestBody HashMap<String, String> requestData) {

        Show show = bookingService.addShow(theaterId, movieId, requestData);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    //	Add Movie to the table
    @PostMapping("/movie")
    public Movie createMovie(@Valid @RequestBody Movie m) {
        return theMovieDAO.save(m);
    }

    //	update Movie
    @PutMapping("/movie/{ID}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value="ID") long ID,@Valid @RequestBody Movie movie){

        Movie updatedMovie = bookingService.updateMovie(ID, movie);
        return ResponseEntity.ok().body(updatedMovie);
    }

    //	update theater
    @PutMapping("/theater/{ID}")
    public ResponseEntity<Theater> updatetheater(@PathVariable(value="ID") long ID, @Valid @RequestBody Theater theater){

        Theater updatedTheater = bookingService.updateTheater(ID, theater);
        return ResponseEntity.ok().body(updatedTheater);

    }
}
