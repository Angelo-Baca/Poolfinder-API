package poolfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poolfinder.entity.Pool;
import poolfinder.exception.ResourceNotFoundException;
import poolfinder.repository.PoolRepository;

@Service
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
        .orElseThrow(() -> new ResourceNotFoundException("Cannot locate pool Id, pool not found"));
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
        .orElseThrow(() -> new ResourceNotFoundException("Cannot update pool, pool not Found"));

        existingPool.setPoolName(updatedPool.getPoolName()); 
        existingPool.setType(updatedPool.getType());
        existingPool.setIsPublic(updatedPool.getIsPublic());
        existingPool.setAddress(updatedPool.getAddress());
        existingPool.setCity(updatedPool.getCity());
        
        return poolRepository.save(existingPool);
    }

    // method to delete an existing pool in database
    public void deletePool(Long poolId) {
        Pool pool = poolRepository.findById(poolId)
        .orElseThrow(() -> new ResourceNotFoundException("Cannot delete pool, it doesn't exist!"));

        poolRepository.delete(pool);
    }
}
