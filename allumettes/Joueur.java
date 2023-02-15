package allumettes;

public class Joueur {

	/**
	 * Joueur modélise un joueur d'une partie de jeu. Il possède un nom et une
	 * stratégie. On peut obtenir sa prise lors de son tour et indiquer sa victoire
	 * ou sa défaite
	 *
	 * @author Weisbecker Lisa <Lisa.Weisbecker@enseeiht.fr>
	 */
	private String nom;
	private Strategie strategie;

	/**
	 * Construire un joueur à partir de son nom et de sa stratégie
	 *
	 * @param nom       le nom du joueur
	 * @param strategie la stratégie du joueur
	 */
	public Joueur(String nom, Strategie strategie) {
		this.nom = nom;
		this.strategie = strategie;
	}

	/**
	 * Obtenir la prise du joueur (le nombre d'allumettes qu'il retire)
	 *
	 * @param jeu le jeu en cours
	 * @return prise la prise du joueur
	 */
	public int getPrise(Jeu jeu) throws CoupInvalideException {
		assert (jeu != null);
		assert (jeu.getNombreAllumettes() > 0);
		int prise = this.strategie.getPrise(jeu);
		return prise;
	}

	/**
	 * Obtenir le nom du joueur
	 *
	 * @return le nom du joueur
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Indiquer que le joueur a gagné
	 *
	 */
	public void win() {
		System.out.println(this.nom + " gagne !");
	}

	/**
	 * Indiquer que le joueur a perdu
	 *
	 */
	public void lose() {
		System.out.println(this.nom + " perd !");
	}

}
