package allumettes;

/**
 * Lance une partie des 13 allumettes en fonction des arguments fournis sur la
 * ligne de commande.
 *
 * @author Xavier Crégut
 * @version $Revision: 1.5 $
 */
public class Jouer {

	/**
	 * Lancer une partie. En argument sont donnés les deux joueurs sous la forme
	 * nom@stratégie.
	 *
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);

			String[] donneesJoueur1 = null;
			String[] donneesJoueur2 = null;
			donneesJoueur1 = args[args.length - 2].split("@");
			donneesJoueur2 = args[args.length - 1].split("@");

			if (donneesJoueur1.length < 2 || donneesJoueur2.length < 2) {
				throw new ConfigurationException("Données incorrectes");
			}

			Jeu jeu = new JeuDesAllumettes();
			Joueur joueur1;
			Joueur joueur2;

			if (!conforme(donneesJoueur1[1])) {
				throw new ConfigurationException(
						"Strategie de " + donneesJoueur1[0] + " non conforme");
			} else {
				joueur1 = new Joueur(donneesJoueur1[0],
						typeStrat(donneesJoueur1[0], donneesJoueur1[1]));
			}
			if (!conforme(donneesJoueur2[1])) {
				throw new ConfigurationException(
						"Strategie de " + donneesJoueur2[0] + " non conforme");
			} else {
				joueur2 = new Joueur(donneesJoueur2[0],
						typeStrat(donneesJoueur2[0], donneesJoueur2[1]));
			}

			boolean conf = false;
			if (args[0].contentEquals("-confiant")) {
				conf = true;
			}
			Arbitre arbitre = new Arbitre(joueur1, joueur2, conf);
			arbitre.arbitrer(jeu);

		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
	}

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : " + args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : " + args.length);
		}
	}

	/**
	 * Vérifier que l'entrée d'une stratégie est conforme.
	 *
	 * @param entree le nom d'une stratégie proposée en argument
	 */
	private static boolean conforme(String entree) {
		return (entree.equals("rapide") || entree.equals("naif")
				|| entree.equals("expert") || entree.equals("tricheur")
				|| entree.equals("humain"));
	}

	/**
	 * Retourne la stratégie d'un joueur à partir de son nom et du nom de la
	 * stratégie
	 *
	 * @param name  le nom du joueur
	 * @param strat le nom de la stratégie
	 * @return la stratégie du joueur
	 */
	public static Strategie typeStrat(String name, String strat) {
		if (strat.equals("rapide")) {
			return new StrategieRapide();
		} else if (strat.equals("naif")) {
			return new StrategieNaif();
		} else if (strat.equals("expert")) {
			return new StrategieExpert();
		} else if (strat.equals("tricheur")) {
			return new StrategieTricheur(name);
		} else {
			return new StrategieHumain(name);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :" + "\n\t"
				+ "java allumettes.Jouer joueur1 joueur2" + "\n\t\t"
				+ "joueur est de la forme nom@stratégie" + "\n\t\t"
				+ "strategie = naif | rapide | expert | humain | tricheur" + "\n" + "\n\t"
				+ "Exemple :" + "\n\t" + "	java allumettes.Jouer Xavier@humain "
				+ "Ordinateur@naif" + "\n");
	}

}
