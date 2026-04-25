# Colorado Outdoor Pool Finder API

## Core Entities
- City
- Pool
- Amenity
- Review

## Relationships
- One City has many Pools
- One Pool has many Reviews
- Many Pools have many Amenities

## Main CRUD Entity
- Pool

## Stretch Goal
- Weather-based pool recommendation

## Database Tables

### city
- city_id: BIGINT, primary key
- city_name: VARCHAR(100), not null
- county_name: VARCHAR(100), not null
- state: VARCHAR(2), not null

### pool
- pool_id: BIGINT, primary key
- pool_name: VARCHAR(150), not null
- address: VARCHAR(200), not null
- zip_code: VARCHAR(10), not null
- admission_fee: DECIMAL(6,2)
- opening_month: VARCHAR(20)
- closing_month: VARCHAR(20)
- has_lifeguard: BOOLEAN
- has_lap_lanes: BOOLEAN
- notes: TEXT
- city_id: BIGINT, foreign key

### amenity
- amenity_id: BIGINT, primary key
- amenity_name: VARCHAR(100), not null
- description: VARCHAR(255)

### review
- review_id: BIGINT, primary key
- reviewer_name: VARCHAR(100), not null
- rating: INT, not null
- comment: TEXT
- visit_date: DATE
- pool_id: BIGINT, foreign key

### pool_amenity
- pool_id: BIGINT, foreign key
- amenity_id: BIGINT, foreign key
- primary key: pool_id + amenity_id

## Relationship Summary

- city.city_id → pool.city_id
- pool.pool_id → review.pool_id
- pool.pool_id → pool_amenity.pool_id
- amenity.amenity_id → pool_amenity.amenity_id