package dip;

// Classe MySQLDatabase - implémentation concrète
class MySQLDatabase {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

// Classe OrderProcessor qui dépend d'une implémentation concrète 
public class OrderProcessor {
    private MySQLDatabase database; // Dépendance concrète
    
    public OrderProcessor() {
        // Création directe de la dépendance - couplage fort
        this.database = new MySQLDatabase();
    }
    
    public void processOrder(String order) {
        database.save(order);
    }
}
public class MainAvant {
    public static void main(String[] args) {
        System.out.println("=== AVANT REFACTORING (Violation DIP) ===");
        
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder("Données à sauvegarder");
        
        // PROBLÈMES :
        // 1. Si on veut changer pour MongoDB, il faut modifier OrderProcessor
        // 2. Difficile à tester (OrderProcessor crée sa propre base de données)
        // 3. Couplage fort avec MySQLDatabase
    }
}

// Autre problème : que faire si on veut ajouter PostgreSQL ?
class PostgreSQLDatabase {
    public void save(String data) {
        System.out.println("Saving to PostgreSQL: " + data);
    }
}

// Pour utiliser PostgreSQL, il faut modifier OrderProcessor !
class OrderProcessorPostgreSQL {
    private PostgreSQLDatabase database; // Nouvelle dépendance concrète
    
    public OrderProcessorPostgreSQL() {
        this.database = new PostgreSQLDatabase();
    }
    
    public void processOrder(String order) {
        database.save(order);
    }
}