import java.util.Comparator;
public class TriCodeCroissant implements Comparator<Client> {
    @Override
    public int compare(Client c1, Client c2) {
        return Integer.compare(c1.getCode(), c2.getCode());
    }
}
