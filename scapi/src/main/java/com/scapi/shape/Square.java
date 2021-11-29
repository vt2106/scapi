package com.scapi.shape;

public class Square extends AbstractShape {
	
	@Override
	double identifyShape(AbstractShape shape) {
		String switchShape = shape.getShape();
		if(switchShape.equals("square"))
			return calculateArea(shape);
		else return 0;
	}
	
	String demo(AbstractShape shape) {
		String shapeString = ("id=" + getId() + ", shape=" + shape.getShape() + ", dimension1=" + getDimension1() + ", dimension2=" + getDimension2()  + ", area=" + calculateArea(shape));
		return shapeString;
	}

    public double calculateArea(AbstractShape shape) {
        double area = (double)(shape.getDimension1()*shape.getDimension1());
        return area;
    }

}