package allumettes;

public class Proxy implements Jeu {

	private Integer nombreAllumettes;

	public Proxy(Jeu jeu) {
		assert (jeu != null);
		this.nombreAllumettes = jeu.getNombreAllumettes();
	}

	@Override
	public int getNombreAllumettes() {
		return this.nombreAllumettes;
	}

	@Override
	public String toString() {
		return ("nombreAllumettes =" + this.nombreAllumettes);
	}

	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
		throw new OperationInterditeException();
	}

}
