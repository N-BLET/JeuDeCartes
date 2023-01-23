/*Auditeur : Nicolas BLET
* Objectif : cr�er un fichier java permettant la comparaison de 2 cartes*/

package jeuCartes;
import java.util.Random;

//La classe "Carte"
public class CarteEnvoye {
	//Instances de l'objet
	private String couleur, valeur;
	
	//Valeurs et couleurs possibles d'une carte (les valeurs sont dans l'ordre croissant, en consid�rant que l'as est la plus forte)
	public static final String [] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
	public static final String [] color = {"PIQUE", "COEUR", "CARREAU", "TR�FLE"};
	public static final int tailleTabValue = value.length;
	public static final int tailleTabColor = color.length;
	
	//Constructeur avec v�rification des donn�es pass�es en param�tre
	public CarteEnvoye (String valeur, String couleur) {
		for (int i = 0; i < tailleTabValue ; i++) {
			if(valeur.equalsIgnoreCase(value[i])) {
				this.valeur = valeur;
			}
		}
		if(this.valeur==null){
			throw new IllegalArgumentException("Erreur : Cette valeur n'est pas r�pertori�e.");
		}
		for (int i = 0; i < tailleTabColor; i++) {
			if(couleur.equalsIgnoreCase(color[i])) {
				this.couleur = couleur;
			}
		}
		if(this.couleur==null){
			throw new IllegalArgumentException("Erreur: Cette couleur n'est pas r�pertori�e.");
		}
	}
	
	//R�cup�ration de la valeur de la carte pas besoin de modification donc pas de setter
	public String getValeur() {
		return valeur;
	}
	
	//R�cup�ration de la couleur de la carte pas besoin de modification donc pas de setter
	public String getCouleur() {
		return couleur;
	}
		
	//M�thode qui compare les valeurs du tableau "value" � ceux des cartes afin de r�cup�rer l'index de la valeur la plus grande
	public  CarteEnvoye comparer(CarteEnvoye carte2) {
		int index1 = 0;
		int index2 = 0;
		for (int i = 0; i < tailleTabValue ; i++) {
			if(value[i].equalsIgnoreCase(this.getValeur())) {
				index1 = i;
			}if (value[i].equalsIgnoreCase(carte2.getValeur())) {
				index2 = i;
			}
		}
		
		if(index1 < index2) {
			return carte2;
		}else {
			return this;
		}	 
	}
	
	//M�thode pour afficher le r�sultat
	public String toString() {
		return "La carte a pour valeur: " + valeur + " et pour couleur: " + couleur;
	}
	

	//M�thode "main"
	public static void main(String[] args) {
		//Initialisation de 4 valeurs al�atoires (2 correspondants � la valeur de chaque carte et de m�me 2 pour la couleur)	
		Random [] randValue = {new Random(), new Random()};
		Random [] randColor = {new Random(), new Random()};
		
		//R�cup�ration de fa�on al�atoire d'une valeur et d'une couleur pour chaque carte
		String [] valeurs = {Carte.value[randValue[0].nextInt(12)], Carte.value[randValue[1].nextInt(12)]};
		String [] couleurs = {Carte.color[randColor[0].nextInt(4)], Carte.color[randColor[1].nextInt(4)]};
		
		//Cr�ation des 2 cartes
		CarteEnvoye [] cartes = new CarteEnvoye [2]; 
		for (int i = 0; i < 2; i++) {
			cartes[i] = new CarteEnvoye (valeurs[i], couleurs[i]);
		}
		
		//Affichage des 2 cartes en utilisant les m�thodes "getValeur" et "getCouleur"
		for (int i = 0; i < 2; i++) {
			System.out.println("La carte N�" + (i+1) + " est : " + cartes[i].getValeur() + " de " + cartes[i].getCouleur());
		}
		
		//Affichage des 2 cartes en utilisant la m�thode "toString"
		for (int i = 0; i < 2; i++) {
			System.out.println(cartes[i]);
		}
		
		//Appel de la m�thode "comparer" pour comparer et afficher la carte la plus forte
		System.out.println("La carte la plus forte des deux est :" + cartes[0].comparer(cartes[1]));;
	}

}