package allumettes;

public class OperationInterditeException extends RuntimeException {
	public OperationInterditeException() {
		super("Il y a tricherie !");
	}
}
