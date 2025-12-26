package lsp;

// Interface Shape commune
interface Shape {
    int getArea();
}

// Classe Square qui implémente Shape
class Square implements Shape {
    private int side;
    
    public Square(int side) {
        this.side = side;
    }
    
    public void setSide(int side) {
        this.side = side;
    }
    
    @Override
    public int getArea() {
        return side * side;
    }
}

// Classe Rectangle qui implémente Shape
class Rectangle implements Shape {
    private int width;
    private int height;
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public int getArea() {
        return width * height;
    }
}

// Classe Main qui respecte LSP
public class MainLSP2 {
    public static void main(String[] args) {
        System.out.println("=== APRÈS REFACTORING (Respect LSP) ===");
        
        // On peut utiliser Shape pour tous
        Shape square = new Square(3);
        Shape rectangle = new Rectangle(3, 4);
        
        System.out.println("Square Area : " + square.getArea()); // 9
        System.out.println("Rectangle Area: " + rectangle.getArea()); // 12
        
        // Test de substitution
        Shape[] shapes = new Shape[2];
        shapes[0] = new Square(5);
        shapes[1] = new Rectangle(2, 6);
        
        int totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea(); // Toutes les formes se comportent de la même façon
        }
        
        System.out.println("Total area: " + totalArea); // 25 + 12 = 37
    }
}

// Extension possible sans violation LSP
class Circle implements Shape {
    private int radius;
    
    public Circle(int radius) {
        this.radius = radius;
    }
    
    @Override
    public int getArea() {
        return (int) (Math.PI * radius * radius);
    }
}