package com.launchacademy.petAdoptions.controllers.api.v1;

import com.launchacademy.petAdoptions.models.AdoptablePet;
import com.launchacademy.petAdoptions.repositories.AdoptablePetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AdoptablePetController {
  private final AdoptablePetRepository adoptablePetRepository;

  public AdoptablePetController(AdoptablePetRepository adoptablePetRepository) {
    this.adoptablePetRepository = adoptablePetRepository;
  }

  @GetMapping("/pets/{petType}")
  public Iterable<AdoptablePet> getPetsByType(@PathVariable String petType) {
    return adoptablePetRepository.findByPetTypeType(petType);
  }

  @GetMapping("/pet/{petId}")
  public AdoptablePet getPetById(@PathVariable Integer petId) {
    return adoptablePetRepository.findById(petId).get();

  }
}
