public class Zoo {
  public Animal [] animals;
  public String name;
  public String city;
  public int nbrCages;
    public Zoo(String name, String city, int nbrCages) {
        animals= new Animal[nbrCages];
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;

    }

    // Getters et setters
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
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public void setNbrCages(int nbrCages) {
        this.nbrCages = nbrCages;
    }
    public void displayZoo() {
        System.out.println("Nom du Zoo: " + name);
        System.out.println("Ville: " + city);
        System.out.println("Nombre de cages: " + nbrCages);
        System.out.println("Animaux dans le zoo:");
        for (Animal animal : animals) {
            animal.displayAnimal();
            System.out.println("---------------------");
        }
    }
}
