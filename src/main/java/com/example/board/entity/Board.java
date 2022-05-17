package com.example.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Board {
    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity - mysql, mariadb  sequence - oracle
    private Integer id;

    private String title;

    private String content;
}
