DROP TABLE IF EXISTS adoption_applications;

CREATE TABLE adoption_applications (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    phone_number VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    home_status VARCHAR NOT NULL,
    application_status VARCHAR NOT NULL,
    pet_id INTEGER REFERENCES pet_types(id)
);