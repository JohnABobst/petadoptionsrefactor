package com.launchacademy.petAdoptions.seeders;

import com.launchacademy.petAdoptions.models.AdoptablePet;
import com.launchacademy.petAdoptions.models.AdoptionApplication;
import com.launchacademy.petAdoptions.repositories.AdoptablePetRepository;
import com.launchacademy.petAdoptions.repositories.AdoptionApplicationRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdoptionApplicationSeeder {
  private final AdoptionApplicationRepository adoptionApplicationRepository;
  private final AdoptablePetRepository adoptablePetRepository;

  @Autowired
  public AdoptionApplicationSeeder(AdoptablePetRepository adoptablePetRepository, AdoptionApplicationRepository adoptionApplicationRepository) {
    this.adoptionApplicationRepository = adoptionApplicationRepository;
    this.adoptablePetRepository = adoptablePetRepository;
  }


  public void seed() {
    if (!adoptionApplicationRepository.findByName("Jenny").isPresent()) {
      AdoptionApplication adoptionApplication = new AdoptionApplication();
      adoptionApplication.setName("Jenny");
      adoptionApplication.setPhoneNumber("555-867-5309");
      adoptionApplication.setEmail("foragoodtime@call.com");
      adoptionApplication.setHomeStatus("Wouldn't you like to know");
      adoptionApplication.setApplicationStatus("Pending");
      Optional<AdoptablePet> adoptablePet = adoptablePetRepository.findByName("Morty");
      if (adoptablePet.isPresent()) adoptionApplication.setPet(adoptablePet.get());
      adoptionApplicationRepository.save(adoptionApplication);
    }
  }

}
