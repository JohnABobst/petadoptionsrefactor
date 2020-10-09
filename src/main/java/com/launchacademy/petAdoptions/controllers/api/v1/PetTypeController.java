package com.launchacademy.petAdoptions.controllers.api.v1;
import com.launchacademy.petAdoptions.models.PetType;
import com.launchacademy.petAdoptions.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PetTypeController {
  private final PetTypeRepository petTypeRepository;

  @Autowired
  public PetTypeController(PetTypeRepository petTypeRepository) {
    this.petTypeRepository = petTypeRepository;
  }

  @GetMapping("/pet_types")
  public Iterable<PetType> getPetTypes() {
    return petTypeRepository.findAll();
  }
}
