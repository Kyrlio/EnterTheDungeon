package etreVivants.monstre;

import etreVivants.EtreVivant;
import etreVivants.heros.Heros;

public class Monstre extends EtreVivant {

	public Monstre(int vie, String nom, float degats, float vitesse) {
		super(vie, nom, degats, vitesse);
		
	}
	
	//----------Affichage des attributs----------
	@Override
	public String toString() {
		return "[nom = " + nom 
				+ "\nvie = " + vie 
				+ "\ndegats = "+ degats
				+ "\nvitesse = " + vitesse
				+"]\n";
	}
	
	//----------COMBAT----------
	public void attaquer(Heros heros) {
		//TODO faire des dégats a l'ennemi
		parler("Je frappe : " + heros.getNom() + " avec : " + degats + " degats" );
		heros.recevoirDegats(degats);
	}
	
	public void recevoirDegats(float degats) {
		this.vie -= degats;
		parler("J'ai reçu : " + degats + " dégats");
		parler("Il me reste " + vie + " pv");
		
		if (estEnvie() == false) {
			//Fin de la partie
			mourir();
		}
	}

}
