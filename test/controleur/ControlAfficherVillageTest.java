package controleur;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
		controlEmmenager = new ControlEmmenager(village);
	}
	
	
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");	}

	@Test
	void testDonnerNomsVillageois() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterGaulois("Abraracourcix", 10);
		assertTrue(Arrays.stream(controlAfficherVillage.donnerNomsVillageois()).anyMatch("Bonemine"::equals));
		assertFalse(Arrays.stream(controlAfficherVillage.donnerNomsVillageois()).anyMatch("Pablo"::equals));
		assertTrue(Arrays.stream(controlAfficherVillage.donnerNomsVillageois()).anyMatch("Abraracourcix"::equals));
		

		
	}

	@Test
	void testDonnerNomVillage() {
		assertTrue(controlAfficherVillage.donnerNomVillage().equals("le village des irréductibles"));	
				}

	@Test
	void testDonnerNbEtals() {
		assertTrue(village.donnerNbEtal()==5);
		
	}

}
