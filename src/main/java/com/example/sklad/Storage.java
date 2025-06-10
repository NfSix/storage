package com.example.sklad;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Класс, отвечающий за создание сущностей в БД
 * @version 1.0.0
 */


@Entity
@Getter
@Setter
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String type;

    private LocalDate exportdate;

    private String driver;

    private LocalDate importdate;

}
