package com.launchacademy.petAdoptions.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pet_types")
@NoArgsConstructor
@Getter
@Setter
public class PetType {
  @Id
  @SequenceGenerator(name="pet_type_generator", sequenceName = "pet_types_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pet_type_generator")
  @Column(name="id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "image_url", nullable = false)
  private String imageUrl;

  public Integer getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
