package etreVivants;

public class EtreVivant {
	protected int vie;
	protected String nom;
	protected float degats;

	protected EtreVivant(int vie, String nom, float degats) {
		this.vie = vie;
		this.nom = nom;
		this.degats = degats;
	}


	public int getVie() {
		return vie;
	}


	public String getNom() {
		return nom;
	}


	public float getDegats() {
		return degats;
	}



}