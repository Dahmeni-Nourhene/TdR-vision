public class PrixNegatifException extends Exception {
    public PrixNegatifException() {
        super("Le produit a un prix négatif, impossible de l'ajouter.");
    }
}