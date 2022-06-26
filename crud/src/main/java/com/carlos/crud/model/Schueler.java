package com.carlos.crud.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Schueler")
public class Schueler {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String vorname;
    private String nachname;
    private Integer alter;
}
