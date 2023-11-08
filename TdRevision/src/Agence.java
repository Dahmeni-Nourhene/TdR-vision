import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures parking;

    public ListVoitures getParking() {
        return parking;
    }

    public void setParking(ListVoitures parking) {
        this.parking = parking;
    }

    private Map<Client, ListVoitures> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        parking = new ListVoitures();
        clientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException , PrixNegatifException {
        if (v.getPrixLocation() >= 0) {
        parking.ajoutVoiture(v);
        } else {
            throw new PrixNegatifException();
        }
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        parking.supprimeVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        ListVoitures listeVoitures = clientVoitureLoue.getOrDefault(cl, new ListVoitures());
        listeVoitures.ajoutVoiture(v);
        clientVoitureLoue.put(cl, listeVoitures);
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        ListVoitures listeVoitures = clientVoitureLoue.get(cl);
        if (listeVoitures != null) {
            listeVoitures.supprimeVoiture(v);
             clientVoitureLoue.remove(v);

        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> voituresSelectionnees = new ArrayList<>();
        for (Voiture v : parking.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                voituresSelectionnees.add(v);
            }
        }
        return voituresSelectionnees;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return clientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return clientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Client cl : clientVoitureLoue.keySet()) {
            System.out.println(cl.getNom() + " " + cl.getPrenom() + " a loué les voitures suivantes:");
            ListVoitures listeVoitures = clientVoitureLoue.get(cl);
            listeVoitures.affiche();
        }
    }

    public Map<Client, ListVoitures> triCodeCroissant() {
        Map<Client, ListVoitures> tri = new TreeMap<>(new TriCodeCroissant() {

        });
        tri.putAll(clientVoitureLoue);
        return tri;
    }
    public Map<Client, ListVoitures> triNomCroissant() {
        Map<Client, ListVoitures> tri = new TreeMap<>(new TriNomCroissant()  {

        });
        tri.putAll(clientVoitureLoue);
        return tri;
    }
}
