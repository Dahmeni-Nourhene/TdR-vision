public class VoitureException extends Exception {
    public VoitureException() {
        super("La voiture n'est pas présente dans la liste des voitures");
    }
}
