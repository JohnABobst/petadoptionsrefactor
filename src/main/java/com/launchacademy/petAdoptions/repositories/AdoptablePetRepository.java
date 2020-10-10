package com.launchacademy.petAdoptions.repositories;

import com.launchacademy.petAdoptions.models.AdoptablePet;
import com.launchacademy.petAdoptions.models.PetType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdoptablePetRepository extends PagingAndSortingRepository<AdoptablePet, Integer>  {
  public Optional<AdoptablePet> findByName(String name);
  public List<AdoptablePet> findByPetTypeType(String type);
  Optional<AdoptablePet> findByIdAndPetType(Integer petId, Optional<PetType> species);
}
