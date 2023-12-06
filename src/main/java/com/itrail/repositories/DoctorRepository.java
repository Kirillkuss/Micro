package com.itrail.repositories;

import com.itrail.models.Doctor;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
}

