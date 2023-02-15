package allumettes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StrategieHumain implements Strategie {

	/**
	 * Strategie humain est une stratégie qui permettra à un utilisateur humain de
	 * jouer au jeu des allumettes.
	 *
	 * @author Weisbecker Lisa <Lisa.Weisbecker@enseeiht.fr>
	 */

	private static Scanner scan = new Scanner(System.in);
	private String nom;

	public StrategieHumain(String nom) {
		this.nom = nom;
	}

	@Override
	public int getPrise(Jeu jeu) throws CoupInvalideException {
		assert (jeu.getNombreAllumettes() > 0);
		assert (jeu != null);

		int prise = 0;
		boolean valide = false;
		while (!valide) {
			try {
				System.out.print(nom + ", combien d'allumettes ? ");
				prise = this.scan.nextInt();
				valide = true;
			} catch (InputMismatchException e) {
				String choixStr = this.scan.nextLine();
				if (choixStr.equals("triche")) {
					jeu.retirer(1);
					System.out.print("[Une allumette en moins, plus que ");
					System.out.print(jeu.getNombreAllumettes());
					System.out.println(". Chut !]");
				} else {
					System.out.println("Vous devez donner un entier.");
				}
			}
		}
		return prise;
	}

}
