public class Zoo {
    public static final int NBR_CAGES = 25; // Nombre constant de cages
    public Animal[] animals;
    public String name;
    public String city;
    public int animalCount; // Compteur d'animaux

    // Constructeur pour initialiser le zoo
    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES]; // Initialiser le tableau d'animaux avec le nombre de cages fixe
        this.name = name;
        this.city = city;
        this.animalCount = 0; // Initialiser le compteur d'animaux à 0
    }

    // Méthode pour vérifier si le zoo est plein
    public boolean isZooFull() {
        return animalCount >= NBR_CAGES; // Retourner true si le zoo est plein
    }

    // Méthode pour ajouter un animal
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein. Impossible d'ajouter l'animal : " + animal.getName());
            return false; // Retourner false si le zoo est plein
        }

        // Vérifier l'unicité de l'animal
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equalsIgnoreCase(animal.getName())) {
                System.out.println("L'animal " + animal.getName() + " existe déjà dans le zoo.");
                return false; // Retourner false si l'animal existe déjà
            }
        }

        // Ajouter l'animal si toutes les vérifications sont passées
        animals[animalCount] = animal; // Ajouter l'animal à la case correspondante
        animalCount++; // Incrémenter le compteur d'animaux
        return true; // L'ajout a bien été fait
    }

    // Méthode pour afficher tous les animaux dans le zoo
    public void displayAnimals() {
        System.out.println("Animaux dans le zoo :");
        if (animalCount == 0) {
            System.out.println("Aucun animal dans le zoo.");
            return; // Si aucun animal n'est présent, sortir de la méthode
        }
        for (int i = 0; i < animalCount; i++) { // Parcourir uniquement les animaux ajoutés
            animals[i].displayAnimal();
            System.out.println("---------------------");
        }
    }

    // Méthode pour chercher un animal dans le zoo par son nom
    public int searchAnimal(String animalName) {
        for (int i = 0; i < animalCount; i++) { // Parcourir uniquement les animaux ajoutés
            if (animals[i].getName().equalsIgnoreCase(animalName)) {
                return i; // Retourner l'indice si l'animal est trouvé
            }
        }
        return -1; // Retourner -1 si l'animal n'est pas trouvé
    }

    // Méthode pour supprimer un animal du zoo
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal.getName()); // Rechercher l'animal par son nom

        if (index == -1) {
            System.out.println("L'animal " + animal.getName() + " n'existe pas dans le zoo.");
            return false; // Retourner false si l'animal n'est pas trouvé
        }

        // Décaler les éléments du tableau pour supprimer l'animal
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1]; // Déplacer chaque animal à gauche
        }

        // Mettre le dernier animal à null pour éviter les références erronées
        animals[animalCount - 1] = null;
        animalCount--; // Décrémenter le compteur d'animaux
        System.out.println("L'animal " + animal.getName() + " a été supprimé du zoo.");
        return true; // La suppression a réussi
    }
}
