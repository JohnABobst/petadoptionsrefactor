package com.launchacademy.petAdoptions.seeders;

import com.launchacademy.petAdoptions.models.AdoptablePet;
import com.launchacademy.petAdoptions.models.PetType;
import com.launchacademy.petAdoptions.models.SurrenderApplication;
import com.launchacademy.petAdoptions.repositories.AdoptablePetRepository;
import com.launchacademy.petAdoptions.repositories.PetTypeRepository;
import com.launchacademy.petAdoptions.repositories.SurrenderApplicationRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SurrenderApplicationSeeder {
  private final AdoptablePetRepository adoptablePetRepository;
  private final SurrenderApplicationRepository surrenderApplicationRepository;
  private final PetTypeRepository petTypeRepository;

  @Autowired
  public SurrenderApplicationSeeder(PetTypeRepository petTypeRepository, AdoptablePetRepository adoptablePetRepository, SurrenderApplicationRepository surrenderApplicationRepository) {
    this.adoptablePetRepository = adoptablePetRepository;
    this.petTypeRepository = petTypeRepository;
    this.surrenderApplicationRepository = surrenderApplicationRepository;
  }

  public void seed() {
    if (!surrenderApplicationRepository.findByName("John Snow").isPresent()) {
      SurrenderApplication surrenderApplication = new SurrenderApplication();
      surrenderApplication.setName("John Snow");
      surrenderApplication.setPhoneNumber("408-657-4567");
      surrenderApplication.setEmail("jon.snow@nightswatch.com");
      surrenderApplication.setPetName("Ghost");
      surrenderApplication.setPetAge(4);
      Optional<PetType> petType = petTypeRepository.findByType("dogs");
      if (petType.isPresent()) surrenderApplication.setPetType(petType.get());
      surrenderApplication.setPetImageUrl("https://www.thewrap.com/wp-content/uploads/2017/08/game-of-thrones-what-happened-to-ghost.jpg");
      surrenderApplication.setVaccinationStatus(false);
      surrenderApplication.setApplicationStatus(false);
      surrenderApplicationRepository.save(surrenderApplication);

      AdoptablePet newPet = new AdoptablePet();
      newPet.setName("Ghost");
      newPet.setImageUrl(surrenderApplication.getPetImageUrl());
      newPet.setAge(4);
      newPet.setVaccinationStatus(false);
      newPet.setAdoptionStory("They forgot about me");
      newPet.setAdoptionStatus(false);
      newPet.setPetType(surrenderApplication.getPetType());
      adoptablePetRepository.save(newPet);
    }
  }
}
