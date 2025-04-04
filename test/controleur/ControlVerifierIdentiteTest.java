package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	private ControlVerifierIdentite controlVerifierIdentite;



		@BeforeEach
	public void initialiserSituation() {
			village = new Village("le village des irréductibles", 10, 5);
			abraracourcix = new Chef("Abraracourcix", 10, village);
			village.setChef(abraracourcix);
			controlEmmenager = new ControlEmmenager(village);
			controlVerifierIdentite = new ControlVerifierIdentite(village);
		}
	

	@Test
	void testVerifierIdentite() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));
		controlEmmenager.ajouterGaulois("Bonemine", 15);
		assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));
		
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
		

		assertFalse(controlVerifierIdentite.verifierIdentite("Bob"));
		
		
		}

}
