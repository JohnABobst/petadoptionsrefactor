package com.launchacademy.petAdoptions.controllers.api.v1;

import com.launchacademy.petAdoptions.models.AdoptablePet;
import com.launchacademy.petAdoptions.models.AdoptionApplication;
import com.launchacademy.petAdoptions.repositories.AdoptablePetRepository;
import com.launchacademy.petAdoptions.repositories.AdoptionApplicationRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AdoptionApplicationController {
  private final AdoptionApplicationRepository adoptionApplicationRepository;
  private final AdoptablePetRepository adoptablePetRepository;

  public AdoptionApplicationController(AdoptionApplicationRepository adoptionApplicationRepository, AdoptablePetRepository adoptablePetRepository) {
    this.adoptionApplicationRepository = adoptionApplicationRepository;
    this.adoptablePetRepository = adoptablePetRepository;
  }

  @PostMapping("/petadoptions/{petId}")
  public AdoptionApplication newAdoptionApplication(@RequestBody AdoptionApplication adoptionApplication, @PathVariable Integer petId) {
    Optional<AdoptablePet> pet = adoptablePetRepository.findById(petId);
    if (pet.isPresent()) adoptionApplication.setPet(pet.get());
    adoptionApplication.setApplicationStatus("You're application is being processed");
    return adoptionApplicationRepository.save(adoptionApplication);
  }
}
