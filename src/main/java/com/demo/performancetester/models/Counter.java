package com.demo.performancetester.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "counter")
@Getter
@Setter
public class Counter {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "count")
    private long count;

}
