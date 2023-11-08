import java.util.List;
import java.util.Map;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Agence agence = new Agence("MaAgence");

        Client client1 = new Client(1, "John", "Doe");
        Client client2 = new Client(2, "Alice", "Smith");

        Voiture voiture1 = new Voiture(1, "Toyota", 111);
        Voiture voiture2 = new Voiture(2, "Ford", 555);
        Voiture voiture3 = new Voiture(3, "Honda", 5555);

        try {
            agence.ajoutVoiture(voiture1);

        } catch (VoitureException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (PrixNegatifException e) {
            throw new RuntimeException(e);
        }
        try {
            agence.ajoutVoiture(voiture2);

        } catch (VoitureException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (PrixNegatifException e) {
            throw new RuntimeException(e);
        }
        try {
            agence.ajoutVoiture(voiture3);

        } catch (VoitureException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (PrixNegatifException e) {
            throw new RuntimeException(e);
        }

        try {
            agence.loueClientVoiture(client1, voiture1);
            agence.loueClientVoiture(client2, voiture2);
        } catch (VoitureException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("Voitures disponibles :");
        //agence.vs.affiche();

        System.out.println("Voitures louées par clients :");
        agence.afficheLesClientsEtLeursListesVoitures();

        System.out.println("Clients qui ont loué une voiture :");
        Set<Client> clientsLoueurs = agence.ensembleClientsLoueurs();
        for (Client client : clientsLoueurs) {
            System.out.println(client.getNom() + " " + client.getPrenom());
        }

        System.out.println("Voitures louées selon le critère (Essence) :");
        Critere critereEssence = new CritereMarque("Essence");
        List<Voiture> voituresSelonCritere = agence.selectVoitureSelonCritere(critereEssence);
        for (Voiture voiture : voituresSelonCritere) {
            System.out.println(voiture);
        }

        System.out.println("Trie par code client croissant :");
        Map<Client, ListVoitures> triCodeCroissant = agence.triCodeCroissant();
        for (Client client : triCodeCroissant.keySet()) {
            System.out.println(client.getNom() + " " + client.getPrenom() + " (Code : " + client.getCode() + ")");
        }

        System.out.println("Trie par nom client croissant :");
        Map<Client, ListVoitures> triNomCroissant = agence.triNomCroissant();
        for (Client client : triNomCroissant.keySet()) {
            System.out.println(client.getNom() + " " + client.getPrenom() + " (Nom : " + client.getNom() + ")");
        }
    }
}
