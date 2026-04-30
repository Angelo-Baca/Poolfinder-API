package poolfinder.entity;

// import lombok for getters and setters
import jakarta.persistence.*;
import lombok.Data;


// annotations and designations
@Entity
@Table(name = "city")
@Data

// primary table and key with 3 declared fields
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "county_name", nullable = false)
    private String countyName;

    @Column(name = "state", nullable = false)
    private String state;
}