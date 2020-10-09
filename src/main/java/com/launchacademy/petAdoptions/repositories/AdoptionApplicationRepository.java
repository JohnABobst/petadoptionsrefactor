package com.launchacademy.petAdoptions.repositories;

import com.launchacademy.petAdoptions.models.AdoptionApplication;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdoptionApplicationRepository extends PagingAndSortingRepository<AdoptionApplication, Integer> {

  Optional<AdoptionApplication> findByName(String name);
}
