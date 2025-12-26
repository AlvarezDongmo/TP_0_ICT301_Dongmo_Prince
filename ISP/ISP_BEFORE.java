package isp;

// Interface Worker trop large - VIOLATION ISP
public interface Worker {
    void work();
    void eat();
}

// Classe HumanWorker implémente Worker
class HumanWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Les humains travaillent");
    }
    
    @Override
    public void eat() {
        System.out.println("Les humains mangent");
    }
}

// Classe RobotWorker implémente Worker - PROBLÈME ICI 
class RobotWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Les Robots travaillent sans fatigue");
    }
    
    @Override
    public void eat() {
        // Les robots ne mangent pas !
        System.out.println("L'on ne doit pas faire manger un robot");
        throw new UnsupportedOperationException("Les Robots ne mangent pas");
    }
}

// Classe Main qui démontre le problème
public class MainAvant {
    public static void main(String[] args) {
        System.out.println("=== AVANT REFACTORING (Violation ISP) ===");
        
        // Humain fonctionne correctement
        Worker human = new HumanWorker();
        human.work();
        human.eat();
        
        // Robot a un problème
        Worker robot = new RobotWorker();
        robot.work();
        
        try {
            robot.eat(); // Lance une exception !!!
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Problème : Robot implémente une méthode qu'il ne devrait pas avoir !");
        }
        
        // Autre problème : Que se passe-t-il si on a une Machine qui ne travaille pas mais qui mange ?
        // Impossible avec cette interface !
    }
}