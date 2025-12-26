package dip;

// 1. Interface de haut niveau (abstraction)
interface Database {
    void save(String data);
}

// 2. Implémentations concrètes (détails de bas niveau)

// Implémentation MySQL
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

// Implémentation MongoDB
class MongoDBDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }
}

// Implémentation PostgreSQL (ajout facile)
class PostgreSQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to PostgreSQL: " + data);
    }
}

// Implémentation pour les tests (Mock)
class MockDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("[TEST] Mock save: " + data);
    }
    
    public String getLastSavedData() {
        return "Mock data saved";
    }
}

// 3. Classe de haut niveau qui dépend d'une abstraction
public class OrderProcessor {
    private Database database; // Dépendance abstraite
    
    // Injection de dépendance via constructeur
    public OrderProcessor(Database database) {
        this.database = database;
    }
    
    public void processOrder(String order) {
        // Logique métier
        System.out.println("Processing order: " + order);
        database.save(order);
        System.out.println("Order processed successfully!");
    }
    
    // setter pour changer la dépendance
    public void setDatabase(Database database) {
        this.database = database;
    }
}

// 4. Classe Main qui configure les dépendances
public class MainDIP {
    public static void main(String[] args) {
        System.out.println("=== APRÈS REFACTORING (Respect DIP) ===");
        
        // Configuration 1 : MySQL
        System.out.println("\n--- Configuration MySQL ---");
        Database mysql = new MySQLDatabase();
        OrderProcessor processor1 = new OrderProcessor(mysql);
        processor1.processOrder("Commande client 1");
        
        // Configuration 2 : MongoDB (changement facile)
        System.out.println("\n--- Configuration MongoDB ---");
        Database mongo = new MongoDBDatabase();
        OrderProcessor processor2 = new OrderProcessor(mongo);
        processor2.processOrder("Commande client 2");
        
        // Configuration 3 : PostgreSQL (extension facile)
        System.out.println("\n--- Configuration PostgreSQL ---");
        Database postgres = new PostgreSQLDatabase();
        OrderProcessor processor3 = new OrderProcessor(postgres);
        processor3.processOrder("Commande client 3");
        
        // Configuration 4 : Mock pour tests
        System.out.println("\n--- Configuration Mock (pour tests) ---");
        MockDatabase mock = new MockDatabase();
        OrderProcessor processor4 = new OrderProcessor(mock);
        processor4.processOrder("Test order");
        
        // Changer de base de données à la volée
        System.out.println("\n--- Changement dynamique de base ---");
        OrderProcessor flexibleProcessor = new OrderProcessor(mysql);
        flexibleProcessor.processOrder("Commande avec MySQL");
        
        // Changement vers MongoDB
        flexibleProcessor.setDatabase(mongo);
        flexibleProcessor.processOrder("Même commande avec MongoDB");
    }
}

// 5. Autre exemple : Service de notification avec DIP
interface NotificationService {
    void sendNotification(String message);
}

class EmailService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class OrderService {
    private Database database;
    private NotificationService notificationService;
    
    public OrderService(Database database, NotificationService notificationService) {
        this.database = database;
        this.notificationService = notificationService;
    }
    
    public void placeOrder(String order) {
        database.save(order);
        notificationService.sendNotification("Order placed: " + order);
    }
}