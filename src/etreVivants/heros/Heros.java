package etreVivants.heros;

import etreVivants.EtreVivant;
import etreVivants.monstre.Monstre;
import objets.armes.Armes;

public class Heros extends EtreVivant {
	private float resistance;
	private float xp;
	private float lvlup; //nombre a atteindre pour passer au prochain niveau
	private Armes[] arme = new Armes[5];

	public Heros(int vie, String nom, float degats, float vitesse) {
		super(vie, nom, degats, vitesse);
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
				+ "\narmes = " + arme
				+"]\n";
	}
	
	
	//----------GETTERS----------
	public String getNom() {
		return nom;
	}	
	public float getResistance() {
		return resistance;
	}
	public float getXp() {
		return xp;
	}
	public float getLvlup() {
		return lvlup;
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
	public void ramasserObjet() {
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
		
	}


	

}
