package etreVivants.heros;

import java.util.Random;
import java.util.Scanner;

import etreVivants.EtreVivant;
import etreVivants.monstre.Monstre;
import objets.armes.Arme;
import objets.equipement.Equipement;

public class Heros extends EtreVivant {
	private float resistance = 1; //pourcentage a appliquer sur les dégats reçu
	private float xp;
	private float lvl;
	private float lvlup = 1; //nombre a atteindre pour passer au prochain niveau
	private int nbArmes = 0;
	private Arme[] inventaireArme = new Arme[5];
	private int esquive;
	private int nbEquipement = 0;
	private Equipement[] inventaireEquipement = new Equipement[10];
	
	//Les dégats du Héros sont en pourcentage et sont a rajouté a chaque attaque

	public Heros(int vie, String nom, float degats, float vitesse, int esquive) {
		super(vie, nom, degats, vitesse);
		this.resistance = resistance;
		this.xp = xp;
		this.lvl = lvl;
		this.lvlup = lvlup;
		this.nbArmes = nbArmes;
		this.inventaireArme = inventaireArme;
		this.esquive = esquive;
	}
	
	
	//----------Affichage des attributs----------
	@Override
	public String toString() {
		return "[nom = " + nom 
				+ "\nvie = " + vie 
				+ "\nresistance = " + resistance 
				+ "\ndegats = "+ degats
				+ "\nvitesse = " + vitesse
				+ "\nxp = " + xp
				+ "\nlvlup = " + lvlup
				+ "\narmes = " + inventaireArme
				+ "\nesquive = " + esquive
				+ "]\n";
	}
	
	
	//----------GETTERS----------
	public float getResistance() {
		return resistance;
	}
	public float getXp() {
		return xp;
	}
	public float getLvl(){
		return lvl;
	}
	public float getLvlup() {
		return lvlup;
	}	
	public int getEsquive() {
		return esquive;
	}
	
	//----------SETTERS----------
	public void setResistance(float resistance) {
		this.resistance = resistance;
	}	
	public void setXp(float xp) {
		this.xp = xp;
	}	
	public void setLvl(float lvl) {
		this.lvl = lvl;
	}	
	public void setLvlup(float lvlup) {
		this.lvlup = lvlup;
	}	
	public void setEsquive(int esquive) {
		this.esquive = esquive;
	}	
	
	//----------AFFICHE L'INVENTAIRE----------
	public void getInventaire() {
		System.out.println("\nArmes :");
		System.out.print("[");
		for (int i = 0 ; inventaireArme[i] != null && i < inventaireArme.length ; i++) {
			System.out.print(inventaireArme[i].getNom() + ",");
		}
		System.out.println("]\n");
		
		System.out.println("Equipements :");
		System.out.print("[");
		for (int i = 0 ; inventaireEquipement[i] != null && i < inventaireEquipement.length ; i++) {
			System.out.print(inventaireEquipement[i].getNom() + ",");
		}
		System.out.println("]\n");

	}
	
	public void getInventaireDetaille() {
		System.out.println("\nArmes :");
		System.out.print("[");
		for (int i = 0 ; inventaireArme[i] != null && i < inventaireArme.length ; i++) {
			System.out.print(inventaireArme[i].getNom() + " : "
					+ "dégats : " + inventaireArme[i].getDegats()
					+ "\n	range : " + inventaireArme[i].getRange()
					+ "\n	cooldown : " + inventaireArme[i].getCooldown()
					+ ",\n");
		}
		System.out.println("]\n");
		
		System.out.println("Equipements :");
		System.out.print("[");
		for (int i = 0 ; inventaireEquipement[i] != null && i < inventaireEquipement.length ; i++) {
			System.out.print(inventaireEquipement[i].getNom() + " : "
					+ "dégats : " + inventaireEquipement[i].getDegats()
					+ "\n	résistance : " + inventaireEquipement[i].getResistance()
					+ ",\n");
		}
		System.out.println("]\n");

	}
	

	//----------COMBAT----------
	public void attaquer(Monstre monstre) {
		//TODO faire des dégats a l'ennemi avec une arme
		if (monstre.estEnvie()) {
			if (inventaireArme[0] == null) {
				parler("Je n'ai pas d'armes, je ne peux pas attaquer le monstre !");
			} else {
				parler("Je frappe : " + monstre.getNom() + " avec : " + inventaireArme[0].getNom() + " avec : " 
						+ inventaireArme[0].getDegats() + " degats plus une augmentation de " + degats + "%" );
				monstre.recevoirDegats(inventaireArme[0].getDegats() + inventaireArme[0].getDegats() * (degats/100) );
			}
		} else {
			gagnerXP();
			parler("Ce monstre est déjà mort, je ne peux plus l'attaquer !");
		}
	}
	
	public void recevoirDegats(float degats) {
		this.vie -= degats - resistance/100;
		parler("J'ai : " + resistance + " de résistance. Mes dégats reçu sont soustrais à celle-ci.");
		parler("J'ai reçu : " + (degats - resistance/100));
		parler("Il me reste " + vie + " pv");
		
		if (estEnvie() == false) {
			//Fin de la partie
			mourir();
		}
	}
	
	public boolean esquiverAttaque() {
		  // Génère un nombre aléatoire entre 0 et 99
		  int nombreAleatoire = (int)(Math.random() * 100);

		  if (nombreAleatoire < this.esquive) {
		    // Le héros réussit à esquiver l'attaque
		    System.out.println("Le héros a réussi à esquiver l'attaque du monstre !");
		    return true;
		  } else {
		    // Le héros ne réussit pas à esquiver l'attaque
		    System.out.println("Le héros n'a pas réussi à esquiver l'attaque du monstre !");
		    return false;
		  }
		}

	
	//----------RAMASSER UN OBJET----------
	public void ramasserObjet(Object objet) {
		/*TODO
		 * Si l'objet est de l'xp
		 * 	ajoute de l'xp au Héros
		 * Si l'objet est de la nourriture
		 * 	ajoute de la vie si le Héros en a besoin
		 * Si l'objet est une arme
		 * 	Si le Héros à déjà l'arme
		 * 		augmente les dégats de l'arme
		 * 	sinon : ajoute l'arme au tableau d'armes
		 * Si l'objet est une armure
		 * 	augmente la résistance de l'armure et donc du Héros
		 * 
		 */
		
		if (objet instanceof Arme) {
			parler("Je ramasse l'arme par terre : " + ((Arme) objet).getNom());
			inventaireArme[nbArmes] = (Arme) objet;
			nbArmes++;
		}
		if (objet instanceof Equipement) {
			parler("Je ramasse l'équipement : " + ((Equipement) objet).getNom());
			inventaireEquipement[nbEquipement] = (Equipement) objet;
			nbEquipement++;
			ajouterEquipement((Equipement) objet);
			
		}
		
	}
	
	
	//---------GESTION DE L'XP----------
	public void gagnerXP() {
		parler("Je gagne 1 xp");
		xp += 1;
		if (xp >= lvlup) {
			lvlUp();
		}
	}
	


	public void lvlUp() {
		parler("J'ai gagné un niveau !");
		lvl++;
		lvlup+=5;
		parler("Je suis passé niveau " + getLvl() + ", il me faut gagner " + getLvlup() + " xp pour passer au niveau prochain");	
	}
	
	
	//----------GESTION INVENTAIRE----------
	public int fusionnerArme() {
		Scanner scanner = new Scanner(System.in);
		
		//Affiche l'inventaire du Héros
		getInventaire();
		
		System.out.println("Vous devez avoir 2 armes identiques pour les fusionner.");
		System.out.println("Veuillez choisir l'index de la première arme à fusionner : ");
		int arme1 = scanner.nextInt();
		System.out.println("Veuillez choisir l'index de la deuxième arme à fusionner : ");
		int arme2 = scanner.nextInt();
		
		if (arme1 > arme2) {
			int tmp = arme1;
			arme1 = arme2;
			arme2 = tmp;
		}
		
		String tmpNom = inventaireArme[arme1].getNom();
		float tmpDeg = inventaireArme[arme1].getDegats();
		
		if (arme1 >= 0 && arme1 < nbArmes && arme2 >= 0 && arme2 < nbArmes && arme1 != arme2 && inventaireArme[arme1].getNom().equals(inventaireArme[arme2].getNom())) {
			//Supprime la 2eme arme et ajouter 25% de dégats à l'arme1 qui monte d'un nivea
			inventaireArme[arme1].setDegats(inventaireArme[arme1].getDegats() + inventaireArme[arme1].getDegats()*25/100);
			inventaireArme[arme1].setNom(inventaireArme[arme1].getNom() + "I");
			inventaireArme[arme2] = null;
			getInventaire();
			
		} else {
			System.out.println("Impossible de fusionner cex 2 armes.");
			fusionnerArme();
		}
		
		System.out.println("Vous avez améliorer votre arme : " + tmpNom + " --> " + inventaireArme[arme1].getNom());
		System.out.println("Les dégats ont augmenté de 25% : " + tmpDeg + " --> " + inventaireArme[arme1].getDegats());
		
		return 0;
	}
	
	public void ajouterEquipement(Equipement equipement) {	
		this.resistance = resistance + resistance * (equipement.getResistance()/100);
		this.degats = degats + degats * (equipement.getDegats()/100);
	}
	

}
