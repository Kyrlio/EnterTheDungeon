package objets.armes;
/*
 * Les armes attaquent en continue mais ont des spécificités différentes
 * ex : l'épée attaque tout droit dans la direction du Héros
 * Le pistolet tire un projectile en direction du monstre le plus proche
 * Le champ de force est un cercle qui entoure le Héros et si les ennemis rentrent dans ce cerle ça leur fait des dégats tout les x sec
 */
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
	
}
