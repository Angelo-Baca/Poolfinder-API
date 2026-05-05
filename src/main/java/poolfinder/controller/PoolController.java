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

import poolfinder.entity.Pool;
import poolfinder.service.PoolService;

@RestController
@RequestMapping("/pools")
public class PoolController {

    @Autowired
    private PoolService poolService;
    
    @GetMapping
    public List<Pool> getAllPools() {
        return poolService.getAllPools();
    }

    @GetMapping("/{poolId}")
    public Pool getPoolById(@PathVariable Long poolId) {
        return poolService.getPoolById(poolId);
    }

    @PostMapping
    public Pool createPool(@RequestBody Pool pool) {
        return poolService.createPool(pool);
    }

    @PutMapping("/{poolId}")
    public Pool updatePool(@PathVariable Long poolId, @RequestBody Pool pool) {
        return poolService.updatePool(poolId, pool);
    }

    @DeleteMapping("/{poolId}")
    public void deletePool(@PathVariable Long poolId) {
        poolService.deletePool(poolId);
    }
    

    // this is the bracket for the main method.
    // Nothing goes below here
}
