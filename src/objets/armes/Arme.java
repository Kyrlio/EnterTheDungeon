package objets.armes;

public class Arme {
	private String nom;
	private float degats;
	private float range;
	private float cooldown;

	public Arme(String nom, float degats, float range, float cooldown) {
		this.nom = nom;
		this.degats = degats;
		this.range = range;
		this.cooldown = cooldown;
	}
	
	//----------GETTERS----------
	public String getNom() {
		return nom;
	}
	public float getDegats() {
		return degats;
	}
	public float getRange() {
		return range;
	}
	public float getCooldown() {
		return cooldown;
	}
	
	//----------SETTERS----------
	public void setDegats(float degats) {
		this.degats = degats;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setRange(float range) {
		this.range = range;
	}

	public void setCooldown(float cooldown) {
		this.cooldown = cooldown;
	}
	
}
