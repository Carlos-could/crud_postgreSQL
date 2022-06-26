package com.carlos.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carlos.crud.model.Schueler;

@Repository
public interface ISchuelerRepository extends JpaRepository<Schueler, Long> {
}
