package poolfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poolfinder.entity.Amenity;
import poolfinder.service.AmenityService;

@RestController
@RequestMapping("/amenities")
public class AmenityController {

    @Autowired
    private AmenityService amenityService;

    @GetMapping
    public List<Amenity> getAllAmenities() {
        return amenityService.getAllAmenities();
    }

    @GetMapping("/{amenityId}")
    public Amenity getAmenityById(@PathVariable Long amenityId) {
        return amenityService.getAmenityById(amenityId);
    }
    
    @PostMapping
    public Amenity createAmenity(@RequestBody Amenity amenity) {
        return amenityService.createAmenity(amenity);
    }

    @PutMapping("/{amenityId}")
    public Amenity updateAmenity(@PathVariable Long amenityId, @RequestBody Amenity amenity) {
        return amenityService.updateAmenity(amenityId, amenity);
    }

    @DeleteMapping("/{amenityId}")
    public void deleteAmenity(@PathVariable Long amenityId) {
        amenityService.deleteAmenity(amenityId);
    }
    
}
