package poolfinder.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "amenity")
@Data
public class Amenity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenityId;

    private String amenityName;
    private String amenityDescription;

    
   
}


