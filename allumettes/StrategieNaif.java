package allumettes;

import java.util.Random;

public class StrategieNaif implements Strategie {

	/**
	 * Strategie Naif est une stratégie selon laquelle le joueur choisira au hasard
	 * un nombre d'allumettes compris entre 1 et PRISE_MAX.
	 *
	 * @author Weisbecker Lisa <Lisa.Weisbecker@enseeiht.fr>
	 */

	private Random generateur;

	public StrategieNaif() {
		this.generateur = new Random();
	}

	@Override
	public int getPrise(Jeu jeu) {
		assert (jeu != null);
		assert (jeu.getNombreAllumettes() > 0);
		return generateur.nextInt(Jeu.PRISE_MAX) + 1;
	}
}
