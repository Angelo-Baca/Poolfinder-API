package poolfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poolfinder.entity.Amenity;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {

}
