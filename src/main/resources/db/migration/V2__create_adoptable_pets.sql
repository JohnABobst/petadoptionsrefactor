DROP TABLE IF EXISTS adoptable_pets;

CREATE TABLE adoptable_pets (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    img_url VARCHAR NOT NULL,
    age INTEGER NOT NULL,
    vaccination_status BOOLEAN NOT NULL,
    adoption_story TEXT NOT NULL,
    adoption_status BOOLEAN NOT NULL,
    type_id INTEGER REFERENCES pet_types(id)
);