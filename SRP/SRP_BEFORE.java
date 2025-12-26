package srp;

// Classe qui viole le SRP car a 4 responsabilités dans une seule classe
public class Book {
    private String title;
    private String author;
    private String content;

    public Book(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    // Responsabilité 1 : Gérer les données du livre
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }

    // Responsabilité 2 : Afficher le livre (présentation)
    public void printToScreen() {
        System.out.println("=== Affichage à l'écran ===");
        System.out.println("Titre: " + title);
        System.out.println("Auteur: " + author);
        System.out.println("Contenu: " + content);
    }

    // Responsabilité 3 : Sauvegarder le livre (persistance)
    public void saveToDatabase() {
        System.out.println("Sauvegarde du livre \"" + title + "\" en base de données...");
    }

    // Responsabilité 4 : Logique métier
    public void emprunter(String lecteur) {
        System.out.println("Emprunt du livre \"" + title + "\" par " + lecteur);
    }
}

class MainAvant {
    public static void main(String[] args) {
        Book livre = new Book("Design Patterns", "Gamma et al.", "Contenu du livre...");
        
        System.out.println("=== AVANT REFACTORING ===");
        livre.printToScreen();
        livre.saveToDatabase();
        livre.emprunter("Jean Dupont");
    }
}