package com.upgrad.mba.entites;

import javax.persistence.*;

@Entity
@Table(name = "UserType")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userTypeId ;

    @Column(unique = true,columnDefinition = "varchar(255) default 'User'" )
    private  String userTypeName ;
}
