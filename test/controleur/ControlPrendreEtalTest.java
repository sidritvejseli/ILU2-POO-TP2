package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerfierIndentite;
	

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlEmmenager = new ControlEmmenager(village);
		controlVerfierIndentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerfierIndentite,village);
	}
	@Test
	void testControlPrendreEtal() {
		
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
		
	}

	
	void ajouterMarchand(ControlEmmenager controlEmmenager, ControlPrendreEtal controlPrendreEtal,String nom ,String produit) {
		controlEmmenager.ajouterGaulois(nom, 10);
		controlPrendreEtal.prendreEtal(nom, produit, 1);
		
	}
	
	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		String nom;
		String produit;
		
		for (int i = 0; i < village.donnerNbEtal(); i++) {
			assertTrue(controlPrendreEtal.resteEtals());
			nom = "Gaulois" + i;
			produit = "Produit" + i;
			ajouterMarchand(controlEmmenager, controlPrendreEtal, nom, produit);
			
		}

		assertFalse(controlPrendreEtal.resteEtals());

	}

	@Test
	void testPrendreEtal() {
		String nom;
		String produit;
	
		
		for (int i = 0; i < village.donnerNbEtal(); i++) {
			nom = "Gaulois" + i;
			produit = "Produit" + i;
			
			controlEmmenager.ajouterGaulois(nom, 10);
			assertTrue(controlPrendreEtal.prendreEtal(nom,produit , 1) == i);
			
		}
		
		
		controlEmmenager.ajouterGaulois("Obelix", 10);
		assertTrue(controlPrendreEtal.prendreEtal("Obelix", "fleurs", 1) == -1);
	}

	@Test
	void testVerifierIdentite() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
		
		assertFalse(controlPrendreEtal.verifierIdentite("Bob"));
		
	
		
	}

}
