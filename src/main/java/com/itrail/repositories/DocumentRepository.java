package com.itrail.repositories;

import java.util.Optional;

import com.itrail.models.Document;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

    @Query( "SELECT u FROM Document u WHERE u.numar = :numar")
    Optional<Document> findByNumar( String numar);
    @Query( "SELECT u FROM Document u WHERE u.snils = :snils")
    Optional<Document> findBySnils( String snils );
    @Query( "SELECT u FROM Document u WHERE u.polis = :polis")
    Optional<Document> findByPolis( String polis );   
    
}
