package poolfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poolfinder.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}

