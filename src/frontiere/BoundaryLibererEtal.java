package frontiere;

import java.nio.file.spi.FileSystemProvider;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mias vous n'etes pas inscrit sur notre marche aujourd'hui !");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(Boolean.valueOf(donneesEtal[0])) {
				System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + ".");
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journee");
				
				
			}
		}
	}

}
