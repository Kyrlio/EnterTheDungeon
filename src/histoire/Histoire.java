package histoire;

import etreVivants.heros.Heros;
import etreVivants.monstre.Monstre;
import objets.armes.Arme;
import objets.equipement.Equipement;

public class Histoire {

	public static void main(String[] args) {	
		Arme epee = new Arme("Epee", 2, 1, 1);
		Heros heros = new Heros(10, "Héros", 1, 7, 50);
		heros.parler("Je suis le Héros, je vais tuer tous les monstres");
		//System.out.println(heros.toString());
		
		Monstre monstre1 = new Monstre(2, "Monstre1", 1, 4);
		monstre1.parler("Je suis le monstre1 et je fonce sur le Héros");
		System.out.println(monstre1.toString());
		System.out.println(monstre1.estEnvie());
		
		heros.attaquer(monstre1);
		heros.parler("Je m'arme de mon épée");
		heros.ramasserObjet(epee);
		heros.attaquer(monstre1);
		heros.gagnerXP();
		heros.getInventaire();
		
		monstre1.attaquer(heros);
		heros.attaquer(monstre1);
		
		//----------2eme monstre----------
		System.out.println();
		
		Monstre monstre2 = new Monstre(5, "Monstre2", 2, 4);
		monstre2.parler("Je suis le monstre2 et je fonce sur le Héros");
		System.out.println(monstre2.toString());
		System.out.println(monstre2.estEnvie());
		
		monstre2.attaquer(heros);
		heros.attaquer(monstre2);
		
		Arme epee2 = new Arme("Epee", 2, 1, 1);
		heros.ramasserObjet(epee2);
		heros.fusionnerArme();
		
		//-----Ajout d'équipements-----
		heros.ramasserObjet(Equipement.CASQUE);
		heros.ramasserObjet(Equipement.ANNEAUX_DEGATS);
		heros.ramasserObjet(Equipement.PLASTRON);
		heros.getInventaire();
		heros.getInventaireDetaille();
		System.out.println(heros.toString());
		
		//-----3eme monstre-----
		Monstre monstre3 = new Monstre(7, "Monstre3", 2, 4);
		monstre3.parler("Je suis le monstre3 et je fonce sur le Héros");
		monstre3.attaquer(heros);
		heros.attaquer(monstre2);
		monstre2.attaquer(heros);
		heros.attaquer(monstre2);
		

	}

}
