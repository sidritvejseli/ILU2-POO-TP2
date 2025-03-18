package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis desole " +nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici");
			
		}
		else {
			System.out.println("Bonjour " +nomVendeur + " Je vais regarder si je peux vous trouver un etal");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Desole  " +nomVendeur + "Je n'ai plus d'etal qui ne soit pas deja occupe");
				

			}
			else {
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un etal pour vous !");
				System.out.println("Il me faudrait quelques renseignements .");
				
				StringBuilder q_produit = new StringBuilder();
				q_produit.append("Quel produit souhaitez vous vendre");
				
				String produit = Clavier.entrerChaine(q_produit.toString());
				
				StringBuilder q_nb = new StringBuilder();
				q_nb.append("Combien souhaitez-vous en vendre");
				
				int nbProduit = Clavier.entrerEntier(q_nb.toString());
				
				int nb_etal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				
				if (nb_etal!=-1) {
					System.out.println("Le vendeur " + nomVendeur + "s'est installe a l'etal n" + (nb_etal+1));
					
				}
				
				
				
			}

		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
