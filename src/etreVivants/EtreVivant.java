package etreVivants;

public class EtreVivant {
	protected float vie;
	protected String nom;
	protected float degats;
	protected float vitesse; //le héros et les monstres auront une vitesse différentes

	protected EtreVivant(int vie, String nom, float degats, float vitesse) {
		this.vie = vie;
		this.nom = nom;
		this.degats = degats;
		this.vitesse = vitesse;
	}
	

	//----------GETTERS
	public float getVie() {
		return vie;
	}
	public String getNom() {
		return nom;
	}
	public float getDegats() {
		return degats;
	}
	public float getVitesse() {
		return vitesse;
	}
	public boolean estEnvie() {
		return vie > 0;
	}
	
	
	//----------PARLER----------
	public void parler(String texte) {
		System.out.println(prendreParole() + '"' + texte + '"');
	}
	private String prendreParole() {
		return "[" + nom + "] - ";
	}
	
	//----------MOURIR----------
	public void mourir() {
		System.out.println("Le " + this.getNom() + " est mort");
	}
		



}