package tn.esprit.gestionzoo.entities;

public class Zoo {
    public static final int NUMBER_OF_CAGES = 25;
    private Animal[] animals;
    private Aquatic[] aquaticAnimals;
    private String name, city;
    private int nbrAnimals;
    private int nbrAquatics;

    // Constructeurs
    public Zoo() {
    }

    public Zoo(String name, String city) {
        animals = new Animal[NUMBER_OF_CAGES];
        aquaticAnimals = new Aquatic[10];
        this.name = name;
        this.city = city;
    }

    // Comparer les zoos
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals > z2.nbrAnimals)
            return z1;
        return z2;
    }

    // Getters et setters
    public int getNbrAquatics() {
        return nbrAquatics;
    }

    public void setNbrAquatics(int nbrAquatics) {
        this.nbrAquatics = nbrAquatics;
    }

    public Aquatic[] getAquaticAnimals() {
        return aquaticAnimals;
    }

    public void setAquaticAnimals(Aquatic[] aquaticAnimals) {
        this.aquaticAnimals = aquaticAnimals;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank())
            System.out.println("The Zoo name cannot be empty");
        else
            this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    public void setNbrAnimals(int nbrAnimals) {
        this.nbrAnimals = nbrAnimals;
    }

    // Afficher le zoo
    void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + " N° animals: " + nbrAnimals);
    }

    // Ajouter un animal
    public boolean addAnimal(Animal animal) {
        if (searchAnimal(animal) != -1)
            return false;
        if (isZooFull())
            return false;
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    // Ajouter un animal aquatique
    public void addAquaticAnimal(Aquatic aquatic) {
        aquaticAnimals[nbrAquatics] = aquatic;
        nbrAquatics++;
    }

    // Supprimer un animal
    public boolean removeAnimal(Animal animal) {
        int indexAnimal = searchAnimal(animal);
        if (indexAnimal == -1)
            return false;
        for (int i = indexAnimal; i < nbrAnimals; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals] = null;
        this.nbrAnimals--;
        return true;
    }

    // Afficher les animaux
    public void displayAnimals() {
        System.out.println("List of animals of " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    // Rechercher un animal
    public int searchAnimal(Animal animal) {
        int index = -1;
        for (int i = 0; i < nbrAnimals; i++) {
            if (animal.getName().equals(animals[i].getName()))
                return i;
        }
        return index;
    }

    // Profondeur maximale de nage des pingouins
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0f;
        for (int i = 0; i < nbrAquatics; i++) {
            if (aquaticAnimals[i] instanceof Penguin penguin) {
                if (maxDepth < penguin.getSwimmingDepth())
                    maxDepth = penguin.getSwimmingDepth();
            }
        }
        return maxDepth;
    }

    // Afficher le nombre d'animaux aquatiques par type
    public void displayNumberOfAquaticsByType() {
        int nbrPenguins = 0;
        int nbrDolphins = 0;
        for (int i = 0; i < nbrAquatics; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                nbrDolphins++;
            }
            if (aquaticAnimals[i] instanceof Penguin) {
                nbrPenguins++;
            }
        }
        System.out.println("Le Zoo " + name + " contient " + nbrDolphins + " dauphins et " + nbrPenguins + " pingouins");
    }

    // Vérifier si le zoo est plein
    public boolean isZooFull() {
        return nbrAnimals == NUMBER_OF_CAGES;
    }

    // Nouvelle méthode: Calculer la vitesse moyenne de nage des animaux aquatiques
    public float averageSwimmingSpeed() {
        if (nbrAquatics == 0) {
            return 0; // Retourner 0 si aucun animal aquatique
        }

        float totalSpeed = 0;
        int count = 0;

        for (int i = 0; i < nbrAquatics; i++) {
            if (aquaticAnimals[i] instanceof Dolphin dolphin) {
                totalSpeed += dolphin.getSwimmingSpeed();
                count++;
            }
        }

        if (count == 0) {
            return 0; // Aucun dauphin n'a été trouvé
        }

        return totalSpeed / count; // Retourner la vitesse moyenne
    }

    @Override
    public String toString() {
        return "Zoo{ Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + " N° animals: " + nbrAnimals + "}";
    }
}
