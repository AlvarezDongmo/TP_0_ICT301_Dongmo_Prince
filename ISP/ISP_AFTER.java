package isp;

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface WorkableAndEatable extends Workable, Eatable {
}

class HumanWorker implements WorkableAndEatable {
    @Override
    public void work() {
        System.out.println("Les humains travaillent");
    }
    
    @Override
    public void eat() {
        System.out.println("Les humains mangent");
    }
}

class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Les Robots travaillent sans fatigue");
    }
}

class Animal implements Eatable {
    @Override
    public void eat() {
        System.out.println("Les animaux mangent");
    }
}

// Classe Main qui respecte ISP
public class MainISP {
    public static void main(String[] args) {
        System.out.println("=== APRÈS REFACTORING (Respect ISP) ===");
        
        HumanWorker human = new HumanWorker();
        human.work();
        human.eat();
        
        RobotWorker robot = new RobotWorker();
        robot.work();
        
        Animal animal = new Animal();
        animal.eat();
        
        // Utilisation polymorphique
        System.out.println("\n=== Utilisation avec interfaces ===");
        
        Workable[] workers = new Workable[2];
        workers[0] = new HumanWorker();
        workers[1] = new RobotWorker();
        
        for (Workable worker : workers) {
            worker.work(); // Tous peuvent travailler
        }
        
        Eatable[] eaters = new Eatable[2];
        eaters[0] = new HumanWorker();
        eaters[1] = new Animal();
        
        for (Eatable eater : eaters) {
            eater.eat(); // Tous peuvent manger
        }
    }
}