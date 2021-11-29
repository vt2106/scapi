package com.scapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scapi.repository.ShapeRepository;
import com.scapi.service.ShapeService;
import com.scapi.shape.AbstractShape;
import exceptions.RecordNotFoundException;

@RestController
public abstract class ShapeController {
	
	@SuppressWarnings("unused")
	private final ShapeService shapeService;
	
	@Autowired
	ShapeRepository repo;
	
	@Autowired
	public ShapeController(ShapeService shapeService) {
		this.shapeService = shapeService;
	}
	
	@DeleteMapping("/shape/{id}")
	public String deleteShape(@PathVariable long id) {
		AbstractShape shape = repo.getById(id);
		repo.delete(shape);
		return "deleted";
	}
	
	@PostMapping(path="/shape")
	public AbstractShape addShape(@RequestBody AbstractShape shape) {
		String shapeString = cleanUp(shape.getShape());
		shape.setShape(shapeString);
        shape.setDimension1(shape.getDimension1());
        System.out.println(shape);
		return repo.save(shape);
	}
	
	@GetMapping(path="/shape")
	public List<AbstractShape> getShapes() {
		return repo.findAll();
	}
	
	@PutMapping(path="/shape/{id}")
	public AbstractShape updateShape(@PathVariable(value = "id") Long id, @Validated @RequestBody AbstractShape shape) {
	    AbstractShape updateShape = repo.findById(id).orElseThrow(() -> new RecordNotFoundException("Shape not found for this id :: " + id));
        String shapeString = cleanUp(shape.getShape());
        updateShape.setId(shape.getId());
        updateShape.setShape(shapeString);
        updateShape.setDimension1(shape.getDimension1());
        updateShape.setDimension2(shape.getDimension2());
//        shape.identifyShape(updateShape);
        return repo.save(updateShape);
//        final String finalShape = shape.demo(updateShape);
//        return ResponseEntity.ok(finalShape);
	    }
	
	@RequestMapping("/shape/{id}")
	public Optional<AbstractShape> getShape(@PathVariable("id") Long id) {
		System.out.println(repo.findById(id));
		return repo.findById(id);
	}
	
    static String cleanUp(String userInput) {
        userInput = userInput.toLowerCase();
        return userInput.replaceAll("\\s", "");
    }
  
}

