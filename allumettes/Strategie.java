package allumettes;

public interface Strategie {

	/**
	 * Strategie modélise une stratégie de jeu pour un joueur
	 *
	 * @author Weisbecker Lisa <Lisa.Weisbecker@enseeiht.fr>
	 */

	/**
	 * Obtenir la prise d'un joueur en fonction du jeu en cours
	 *
	 * @param jeu le jeu en cours
	 * @return prise la prise du joueur
	 */
	int getPrise(Jeu jeu) throws CoupInvalideException;

}
