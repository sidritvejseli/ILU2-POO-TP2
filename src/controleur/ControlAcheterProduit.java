package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] cotrolEtatMarche() {
		return village.donnerEtatMarche();
	}

	public int  acheterProduit(String nom_marchand, int quantite) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nom_marchand).acheterProduit(quantite);
		
		
	}


	//TODO a complete
	
	
}
