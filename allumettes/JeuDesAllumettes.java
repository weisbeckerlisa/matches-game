package allumettes;

public class JeuDesAllumettes implements Jeu {

	/**
	 * JeuDesAllumettes modélise le jeu des allumettes. L'avancement du jeu est
	 * caractérisé par son nombre d'allumettes restantes. On peut retirer des
	 * allumettes et obtenir le nombre d'allumettes restantes.
	 *
	 * @author Weisbecker Lisa <Lisa.Weisbecker@enseeiht.fr>
	 */
	private int nombreAllumettes;

	/**
	 * Construire un jeu des allumettes avec le nombre d'allumettes initial par
	 * défaut (13)
	 *
	 */
	public JeuDesAllumettes() {
		this.nombreAllumettes = ALLUMETTES_INITIAL_DEFAUT;
	}

	/**
	 * Construire un jeu des allumettes avec un nombre d'allumettes initial
	 *
	 * @param allumettesInitiales le nombre d'allumettes de départ
	 */
	public JeuDesAllumettes(int allumettesInitial) {
		this.nombreAllumettes = allumettesInitial;
	}

	@Override
	public int getNombreAllumettes() {
		return this.nombreAllumettes;
	}

	@Override
	public void retirer(int prise) throws CoupInvalideException {
		if (prise > this.nombreAllumettes) {
			throw new CoupInvalideException(prise, " (> " + this.nombreAllumettes + ")");
		} else if (prise > PRISE_MAX) {
			throw new CoupInvalideException(prise, " (> " + PRISE_MAX + ")");
		} else if (prise < 1) {
			throw new CoupInvalideException(prise, " (< 1)");
		} else {
			this.nombreAllumettes = this.nombreAllumettes - prise;
		}
	}

}
