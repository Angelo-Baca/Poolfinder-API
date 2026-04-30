package poolfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import poolfinder.entity.Pool;
import poolfinder.exception.ResourceNotFoundException;
import poolfinder.repository.PoolRepository;

public class PoolService {
    
    @Autowired
    private PoolRepository poolRepository;

    // method to return all cities in field "pool"
    public List<Pool> getAllPools() {
        return poolRepository.findAll();
    }

    // method to return a single pool by its Id
    public Pool getPoolById(Long poolId) {
        return poolRepository.findById(poolId)
        .orElseThrow(() -> new ResourceNotFoundException("Pool not found"));
    }

    // method to create a new pool in the database
    public Pool createPool(Pool pool) {
        return poolRepository.save(pool);
    }

    // method to update an existing pool in database
    public Pool updatePool(Long poolId, Pool updatedPool) {

        // secondary safety check to make sure pool exists
        // use the handler class for this method rather than create 
        // another new package. Just check it in the update method
        Pool existingPool = poolRepository.findById(poolId)
        .orElseThrow(() -> new ResourceNotFoundException("Pool not Found"));

        existingPool.setPoolName(updatedPool.getPoolName());
        /* 
        existingPool.setCountyName(updatedPool.getCountyName());
        existingPool.setState(updatedPool.getState());
        */
        return poolRepository.save(existingPool);
    }

    // method to delete an existing pool in database
    public void deletePool(Long poolId) {
        // secondary safety check to make sure pool exists
        // use the handler class for this method rather than create 
        // another new package. Just check it in this delete method
        Pool pool = poolRepository.findById(poolId)
        .orElseThrow(() -> new ResourceNotFoundException("Pool not Found"));

        poolRepository.delete(pool);
    }
}
