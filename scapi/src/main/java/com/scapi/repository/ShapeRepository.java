package com.scapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scapi.shape.AbstractShape;

@Repository
public interface ShapeRepository extends JpaRepository<AbstractShape, Long> {}