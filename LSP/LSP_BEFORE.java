package lsp;

// Classe Rectangle
class Rectangle {
    protected int width;
    protected int height;
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getArea() {
        return width * height;
    }
}

// Classe Square qui hérite de Rectangle - VIOLATION LSP
class Square extends Rectangle {
    
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Pour un carré, width = height
    }
    
    @Override
    public void setHeight(int height) {
        this.width = height; // Pour un carré, width = height
        this.height = height;
    }
}

// Classe Main qui démontre le problème
public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== AVANT REFACTORING (Violation LSP) ===");
        
        // Test avec Rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(3);
        System.out.println("Aire du Rectangle = " + rectangle.getArea()); // 15
        
        // Test avec Square (problème LSP)
        Rectangle square = new Square(); // Square utilisé comme Rectangle
        
        // On s'attend à ce que ce soit un rectangle 4x5 (aire = 20)
        square.setWidth(4);
        square.setHeight(5);
        
        System.out.println("Aire attendue pour 4x5 = " + (4 * 5)); // 20
        System.out.println("Aire réelle du Carré = " + square.getArea()); // 25 !!!
        
        // PROBLÈME : Square ne se comporte pas comme un Rectangle
        // Après setWidth(4) et setHeight(5), on obtient 5x5, pas 4x5
    }
}