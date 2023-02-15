package allumettes;

import java.util.Random;

public class StrategieExpert implements Strategie {

	/**
	 * Strategie expert est une stratégie selon laquelle le joueur gagnera s'il en a
	 * la possibilité.
	 *
	 * @author Weisbecker Lisa <Lisa.Weisbecker@enseeiht.fr>
	 */

	private Random generateur;

	public StrategieExpert() {
		this.generateur = new Random();
	}

	@Override
	public int getPrise(Jeu jeu) {
		assert (jeu != null);
		assert (jeu.getNombreAllumettes() > 0);

		Integer modulo = Jeu.PRISE_MAX + 1;
		if (jeu.getNombreAllumettes() == 1) {
			return 1;

		} else if ((jeu.getNombreAllumettes() - 1) % modulo == 0) {

			int prise = generateur.nextInt(Jeu.PRISE_MAX) + 1;
			return prise;

		} else {
			return (jeu.getNombreAllumettes() - 1) % modulo;
		}
	}
}
