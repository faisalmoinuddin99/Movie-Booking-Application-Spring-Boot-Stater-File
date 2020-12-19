package com.upgrad.mba.entites;

import javax.persistence.*;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int status_id ;

    @Column(nullable = false, unique = true)
    private String status_name ;
}
