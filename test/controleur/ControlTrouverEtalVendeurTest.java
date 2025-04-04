package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	private ControlTrouverEtalVendeur controlTrouverEtalVeneur;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;


		@BeforeEach
	public void initialiserSituation() {
			village = new Village("le village des irréductibles", 10, 5);
			abraracourcix = new Chef("Abraracourcix", 10, village);
			village.setChef(abraracourcix);
			controlEmmenager = new ControlEmmenager(village);
			controlTrouverEtalVeneur = new ControlTrouverEtalVendeur(village);
			controlVerifierIdentite = new ControlVerifierIdentite(village);

			controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		}
	
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVeneur, "Constructeur ne renvoie pas null");
	}

	void ajouterMarchand(ControlEmmenager controlEmmenager, ControlPrendreEtal controlPrendreEtal,String nom ,String produit) {
		controlEmmenager.ajouterGaulois(nom, 10);
		controlPrendreEtal.prendreEtal(nom, produit, 1);
		
	}
	
	@Test
	void testTrouverEtalVendeur() {
		String nom;
		String produit;
		
		for(int i=0; i< village.donnerNbEtal()-1; i++) { // verfier le bon fonctionnement de trouverEtalVendeur
			nom =  "Gaulois " + i;
			produit = "Produit " + i;
			
			ajouterMarchand(controlEmmenager, controlPrendreEtal, nom, produit);
			
			assertTrue(controlTrouverEtalVeneur.trouverEtalVendeur(nom).equals(village.rechercherEtal(village.trouverHabitant(nom))));
			
		}
		//a modifier trouverEtalVendeur 2.5
		nom = "inconnu";
		
		assertTrue(controlTrouverEtalVeneur.trouverEtalVendeur(nom) == null);

		
		
	}

}
