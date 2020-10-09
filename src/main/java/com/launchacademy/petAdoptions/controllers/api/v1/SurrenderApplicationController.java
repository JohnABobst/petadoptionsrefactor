package com.launchacademy.petAdoptions.controllers.api.v1;

import com.launchacademy.petAdoptions.models.AdoptablePet;
import com.launchacademy.petAdoptions.models.PetType;
import com.launchacademy.petAdoptions.models.SurrenderApplication;
import com.launchacademy.petAdoptions.repositories.AdoptablePetRepository;
import com.launchacademy.petAdoptions.repositories.PetTypeRepository;
import com.launchacademy.petAdoptions.repositories.SurrenderApplicationRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SurrenderApplicationController {
  private final SurrenderApplicationRepository surrenderApplicationRepository;
  private final PetTypeRepository petTypeRepository;
  private final AdoptablePetRepository adoptablePetRepository;

  @Autowired
  public SurrenderApplicationController(
      SurrenderApplicationRepository surrenderApplicationRepository,
      PetTypeRepository petTypeRepository,
      AdoptablePetRepository adoptablePetRepository) {
    this.surrenderApplicationRepository = surrenderApplicationRepository;
    this.petTypeRepository = petTypeRepository;
    this.adoptablePetRepository = adoptablePetRepository;
  }

  @PostMapping("/adoptions/new/{type_id}")
  public SurrenderApplication newSurrenderApplication(@RequestBody SurrenderApplication surrenderApplication, @PathVariable Integer type_id) {
    Optional<PetType> type = petTypeRepository.findById(type_id);
    surrenderApplication.setPetType(type.get());
    surrenderApplication.setApplicationStatus(false);
    AdoptablePet pet = new AdoptablePet();
    pet.setName(surrenderApplication.getName());
    pet.setImageUrl(surrenderApplication.getPetImageUrl());
    pet.setAge(surrenderApplication.getPetAge());
    pet.setVaccinationStatus(surrenderApplication.getVaccinationStatus());
    pet.setAdoptionStory("I am looking for a new home");
    pet.setAdoptionStatus(false);
    pet.setPetType(surrenderApplication.getPetType());
    adoptablePetRepository.save(pet);
    return surrenderApplicationRepository.save(surrenderApplication);
  }
}
