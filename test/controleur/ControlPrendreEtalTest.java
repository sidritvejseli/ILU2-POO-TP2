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

	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 1);
		
		assertTrue(controlPrendreEtal.resteEtals());
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 1);
		
		assertTrue(controlPrendreEtal.resteEtals());
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 1);
		
		assertTrue(controlPrendreEtal.resteEtals());
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 1);
		
		assertTrue(controlPrendreEtal.resteEtals());
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 1);
		
		assertFalse(controlPrendreEtal.resteEtals());

	}

	@Test
	void testPrendreEtal() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 1) == 0);
		
		controlEmmenager.ajouterGaulois("Bob", 10);
		assertTrue(controlPrendreEtal.prendreEtal("Bob", "fleurs", 1) == 1);
		
		//System.out.println(controlPrendreEtal.prendreEtal("Inconnu", "fleurs", 1));
		//L'identite du marchand est verifie dans boundary
		
		controlEmmenager.ajouterGaulois("Pano", 10);
		assertTrue(controlPrendreEtal.prendreEtal("Pano", "fleurs", 1) == 2);
		
		controlEmmenager.ajouterGaulois("Asterix", 10);
		assertTrue(controlPrendreEtal.prendreEtal("Asterix", "fleurs", 1) == 3);
		
		controlEmmenager.ajouterGaulois("Obelix", 10);
		assertTrue(controlPrendreEtal.prendreEtal("Obelix", "fleurs", 1) == 4);
		
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
