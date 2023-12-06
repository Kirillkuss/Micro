package com.itrail.services;

import java.util.List;
import java.util.NoSuchElementException;

import com.itrail.models.Doctor;
import com.itrail.repositories.DoctorRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public Doctor findById( Long id ){
        return doctorRepository.findById( id )
                               .orElseThrow( () -> new NoSuchElementException("Доктора с таким ИД нет"));
    }
    
}
