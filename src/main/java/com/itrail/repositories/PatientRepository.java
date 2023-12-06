package com.itrail.repositories;

import java.util.List;
import java.util.Optional;

import com.itrail.models.Patient;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query( "SELECT u FROM Patient u WHERE u.surname = :word or u.name = :word or u.fullName = :word or u.phone =:word")
    List<Patient> findPatientByWord( String word );

    @Query( "SELECT u FROM Patient u WHERE u.document.idDocument = :id")
    Optional<Patient> findPatientByIdDocument( Long id );

    @Query ( "SELECT u FROM Patient u WHERE u.phone = :phoneNumber")
    Optional<Patient> findByPhone( String phoneNumber );
    
}
