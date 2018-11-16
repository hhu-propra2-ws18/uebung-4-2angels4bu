package de.hhu.propra.db.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Auto{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String farbe;
    private String marke;
    private int hubraum;

}
