package com.demo.performancetester.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.performancetester.models.Counter;

public interface CounterRepository extends JpaRepository<Counter, Long> {

}
