package ocp;

public class AreaCalculator {
    
    // VIOLATION OCP : À chaque nouvelle forme, on doit modifier cette classe
    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getWidth() * rectangle.getHeight();
        } else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        } else if (shape instanceof Triangle) {
            Triangle triangle = (Triangle) shape;
            return triangle.getBase() * triangle.getHeight() / 2;
        }
        throw new IllegalArgumentException("Unknown shape");
    }
}

class Rectangle {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

class Circle {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() { return radius; }
}

class Triangle {
    private double base;
    private double height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    public double getBase() { return base; }
    public double getHeight() { return height; }
}

class MainAvant {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();
        
        Rectangle rectangle = new Rectangle(4, 3);
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(6, 4);
        
        System.out.println("=== AVANT REFACTORING ===");
        System.out.println("Rectangle area: " + calculator.calculateArea(rectangle));
        System.out.println("Circle area: " + calculator.calculateArea(circle));
        System.out.println("Triangle area: " + calculator.calculateArea(triangle));
    }
}