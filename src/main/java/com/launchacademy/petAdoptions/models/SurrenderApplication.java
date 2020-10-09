package com.launchacademy.petAdoptions.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pet_surrender_applications")
@NoArgsConstructor
@Getter
@Setter
public class SurrenderApplication {
  @Id
  @SequenceGenerator(name="pet_surrender_applications_generator", sequenceName = "pet_surrender_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pet_surrender_applications_generator")
  @Column(name="id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "email",  nullable = false)
  private String email;

  @Column(name = "pet_name", nullable = false)
  private String petName;

  @Column(name = "pet_age", nullable = false)
  private Integer petAge;

  @ManyToOne
  @JoinColumn(name = "pet_type_id", nullable = false)
  private PetType petType;

  @Column(name = "pet_image_url", nullable=false)
  private String petImageUrl;

  @Column(name="vaccination_status", nullable = false)
  private Boolean vaccinationStatus;

  @Column(name = "application_status",  nullable = false)
  private Boolean applicationStatus;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPetName() {
    return petName;
  }

  public void setPetName(String petName) {
    this.petName = petName;
  }

  public Integer getPetAge() {
    return petAge;
  }

  public void setPetAge(Integer petAge) {
    this.petAge = petAge;
  }

  public PetType getPetType() {
    return petType;
  }

  public void setPetType(PetType petType) {
    this.petType = petType;
  }

  public String getPetImageUrl() {
    return petImageUrl;
  }

  public void setPetImageUrl(String petImageUrl) {
    this.petImageUrl = petImageUrl;
  }

  public Boolean getVaccinationStatus() {
    return vaccinationStatus;
  }

  public void setVaccinationStatus(Boolean vaccinationStatus) {
    this.vaccinationStatus = vaccinationStatus;
  }

  public Boolean getApplicationStatus() {
    return applicationStatus;
  }

  public void setApplicationStatus(Boolean applicationStatus) {
    this.applicationStatus = applicationStatus;
  }
}
