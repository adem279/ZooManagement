public class main {
    public static void main(String[] args) {
        Animal lion=new Animal("cats","lion",20,true);

         Zoo myzoo= new Zoo("myzoo","Tunis",20);
        myzoo.animals[0] = lion; // Ajout du lion dans le zoo

        System.out.println("Nom du zoo : " + myzoo.name);
        System.out.println("Ville du zoo : " + myzoo.city);
        System.out.println("Nombre de cages : " + myzoo.nbrCages);
        System.out.println("Famille de l'animal : " + myzoo.animals[0].family);
        System.out.println("Nom de l'animal : " + myzoo.animals[0].name);
        System.out.println("Âge de l'animal : " + myzoo.animals[0].age + " ans");

    }
}
