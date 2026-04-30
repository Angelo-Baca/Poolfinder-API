package poolfinder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pool")

public class Pool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long poolId;
    private String poolName;
    private String type; // either indoor / outdoor
    private Boolean isPublic;
    private String address;

    // relationship comes next
    @ManyToOne
    @JoinColumn(name = "city_id")
    private Pool pool;

}
