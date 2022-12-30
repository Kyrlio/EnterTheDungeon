package objets.equipement;

public enum Equipement {
	CASQUE("casque", 10, 0), PLASTRON("plastron", 20, 0), JAMBIERES("jambieres", 15, 0), 
	ANNEAUX_DEGATS("anneaux de degats", 0, 10);
	
	private String nom;
	private float resistance;
	private float degats;
	
	private Equipement(String nom, float resistance, float degats) {
		this.nom = nom;
		this.resistance = resistance;
		this.degats = degats;
	}
	
	@Override
	public String toString() {
		return nom + resistance;
	}
	
	//----------GETTERS----------
	public String getNom() {
		return nom;
	}
	public float getResistance() {
		return resistance;
	}
	public float getDegats() {
		return degats;
	}

	//----------SETTERS----------
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setResistance(float resistance) {
		this.resistance = resistance;
	}
	public void setDegats(float degats) {
		this.degats = degats;
	}

	
}

