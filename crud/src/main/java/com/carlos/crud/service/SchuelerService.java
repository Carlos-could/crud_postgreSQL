package com.carlos.crud.service;

import com.carlos.crud.model.Schueler;
import com.carlos.crud.repository.ISchuelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchuelerService {
    @Autowired
    private ISchuelerRepository iSchuelerRepository;

    public Schueler speichernSchueler(Schueler schueler){
        if (schueler.getId() == null) {
            return iSchuelerRepository.save(schueler);
        }
        return null;
    }

    public Page<Schueler> getAllSchueler(Integer page, Integer size, Boolean enablePagination){
        return iSchuelerRepository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
    }

    public Optional<Schueler> findById(Long id){
        return iSchuelerRepository.findById(id);
    }

    public void loeschenSchueler(Long id){
        iSchuelerRepository.deleteById(id);
    }

    public Schueler editSchueler (Schueler schueler) {
        if (schueler.getId() != null && iSchuelerRepository.existsById(schueler.getId())) {
            return iSchuelerRepository.save(schueler);
        }
        return null;
    }

    public boolean existByid(Long id) {
        return iSchuelerRepository.existsById(id);
    }
}
