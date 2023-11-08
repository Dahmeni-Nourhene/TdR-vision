public class CritereMarque implements Critere {
    private String marque;
    public CritereMarque(String marque) {
        this.marque = marque;
    }
    public boolean estSatisfaitPar(Voiture v) {
        return v.getMarque() == marque;    }
}
