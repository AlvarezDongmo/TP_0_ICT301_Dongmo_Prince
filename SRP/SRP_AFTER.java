package srp.solution1;

// Classe qui gère UNIQUEMENT les données du livre (Responsabilité 1)
public class BookSRP {
    private String title;
    private String author;
    private String content;

    public BookSRP(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }
}
// Classe pour l'affichage (Responsabilité 2)
public class BookPrinter {
    
    // Méthode pour afficher à l'écran
    public void printToScreen(BookSRP book) {
        System.out.println("=== Affichage à l'écran ===");
        System.out.println("Titre: " + book.getTitle());
        System.out.println("Auteur: " + book.getAuthor());
        System.out.println("Contenu: " + book.getContent());
    }

    // Méthode pour afficher en HTML
    public void printToHTML(BookSRP book) {
        System.out.println("\n=== Affichage en HTML ===");
        System.out.println("<h1>" + book.getTitle() + "</h1>");
        System.out.println("<h2>" + book.getAuthor() + "</h2>");
        System.out.println("<p>" + book.getContent() + "</p>");
    }
}

// Classe pour la persistance (Responsabilité 3)
public class BookSaver {
    
    public void saveToDatabase(BookSRP book) {
        System.out.println("\nSauvegarde de \"" + book.getTitle() + "\" en base de données...");
    }

    public void saveToFile(BookSRP book, String filename) {
        System.out.println("\nSauvegarde de \"" + book.getTitle() + "\" dans " + filename);
    }
}

// Classe pour la logique métier (Responsabilité 4)
public class BookBusinessLogic {
    
    public void emprunter(BookSRP book, String lecteur) {
        System.out.println("\nEmprunt du livre \"" + book.getTitle() + "\" par " + lecteur);
    }

    public void autreService(BookSRP book) {
        System.out.println("\nAutre logique métier sur le livre \"" + book.getTitle() + "\"");
    }
}

public class MainSolution1 {
    public static void main(String[] args) {
        BookSRP livre = new BookSRP("Design Patterns", "Gamma et al.", "Contenu du livre...");
        
        System.out.println("=== SOLUTION 1 : Classes distinctes ===");
        
        BookPrinter printer = new BookPrinter();
        printer.printToScreen(livre);
        printer.printToHTML(livre);
        
        BookSaver saver = new BookSaver();
        saver.saveToDatabase(livre);
        saver.saveToFile(livre, "livre.txt");
        
        BookBusinessLogic logic = new BookBusinessLogic();
        logic.emprunter(livre, "Marie Curie");
        logic.autreService(livre);
    }
}