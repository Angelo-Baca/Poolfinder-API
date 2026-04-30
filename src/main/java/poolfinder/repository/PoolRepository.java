package poolfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poolfinder.entity.Pool;

@Repository
public interface PoolRepository extends JpaRepository<Pool, Long> {

}