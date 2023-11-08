import java.util.Comparator;
public class TriNomCroissant implements Comparator<Client>{
    @Override
    public int compare(Client c1, Client c2) {
        return c1.getNom().compareTo(c2.getNom());
    }
}
