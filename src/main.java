public class main {
    public static void main(String[] args) {
        // Test pour le zoo
        try {
            Zoo zoo1 = new Zoo("Zoo National", "Lyon");
            System.out.println("Zoo créé avec succès : " + zoo1.getName());

            // Créer quelques animaux
            Animal lion = new Animal("Felidae", "Lion", 5, true);
            Animal tigre = new Animal("Felidae", "Tigre", 3, true);
            Animal aigle = new Animal("Accipitridae", "Aigle", 2, false);

            // Ajouter des animaux dans le zoo
            zoo1.addAnimal(lion);
            zoo1.addAnimal(tigre);
            zoo1.addAnimal(aigle);

            // Essayer de créer un animal avec un âge négatif
            try {
                Animal elephantNegatif = new Animal("Elephantidae", "ElephantNegatif", -2, true);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // Afficher tous les animaux dans le zoo
            zoo1.displayAnimals();

            // Supprimer un animal du zoo
            boolean removed = zoo1.removeAnimal(tigre); // Essayer de supprimer le tigre
            if (removed) {
                System.out.println("Le tigre a été supprimé.");
            } else {
                System.out.println("Échec de la suppression du tigre.");
            }

            // Afficher tous les animaux après la suppression
            zoo1.displayAnimals();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test avec un nom vide
        try {
            Zoo zoo2 = new Zoo("", "Paris");
            System.out.println("Zoo créé avec succès : " + zoo2.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test avec un nom nul
        try {
            Zoo zoo3 = new Zoo(null, "Marseille");
            System.out.println("Zoo créé avec succès : " + zoo3.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
