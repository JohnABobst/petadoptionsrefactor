package com.launchacademy.petAdoptions.seeders;

import com.launchacademy.petAdoptions.models.PetType;
import com.launchacademy.petAdoptions.repositories.PetTypeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetTypeSeeder {
  private PetTypeRepository petTypeRepository;

  @Autowired
  public PetTypeSeeder(PetTypeRepository petTypeRepository) {
    this.petTypeRepository = petTypeRepository;
  }


  public void seed() {
    Map<String, String> seedMap = new HashMap<String, String>();
    seedMap.put("dogs", "Also fluffy, definitely not aloof, will wait longer than cats to eat you because they actually love you.");
    seedMap.put("cats", "Fluffy and aloof, will eat you after three days if you die.");
    seedMap.put("hamsters", "Will eat their friends, wives, children.  Not really great people, cuz of the cannabilism.");
    seedMap.put("other", "Anything that is not a cat, dog, or hamster.  Maybe it is mythical, maybe it is an illegal animal that you are not supposed to have.  You criminal!");

    Map<String, String> imageMap = new HashMap<String, String>();
    imageMap.put("dogs", "https://i.insider.com/5df126b679d7570ad2044f3e?width=900&format=jpeg&auto=webp");
    imageMap.put("cats", "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png");
    imageMap.put("other", "https://imaginarycreatureauthority.files.wordpress.com/2017/06/batman-unicorn.jpg");
    imageMap.put("hamsters", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Pearl_Winter_White_Russian_Dwarf_Hamster_-_Front.jpg/1920px-Pearl_Winter_White_Russian_Dwarf_Hamster_-_Front.jpg");

    for(String name : seedMap.keySet()) {
      List petTypes = petTypeRepository.findAllByType(name);
      if(petTypes.size() == 0) {
        PetType petType = new PetType();
        petType.setType(name);
        petType.setDescription(seedMap.get(name));
        petType.setImageUrl(imageMap.get(name));
        petTypeRepository.save(petType);
      }
    }
  }
}
