USE pool_finder;

-- Clear relationship table first if it exists
USE pool_finder;

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE pool_amenity;
TRUNCATE TABLE pool;
TRUNCATE TABLE amenity;
TRUNCATE TABLE city;

SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE city AUTO_INCREMENT = 1;
ALTER TABLE pool AUTO_INCREMENT = 1;
ALTER TABLE amenity AUTO_INCREMENT = 1;

INSERT INTO city (city_name, county_name, state)
VALUES
('Colorado Springs', 'El Paso', 'CO'),
('Boulder', 'Boulder', 'CO'),
('Denver', 'Denver', 'CO');

INSERT INTO amenity (amenity_name, amenity_description)
VALUES
('Lap Lanes', 'Dedicated pool space for lap swimming'),
('Hot Tub', 'Hot tub located adjacent to the pool area'),
('Kiddie Pool', 'Shallow pool space intended for younger children'),
('Lazy River', 'Loop-style floating area for recreation and lounging'),
('Water Slide', 'Pool area includes a water slide feature'),
('Outdoor Pool', 'Pool is located outdoors');

INSERT INTO pool (pool_name, type, is_public, address, city_id)
VALUES
('Monument Valley Pool', 'Outdoor', true, '220 Mesa Road', 1),
('Wilson Ranch Pool', 'Outdoor', true, '2335 Allegheny Drive', 1),
('Scott Carpenter Pool', 'Outdoor', true, '1505 30th Street', 2);

INSERT INTO pool_amenity (pool_id, amenity_id)
VALUES
(1, 1),
(1, 6),
(2, 3),
(2, 5),
(2, 6),
(3, 1),
(3, 3),
(3, 5),
(3, 6);

Select * from City;