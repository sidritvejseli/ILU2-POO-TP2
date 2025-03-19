package frontiere;

import controleur.ControlAcheterProduit;


public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;
	

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		
		
		
		
		
				StringBuilder q_produit = new StringBuilder();
				
				q_produit.append("Quel produit voulez-vous acheter ? \n");
				String produit = Clavier.entrerChaine(q_produit.toString());
				
				StringBuilder q_marchand = new StringBuilder();;
				q_marchand.append("Chez quel commercant voulez-vous acheter des " + produit);
				
				String Etals[] = controlAcheterProduit.cotrolEtatMarche();
				
				int nb_marchand = 1;
				
				for (int i = 0; i<Etals.length; i++) {
					if(produit.equals(Etals[i])) {
						System.out.println(nb_marchand+ " - " + Etals[i-2]);
					}
					System.out.println(Etals[i]);
				}
				
				int choix_marchand = Clavier.entrerEntier(q_marchand.toString());
				String nom_marchand = "Marchand";
				nb_marchand = 1;
				
				for (int i = 0; i<Etals.length; i++) {
					if(produit.equals(Etals[i]) && choix_marchand == nb_marchand) {
						nom_marchand =  Etals[i-2];
					}
					System.out.println(Etals[i]);
				}
				
				StringBuilder nb_produits = new StringBuilder();
				nb_produits.append("Combien de "+ produit + " voulez-vous acheter");
				
				int nbProduit = Clavier.entrerEntier(nb_produits.toString());
				
				
				
				
				int quantitet_achete = controlAcheterProduit.acheterProduit(nom_marchand, nbProduit);
				System.out.println(nomAcheteur + " a achete " + quantitet_achete +  produit);
				
				
				
			}

//
//		
	}

