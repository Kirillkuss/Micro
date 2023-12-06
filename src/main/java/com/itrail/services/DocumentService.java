package com.itrail.services;

import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;
import com.itrail.models.Document;
import com.itrail.repositories.DocumentRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    public List<Document> findAll(){
        return documentRepository.findAll();
    }

    @Transactional
    public Document addDocument( Document document ){
        if( documentRepository.findByNumar( document.getNumar() ).isPresent() ) throw new IllegalArgumentException( "Документ с таким номером уже существует");
        if( documentRepository.findBySnils( document.getSnils() ).isPresent() ) throw new IllegalArgumentException( "Документ с таким СНИЛС уже существует");
        if( documentRepository.findByPolis( document.getPolis() ).isPresent() ) throw new IllegalArgumentException( "Документ с таким полисом уже существует");
        return documentRepository.update( document );
    }

    public Document findById( Long id ){
        return documentRepository.findById( id ).orElseThrow( () -> new NoSuchElementException("Документа с таким ИД нет"));
    }


    
}
