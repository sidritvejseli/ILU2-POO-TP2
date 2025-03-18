package frontiere;

import controleur.ControlEmmenager;

import java.util.Scanner;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					System.out.println("Bienvenue druide " + nomVisiteur);
					StringBuilder q_force = new StringBuilder();
					q_force.append("Quelle est votre force");
					int force_druide = Clavier.entrerEntier(q_force.toString());
					
					StringBuilder q_max =  new StringBuilder();
					StringBuilder q_min =  new StringBuilder();
					
					q_min.append("Quelle est la force de potion la plus faible que vous produisez ?");
					int effetPotionMin =  Clavier.entrerEntier(q_min.toString());

					q_max.append("Quelle est la force de potion la plus forte que vous produisez ?");
					int effetPotionMax =  Clavier.entrerEntier(q_max.toString());
					
					while(effetPotionMax < effetPotionMin) {
						System.out.println("Attention druide, vous vous etes trompe entre le min et le max");
						
						
						effetPotionMin =  Clavier.entrerEntier(q_min.toString());

						
						effetPotionMax =  Clavier.entrerEntier(q_max.toString());
					}
					
					controlEmmenager.ajouterDruide(nomVisiteur, force_druide, effetPotionMin, effetPotionMax);
					
					break;
					

				case 2:
					//TODO 
					StringBuilder q_villageois = new StringBuilder();
					
					q_villageois.append("Bonjour villageois "+ nomVisiteur+ "\n");
					q_villageois.append("Quelle est votre force ?");
					
					int force = 0;
					force = Clavier.entrerEntier(q_villageois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//TODO a completer
	}
}
