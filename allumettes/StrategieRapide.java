package allumettes;

public class StrategieRapide implements Strategie {

	/**
	 * Strategie rapide est une stratégie selon laquelle le joueur choisira le
	 * nombre maximal d'allumettes possible pour terminer la partie le plus vite
	 * possible.
	 *
	 * @author Weisbecker Lisa <Lisa.Weisbecker@enseeiht.fr>
	 */

	public StrategieRapide() {
	}

	@Override
	public int getPrise(Jeu jeu) {
		assert (jeu != null);
		assert (jeu.getNombreAllumettes() > 0);

		if (jeu.getNombreAllumettes() > 2) {
			return Jeu.PRISE_MAX;
		} else {
			return jeu.getNombreAllumettes();
		}
	}
}
