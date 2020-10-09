package com.launchacademy.petAdoptions.repositories;

import com.launchacademy.petAdoptions.models.SurrenderApplication;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SurrenderApplicationRepository extends PagingAndSortingRepository<SurrenderApplication, Integer> {

  Optional<SurrenderApplication> findByName(String name);
}
