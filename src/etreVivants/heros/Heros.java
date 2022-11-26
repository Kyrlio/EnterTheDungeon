package etreVivants.heros;

import etreVivants.EtreVivant;
import etreVivants.monstre.Monstre;
import objets.armes.Arme;

public class Heros extends EtreVivant {
	private float resistance;
	private float xp;
	private float lvl;
	private float lvlup; //nombre a atteindre pour passer au prochain niveau
	private int nbArmes = 0;
	private Arme[] inventaireArmes = new Arme[5];

	public Heros(int vie, String nom, float degats, float vitesse) {
		super(vie, nom, degats, vitesse);
		this.resistance = resistance;
		this.xp = xp;
		this.lvl = lvl;
		this.lvlup = lvlup;
		this.nbArmes = nbArmes;
		this.inventaireArmes = inventaireArmes;
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
				+ "\narmes = " + inventaireArmes
				+"]\n";
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
	public Arme[] getInventaireArme() {
		for (int i = 0 ; inventaireArmes[i] != null && i < inventaireArmes.length ; i++) {
			System.out.println(inventaireArmes[i].getNom());
		}
		return inventaireArmes;
	}


	//----------COMBAT----------
	public void attaquer(Monstre monstre) {
		//TODO faire des dégats a l'ennemi avec une arme
		parler("Je frappe : " + monstre.getNom() + " avec : " + degats + " degats" );
		monstre.recevoirDegats(degats);
	}
	
	public void recevoirDegats(float degats) {
		this.vie -= degats;
		parler("J'ai reçu : " + degats);
		parler("Il me reste " + vie + " pv");
		
		if (estEnvie() == false) {
			//Fin de la partie
			mourir();
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
		if (objet.getClass() == Arme.class) { //Permet de savoir si l'objet en parametre appartient a la classe Arme
			inventaireArmes[nbArmes] = (Arme) objet;
			nbArmes++;
			this.degats = (float) ((Arme) objet).getDegats(); //Ajoute  les dégats de l'épée aux dégats du Héros
			
		}
		
	}
	
	
	//---------GESTION DE L'XP----------


	

}
