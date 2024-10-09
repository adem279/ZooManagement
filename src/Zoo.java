public class Zoo {
    public static final int NBR_CAGES = 25; // Nombre constant de cages
    private Animal[] animals;
    private String name;
    private String city;
    private int animalCount; // Compteur d'animaux

    // Constructeur pour initialiser le zoo
    public Zoo(String name, String city) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du zoo ne doit pas être vide.");
        }
        animals = new Animal[NBR_CAGES]; // Initialiser le tableau d'animaux
        this.name = name;
        this.city = city;
        this.animalCount = 0; // Initialiser le compteur d'animaux
    }

    // Méthode pour obtenir le nom du zoo
    public String getName() {
        return name; // Retourner le nom du zoo
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
        System.out.println("L'animal " + animal.getName() + " a été ajouté au zoo.");
        return true; // L'ajout a bien été fait
    }

    // Méthode pour afficher les animaux dans le zoo
    public void displayAnimals() {
        System.out.println("Animaux dans le zoo " + name + " à " + city + ":");
        for (int i = 0; i < animalCount; i++) {
            animals[i].displayAnimal();
            System.out.println();
        }
    }

    // Méthode pour retirer un animal
    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equalsIgnoreCase(animal.getName())) {
                // Déplacer les animaux suivants vers la gauche
                for (int j = i; j < animalCount - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[animalCount - 1] = null; // Nettoyer la dernière case
                animalCount--; // Décrémenter le compteur d'animaux
                return true; // Suppression réussie
            }
        }
        System.out.println("L'animal " + animal.getName() + " n'existe pas dans le zoo.");
        return false; // L'animal n'a pas été trouvé
    }
}
