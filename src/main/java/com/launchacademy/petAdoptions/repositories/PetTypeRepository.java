package com.launchacademy.petAdoptions.repositories;

import com.launchacademy.petAdoptions.models.PetType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PetTypeRepository extends PagingAndSortingRepository<PetType, Integer> {
  public List<PetType> findAllByType(String type);

  public Optional<PetType> findByType(String type);
}
