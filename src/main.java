public class main {
    public static void main(String[] args) {
        // Créer un zoo avec le nom et la ville
        Zoo zoo = new Zoo("Zoo National", "Lyon");

        // Créer quelques animaux
        Animal lion = new Animal("Felidae", "Lion", 5, true);
        Animal tigre = new Animal("Felidae", "Tigre", 3, true);
        Animal aigle = new Animal("Accipitridae", "Aigle", 2, false);

        // Ajouter des animaux dans le zoo
        zoo.addAnimal(lion);
        zoo.addAnimal(tigre);
        zoo.addAnimal(aigle);

        // Afficher tous les animaux dans le zoo
        zoo.displayAnimals();

        // Essayer d'ajouter plus d'animaux que la capacité
        for (int i = 0; i < 25; i++) {
            Animal elephant = new Animal("Elephantidae", "Elephant" + (i + 1), 10, true);
            zoo.addAnimal(elephant);
        }

        // Afficher tous les animaux après les ajouts
        zoo.displayAnimals();

        // Supprimer un animal du zoo
        boolean removed = zoo.removeAnimal(tigre); // Essayer de supprimer le tigre
        if (removed) {
            System.out.println("Le tigre a été supprimé.");
        } else {
            System.out.println("Échec de la suppression du tigre.");
        }

        // Afficher tous les animaux après la suppression
        zoo.displayAnimals();

        // Essayer de supprimer un animal qui n'existe pas
        boolean removedNonExistent = zoo.removeAnimal(new Animal("Felidae", "Lynx", 4, true));
        if (removedNonExistent) {
            System.out.println("Le lynx a été supprimé.");
        } else {
            System.out.println("Échec de la suppression du lynx.");
        }
    }
}
