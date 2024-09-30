package com.lawencon.shape;

public class App {
	private Validator validate = new Validator();
	
	public static void main(String[] args) {
		App app = new App();
		app.startApp();
	}
	
	private void startApp(){
		System.out.println("=== Menu ===");
		System.out.println("1. List Shape");
		System.out.println("2. Exit");
		
		System.out.print("Input menu :");
		byte option = ScannerUtil.scanByte();
		switch(option) {
		case 1 :
			listShape();
			break;
		case 2:
			exit();
			break;
		default :
			System.out.println("Input Not Valid!!!");
			startApp();
			break;
		}
	}
	
	private void listShape() {
		System.out.println("==== List Shape ====");
		System.out.println("1.Square");
		System.out.println("2.Rectanggle");
		System.out.println("3.Triangle");
		System.out.println("4.Circle");
		System.out.println("5.Back");
		
		System.out.print("Input :");
		byte option = ScannerUtil.scanByte();
		switch(option) {
		case 1:
			square();
			break;
			
		case 2:
			rectangle();
			break;
		case 3:
			triangle();
			break;
		case 4 :
			circle();
			break;
		case 5 :
			startApp();
			break;
		default :
			System.out.println("Input Not Valid!!!");
			listShape();
			break;
		}
	}
	
	private void circle() {
		System.out.println("==== Triangle ====");
		System.out.print("Input radius circle: ");
		double radius = ScannerUtil.scanDouble();
		if(!validate.isValidNumber(radius)){
			circle();
		}
		
		Circle circle = new Circle(radius);

		System.out.println("Area Circle : " + circle.areaShapeDouble());
		System.out.println("Perimeter Circle : " + circle.perimeterShapeDouble());	
		listShape();
		
		
	}

	private void triangle() {
		System.out.println("==== Triangle ====");
		System.out.print("Input Base Triangle: ");
		double base = ScannerUtil.scanDouble();
		if(!validate.isValidNumber(base)){
			triangle();
		}
		System.out.print("Input height Triangle :");
		double hight = ScannerUtil.scanDouble();
		if(!validate.isValidNumber(hight)){
			triangle();
		}
		Triangle triangle = new Triangle(base, hight);
		
		System.out.println("Area Triangle : " + triangle.areaShapeDouble());
		System.out.println("Perimeter Rectangle : " + triangle.perimeterShapeDouble());	
		listShape();
		
	}

	private void rectangle() {
		System.out.println("==== Rectangle ====");
		System.out.print("Input side Rectangle: ");
		double side = ScannerUtil.scanDouble();
		if(!validate.isValidNumber(side)){
			rectangle();
		}
		System.out.print("Input Lenght Rectangle :");
		double lenght = ScannerUtil.scanDouble();
		if(!validate.isValidNumber(lenght)){
			rectangle();
		}
		Rectangle rectangle = new Rectangle(side, lenght);
		
		System.out.println("Area Rectangle : " + rectangle.areaShapeDouble());
		System.out.println("Perimeter Rectangle : " + rectangle.perimeterShapeDouble());	
		listShape();
		
	}

	private void square() {
		System.out.println("==== Square ====");
		System.out.print("Input side Square: ");
		double side = ScannerUtil.scanDouble();
		if(!validate.isValidNumber(side)){
			square();
		}
		Square square = new Square(side, side);
		
		System.out.println("Area Square : " + square.areaShapeDouble());
		System.out.println("Perimeter Square : " + square.perimeterShapeDouble());	
		listShape();
	}
	
	private void exit(){
		System.out.println("!!!Exit!!!");
		System.exit(0);
	}

}
