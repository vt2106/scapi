package com.scapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scapi.repository.ShapeRepository;

@Service
public class ShapeService {
	
	@SuppressWarnings("unused")
	private final ShapeRepository shapeRepository;
	
	@Autowired
	public ShapeService(ShapeRepository shapeRepository) {
		this.shapeRepository = shapeRepository;
	}
}