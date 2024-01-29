package com.sapiant.coding.model;

import com.sapiant.coding.entity.City;
import com.sapiant.coding.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityDao {

    @Autowired
    CityRepository theCityRepository;

    //	to save city
    public City save(City c) {
        return theCityRepository.save(c);
    }

    //	Get all list of  City
    public List<City> getCity( ){
        return theCityRepository.findAll();
    }

//	update City


    //	get City by ID
    public City findOne(long cityID) {
        return theCityRepository.getOne(cityID);
    }

    //	Delete city
    public void deletecity(City c) {
        theCityRepository.delete(c);
    }
}
