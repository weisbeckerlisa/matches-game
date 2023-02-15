package allumettes;

public class Arbitre {

	/**
	 * Arbitre modélise l'arbitre d'une partie de jeu des allumettes. L'arbitre peut
	 * être confiant et ainsi ne pas détecter les tricheries, ou ne pas l'être et
	 * stopper la partie en cas de tricherie. Il peut arbitrer une partie de jeu et
	 * organiser son déroulement jusqu'à la victoire d'un des joueurs ou l'arrêt en
	 * cas de tricherie détectée.
	 *
	 * @author Weisbecker Lisa <Lisa.Weisbecker@enseeiht.fr>
	 */

	private Joueur joueur1;
	private Joueur joueur2;
	private Boolean confiant;
	private Boolean triche = false;

	/**
	 * Construire un arbitre à partir de deux joueurs et de son état de confiance
	 *
	 * @param j1   le premier joueur
	 * @param j2   le deuxième joueur
	 * @param conf l'état de confiance de l'arbitre (true s'il est confiant)
	 */
	public Arbitre(Joueur j1, Joueur j2, boolean conf) {
		assert (j1 != null);
		assert (j2 != null);
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.confiant = conf;
	}

	/**
	 * Construire un arbitre à partir de deux joueurs
	 *
	 * @param j1   le premier joueur
	 * @param j2   le deuxième joueur
	 */
	public Arbitre(Joueur j1, Joueur j2) {
		this(j1, j2, false);
	}

	/**
	 * Arbitrer une partie
	 *
	 * @param jeu le jeu en cours
	 */
	public void arbitrer(Jeu jeu) {
		assert (jeu != null);
		assert (jeu.getNombreAllumettes() > 0);
		boolean joueurTour = true;

		while (jeu.getNombreAllumettes() > 0 && !triche) {
			System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes());

			// Le joueur 1 commence
			Joueur joueurCourant = this.joueur1;

			if (!joueurTour) {
				joueurCourant = this.joueur2;
			}
			int prise = 0;
			try {
				if (this.confiant) {
					prise = joueurCourant.getPrise(jeu);
				} else {
					prise = joueurCourant.getPrise(new Proxy(jeu));
				}
				if (prise < 1) {
					System.out.println(
							joueurCourant.getNom() + " prend " + prise + " allumette.");
				} else if (prise == 1) {
					System.out.println(
							joueurCourant.getNom() + " prend " + prise + " allumette.");
				} else {
					System.out.println(
							joueurCourant.getNom() + " prend " + prise + " allumettes.");
				}
				jeu.retirer(prise);
				joueurTour = !joueurTour;
				System.out.println();
			} catch (CoupInvalideException e) {
				System.out.println("Impossible ! Nombre invalide : " + e.getCoup()
						+ e.getProbleme() + "\n");
			} catch (OperationInterditeException e) {
				this.triche = true;
				System.out.println("Abandon de la partie car " + joueurCourant.getNom()
						+ " triche !");

			}
		}

		if (!joueurTour && !triche) {
			joueur1.lose();
			joueur2.win();
		} else if (!triche) {
			joueur2.lose();
			joueur1.win();
		}
	}
}
