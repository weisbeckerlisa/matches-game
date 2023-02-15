package allumettes;

public class StrategieTricheur implements Strategie {

	private String nom;

	public StrategieTricheur(String nom) {
		this.nom = nom;
	}

	public int getPrise(Jeu jeu) throws CoupInvalideException {
		assert (jeu != null);
		assert (jeu.getNombreAllumettes() > 0);

		System.out.println("[Je triche...]");
		while (jeu.getNombreAllumettes() > 2) {
			jeu.retirer(1);
		}
		System.out.println("[Allumettes restantes : " + jeu.getNombreAllumettes() + "]");
		return 1;
	}
}
