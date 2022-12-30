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
				+ "\ndegats = " + degats
				+ "\nvitesse = " + vitesse
				+ "]\n";
	}
	
	//----------COMBAT----------
	public void attaquer(Heros heros) {
		//TODO faire des dégats a l'ennemi
		if (this.estEnvie()) {
			parler("Je frappe : " + heros.getNom() + " avec : " + degats + " degats" );
			if (heros.esquiverAttaque() == false) {			
				heros.recevoirDegats(degats);
			} else {
				heros.parler("Je ne reçois pas de dégats !");
			}
		} else {
			parler("Je suis mort, je ne peux plus attaquer !");
		}
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
