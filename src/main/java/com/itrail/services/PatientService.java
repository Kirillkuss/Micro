package com.itrail.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.itrail.models.Document;
import com.itrail.models.Patient;
import com.itrail.repositories.DocumentRepository;
import com.itrail.repositories.PatientRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final DocumentRepository documentRepository;

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    @Transactional
    public Patient addPatient( Patient patient, Long idDocument ){
        if ( patientRepository.findByPhone(patient.getPhone()).isPresent() ) throw new IllegalArgumentException("Пациент с таким номером телефона существует");
        if ( patientRepository.findPatientByIdDocument( idDocument ).isPresent() ) throw new IllegalArgumentException("Неверный ИД документа");
        Optional<Document> document = documentRepository.findById( idDocument );
        if( document.isEmpty() ) throw new IllegalArgumentException("");
        patient.setDocument( document.orElse( null ));
        return patientRepository.update( patient );
    }

    public List<Patient> findByFIO( String fio ){
        return patientRepository.findPatientByWord( fio );
    }

}
