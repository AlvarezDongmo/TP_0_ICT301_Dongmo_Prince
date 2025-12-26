package ocp;

// Interface Shape - fermée à la modification mais ouverte à l'extension
interface Shape {
    double calculateArea();
}

// Rectangle implémente Shape
class Rectangle implements Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Circle implémente Shape
class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Triangle implémente Shape (EXTENSION sans modifier AreaCalculator2)
class Triangle implements Shape {
    private double base;
    private double height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return base * height / 2;
    }
}

// Classe AreaCalculator2 - respecte OCP
public class AreaCalculator2 {
    // Méthode unique qui fonctionne pour toutes les formes
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}

public class Main {
    public static void main(String[] args) {
        AreaCalculator2 calculator = new AreaCalculator2();
        
        Shape rectangle = new Rectangle(4, 3);
        Shape circle = new Circle(5);
        Shape triangle = new Triangle(6, 4);
        
        System.out.println("=== APRÈS REFACTORING ===");
        System.out.println("Rectangle area: " + calculator.calculateArea(rectangle));
        System.out.println("Circle area: " + calculator.calculateArea(circle));
        System.out.println("Triangle area: " + calculator.calculateArea(triangle));
        
        // Ajout d'une nouvelle forme SANS modifier AreaCalculator2
        Shape square = new Square(5);
        System.out.println("Square area: " + calculator.calculateArea(square));
    }
}

// Nouvelle forme ajoutée SANS modifier les classes existantes
class Square implements Shape {
    private double side;
    
    public Square(double side) {
        this.side = side;
    }
    
    @Override
    public double calculateArea() {
        return side * side;
    }
}