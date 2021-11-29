/*
 * Notes: Make Shape abstract
 */



package com.scapi.shape;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public abstract class AbstractShape {

	@Id
	@SequenceGenerator(name = "shape_sequence", sequenceName = "shape_sequence", allocationSize = 1)
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "shape_sequence")
	private Long id;
	private String shape;
	private double dimension1;
	private double dimension2;

	public AbstractShape() {}

	public AbstractShape(String shape, double dimension1) {
		this.shape = shape;
		this.dimension1 = dimension1;
	}

	public AbstractShape(Long id, String shape, double dimension1) {
		this.id = id;
		this.dimension1 = dimension1;
	}

	public AbstractShape(String shape, double dimension1, double dimension2) {
		this.shape = shape;
		this.dimension1 = dimension1;
		this.dimension2 = dimension2;
	}

	public AbstractShape(Long id, String shape, double dimension1, double dimension2) {
		this.id = id;
		this.shape = shape;
		this.dimension1 = dimension1;
		this.dimension2 = dimension2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public double getDimension1() {
		return dimension1;
	}

	public void setDimension1(double dimension1) {
		this.dimension1 = dimension1;
	}

	public double getDimension2() {
		return dimension2;
	}

	public void setDimension2(double dimension2) {
		this.dimension2 = dimension2;
	}

//	public String demo(Shape shape) {
//		ObjectMapper object = new ObjectMapper();
//		object.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
//		object.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
//		long id = getId();
//		double dimension1 = getDimension1();
//		setDimension1(dimension1);
//		double dimension2 = getDimension2();
//		double area = (double)shape.identifyShape(shape);
//
//		String shapeString = ("id=" + id + ", shape=" + shape.getShape() + ", dimension1=" + dimension1 + ", dimension2=" + dimension2  + ", area=" + area);
//
//
//		try {
//			object.writeValue(new File("target/json.txt"), shapeString);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return shapeString;
//
//	}

//	public double identifyShape(AbstractShape shape) {
//		String switchShape = shape.getShape();
//		switch (switchShape) {
//		case "circle" :
//			Circle myCircle = new Circle();
//			return myCircle.calculateArea(shape);
//		case "square" :
//			Square mySquare = new Square();
//			return mySquare.calculateArea(shape);
//		case "rectangle" :
//			Rectangle myRectangle = new Rectangle();
//			return myRectangle.calculateArea(shape);
//		default :
//			throw new ErrorResponse("Misspelling or incorrect input");
//		}
//	}
	abstract String demo(AbstractShape shape);
	abstract double identifyShape(AbstractShape shape);
}
