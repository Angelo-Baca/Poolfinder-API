package poolfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poolfinder.entity.City;
import poolfinder.exception.ResourceNotFoundException;
import poolfinder.repository.CityRepository;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    // method to return all cities in field "city"
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // method to return a single city by its Id
    public City getCityById(Long cityId) {
        return cityRepository.findById(cityId)
        .orElseThrow(() -> new ResourceNotFoundException("Cannot get Id, City not found"));
    }

    // method to create a new city in the database
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    // method to update an existing city in database
    public City updateCity(Long cityId, City updatedCity) {

        // secondary safety check to make sure city exists
        // use the handler class for this method rather than create 
        // another new package. Just check it in the update method
        City existingCity = cityRepository.findById(cityId)
        .orElseThrow(() -> new ResourceNotFoundException("Cannot update city, City not Found"));

        existingCity.setCityName(updatedCity.getCityName());
        existingCity.setCountyName(updatedCity.getCountyName());
        existingCity.setState(updatedCity.getState());

        return cityRepository.save(existingCity);
    }

    // method to delete an existing city in database
    public void deleteCity(Long cityId) {
        // secondary safety check to make sure city exists
        // use the handler class for this method rather than create 
        // another new package. Just check it in this delete method
        City city = cityRepository.findById(cityId)
        .orElseThrow(() -> new ResourceNotFoundException("Cannot delete city, it doesn't exist!"));

        cityRepository.delete(city);
    }

    //final brace
}