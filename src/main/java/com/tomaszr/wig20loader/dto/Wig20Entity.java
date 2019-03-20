package com.tomaszr.wig20loader.dto;

//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.hibernate.annotations.OptimisticLockType;



@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name = "intraday")

//@Table(name = "INTRADAY", uniqueConstraints = {
//        @UniqueConstraint(columnNames = "ID"),
//        @UniqueConstraint(columnNames = "EMAIL") })



//public class Wig20Entity
public class Wig20Entity implements Serializable
{
//    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATE")
    private String date;

    @Column(name = "HOUR")
    private String hour;

    @Column(name = "PRICE")
    private double price;


//    name char(15)
//    date int(8)
//    hour int(6)
//    price decimal(10,4)

    //Getters and setters
}
