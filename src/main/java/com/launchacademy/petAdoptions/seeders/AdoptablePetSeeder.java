package com.launchacademy.petAdoptions.seeders;

import com.launchacademy.petAdoptions.models.AdoptablePet;
import com.launchacademy.petAdoptions.models.PetType;
import com.launchacademy.petAdoptions.repositories.AdoptablePetRepository;
import com.launchacademy.petAdoptions.repositories.PetTypeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdoptablePetSeeder {
  private AdoptablePetRepository adoptablePetRepository;
  private PetTypeRepository petTypeRepository;

  @Autowired
  public AdoptablePetSeeder(AdoptablePetRepository adoptablePetRepository, PetTypeRepository petTypeRepository) {
    this.adoptablePetRepository = adoptablePetRepository;
    this.petTypeRepository = petTypeRepository;
  }

  public void seed() {
    List<AdoptablePet> adoptablePets = new ArrayList<>();

    AdoptablePet pet1 = new AdoptablePet();
    pet1.setName("Rick");
    pet1.setImageUrl("https://www.indiewire.com/wp-content/uploads/2020/05/Rick-Morty-Rick-Five-Arms.png?resize=800,515");
    pet1.setAge(68);
    pet1.setVaccinationStatus(true);
    pet1.setAdoptionStory("I was not adopted and then I became adopted");
    pet1.setAdoptionStatus(true);
    Optional<PetType> petType = petTypeRepository.findByType("cats");
    if (petType.isPresent()) pet1.setPetType(petType.get());
    adoptablePets.add(pet1);

    AdoptablePet pet2 = new AdoptablePet();
    pet2.setName("Lady Amalthea");
    pet2.setImageUrl("https://assets.wired.com/photos/w_582/wp-content/uploads/2020/05/Cul-lastunicorn-W786CE.jpg");
    pet2.setAge(1000);
    pet2.setVaccinationStatus(true);
    pet2.setAdoptionStory("Why am I not called a unihorn?");
    pet2.setAdoptionStatus(false);
    Optional<PetType> petType2 = petTypeRepository.findByType("other");
    if (petType2.isPresent()) pet2.setPetType(petType2.get());
    adoptablePets.add(pet2);

    AdoptablePet pet3 = new AdoptablePet();
    pet3.setName("Snowball");
    pet3.setImageUrl("https://heavy.com/wp-content/uploads/2020/04/snuffles-e1585726869132.jpg?quality=65&strip=all&w=780");
    pet3.setAge(13);
    pet3.setVaccinationStatus(false);
    pet3.setAdoptionStory("I have not been adopted because I'm old?");
    pet3.setAdoptionStatus(true);
    Optional<PetType> petType3 = petTypeRepository.findByType("dogs");
    if (petType3.isPresent()) pet3.setPetType(petType3.get());
    adoptablePets.add(pet3);

    AdoptablePet pet4 = new AdoptablePet();
    pet4.setName("Morty");
    pet4.setImageUrl("https://vignette.wikia.nocookie.net/rickandmorty/images/4/41/Morty_Smith.jpg/revision/latest?cb=20200519152019");
    pet4.setAge(15);
    pet4.setVaccinationStatus(true);
    pet4.setAdoptionStory("Gosh gee, I dunno, Rick...");
    pet4.setAdoptionStatus(false);
    Optional<PetType> petType4 = petTypeRepository.findByType("hamsters");
    if (petType4.isPresent()) pet4.setPetType(petType4.get());
    adoptablePets.add(pet4);

    for (AdoptablePet pet : adoptablePets) {
      if (!adoptablePetRepository.findByName(pet.getName()).isPresent()) {
        adoptablePetRepository.save(pet);
      }
    }
  }
}
