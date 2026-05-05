package poolfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poolfinder.entity.Amenity;
import poolfinder.exception.ResourceNotFoundException;
import poolfinder.repository.AmenityRepository;

@Service
public class AmenityService {

    @Autowired
    private AmenityRepository amenityRepository;

    // method to return all amenity in field "amenity"
    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();
    }

    // method to return a single amenity by its Id
    public Amenity getAmenityById(Long amenityId) {
        return amenityRepository.findById(amenityId)
        .orElseThrow(() -> new ResourceNotFoundException("Cannot get Id, Amenity not found"));
    }

    // method to create a new amenity in the database
    public Amenity createAmenity(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    // method to update an existing amenity in database
    public Amenity updateAmenity(Long amenityId, Amenity updatedAmenity) {

        Amenity existingAmenity = amenityRepository.findById(amenityId)
        .orElseThrow(() -> new ResourceNotFoundException("Cannot update amenity, Amenity not Found"));

        existingAmenity.setAmenityName(updatedAmenity.getAmenityName());
        existingAmenity.setAmenityDescription(updatedAmenity.getAmenityDescription());

        return amenityRepository.save(existingAmenity);
    }

    // method to delete an existing amenity in database
    public void deleteAmenity(Long amenityId) {
        // secondary safety check to make sure amenity exists
        // use the handler class for this method rather than create 
        // another new package. Just check it in this delete method
        Amenity amenity = amenityRepository.findById(amenityId)
        .orElseThrow(() -> new ResourceNotFoundException("Cannot delete amenity, it doesn't exist!"));

        amenityRepository.delete(amenity);
    }

    //final brace
}