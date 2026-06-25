abstract class Shape {
	abstract double area();
	abstract double perimeter();
}

class Circle extends Shape {
	private final double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	double getRadius() {
		return radius;
	}

	@Override
	double area() {
		return Math.PI * radius * radius;
	}

	@Override
	double perimeter() {
		return 2 * Math.PI * radius;
	}
}

class Rectangle extends Shape {
	private double length;
	private double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	void setLength(double length) {
		this.length = length;
	}

	void setWidth(double width) {
		this.width = width;
	}

	double getLength() {
		return length;
	}

	double getWidth() {
		return width;
	}

	@Override
	double area() {
		return length * width;
	}

	@Override
	double perimeter() {
		return 2 * (length + width);
	}
}

class Triangle extends Shape {
	private double sideA;
	private double sideB;
	private double sideC;

	Triangle(double sideA, double sideB, double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	void setSides(double sideA, double sideB, double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	@Override
	double area() {
		double s = (sideA + sideB + sideC) / 2;
		return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
	}

	@Override
	double perimeter() {
		return sideA + sideB + sideC;
	}
}

class ShapeHierarchy {
	public static void main(String[] args) {
		Shape[] shapes = {
			new Circle(5),
			new Rectangle(4, 6),
			new Triangle(3, 4, 5)
		};

		System.out.println("=== Shape Area Report ===\n");
		for (Shape shape : shapes) {
			System.out.println(shape.getClass().getSimpleName() + ":");
			System.out.printf("  Area: %.2f\n", shape.area());
			System.out.printf("  Perimeter: %.2f\n\n", shape.perimeter());
		}
	}
}
