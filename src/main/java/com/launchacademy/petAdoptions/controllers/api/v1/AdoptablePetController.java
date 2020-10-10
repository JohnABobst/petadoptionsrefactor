package com.launchacademy.petAdoptions.controllers.api.v1;

import com.launchacademy.petAdoptions.models.AdoptablePet;
import com.launchacademy.petAdoptions.models.PetType;
import com.launchacademy.petAdoptions.repositories.AdoptablePetRepository;
import com.launchacademy.petAdoptions.repositories.PetTypeRepository;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AdoptablePetController {
  private final AdoptablePetRepository adoptablePetRepository;
  private final PetTypeRepository petTypeRepository;
  private class NotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NotFoundHandler(NotFoundException exception) {
      return exception.getMessage();
    }
  }

  public AdoptablePetController(AdoptablePetRepository adoptablePetRepository, PetTypeRepository petTypeRepository) {
    this.adoptablePetRepository = adoptablePetRepository;
    this.petTypeRepository = petTypeRepository;
  }

  @GetMapping("/pets/{petType}")
  public Iterable<AdoptablePet> getPetsByType(@PathVariable String petType) {
    return adoptablePetRepository.findByPetTypeType(petType);
  }

  @GetMapping("/pets/{petType}/{petId}")
  public AdoptablePet getPetById(@PathVariable String petType, @PathVariable Integer petId) {
    Optional<PetType> type = petTypeRepository.findByType(petType);
    return adoptablePetRepository.findByIdAndPetType(petId, type).orElseThrow(NotFoundException::new);
  }
}
