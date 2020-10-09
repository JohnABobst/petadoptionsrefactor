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
@Table(name="adoption_applications")
@Getter
@Setter
@NoArgsConstructor
public class AdoptionApplication {
  @Id
  @SequenceGenerator(name="adoption_application_generator", sequenceName = "adoption_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="adoption_application_generator")
  @Column(name="id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "email",  nullable = false)
  private String email;

  @Column(name = "home_status", nullable = false)
  private String homeStatus;

  @Column(name = "application_status",  nullable = false)
  private String applicationStatus;

  @ManyToOne
  @JoinColumn(name = "pet_id",  nullable = false)
  private AdoptablePet pet;

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

  public String getHomeStatus() {
    return homeStatus;
  }

  public void setHomeStatus(String homeStatus) {
    this.homeStatus = homeStatus;
  }

  public String getApplicationStatus() {
    return applicationStatus;
  }

  public void setApplicationStatus(String applicationStatus) {
    this.applicationStatus = applicationStatus;
  }

  public AdoptablePet getPet() {
    return pet;
  }

  public void setPet(AdoptablePet pet) {
    this.pet = pet;
  }
}
