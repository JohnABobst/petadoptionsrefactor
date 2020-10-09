DROP TABLE IF EXISTS pet_surrender_applications;

CREATE TABLE pet_surrender_applications (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    phone_number VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    pet_name VARCHAR NOT NULL,
    pet_age INTEGER,
    pet_type_id INTEGER REFERENCES pet_types(id),
    pet_image_url VARCHAR NOT NULL,
    vaccination_status BOOLEAN,
    application_status BOOLEAN NOT NULL
)