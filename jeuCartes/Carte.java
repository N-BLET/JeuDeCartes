package jeuCartes;

public class Carte {
	//Instances de l'objet
	private String couleur, valeur;
	
	//Valeurs et couleurs possibles d'une carte (les valeurs sont dans l'ordre croissant, en considérant que l'as est la plus forte)
	public static final String [] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
	public static final String [] color = {"PIQUE", "COEUR", "CARREAU", "TRÈFLE"};
	
	//Constructeur
	public Carte (String valeur, String couleur) {
		this.valeur = valeur;
		this.couleur = couleur;
	}
	
	//Récupération de la valeur de la carte pas besoin de modification donc pas de setter
	public String getValeur() {
		return valeur;
	}
	
	//Récupération de la couleur de la carte et si besoin mise à jour de la couleur pour éviter de sortir 2 fois la même carte car impossible dans un jeu de 52
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}	
	
	//Méthode qui compare les index du tableau des valeurs des cartes et qui affiche la plus forte des 2
	public void comparer(Carte carte2) {
		int index1 = 0;
		int index2 = 0;
		int tailleValue = value.length;
		for (int i = 0; i < tailleValue ; i++) {
			if(value[i].equalsIgnoreCase(this.getValeur())) {
				index1 = i;
			}else if (value[i].equalsIgnoreCase(carte2.getValeur())) {
				index2 = i;
			}
		}
		
		if(index1 < index2) {
			System.out.println(carte2);
		}else {
			System.out.println(this);
		}	 
	}
	
	//Méthode pour afficher le résultat
	public String toString() {
		return "La carte la plus forte des deux est : " + valeur + " de " + couleur;
	}
	
}
