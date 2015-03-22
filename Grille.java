import java.util.ArrayList;

/**
 * Classe représentant la grille de jeu contenant les cases
 * 
 * @author Adrien
 *
 */
public class Grille {

	/**
	 * Liste des cases
	 */
	private Case[][] lcase;
	private final int TAILLE = 4;
	
	/**
	 * Contruit une nouvelle grille
	 * avec 2 cases de 0 ou 4 en valeur
	 * 
	 */
	public Grille() {
		// a changer par des randoms
		this.lcase=new Case[this.TAILLE][this.TAILLE];
		this.ajouteCaseAleat();
		this.ajouteCaseAleat();
	}
	
	public Case[][] getLiCases() {	return this.lcase;	}
	
	/**
	 * Fonction créant une valeur de départ d'une case 2 ou 4
	 * @return val aléatoire 2 ou 4
	 */
	public int valDep() { // pour avoir les valeurs aleatoires
		double ale=(Math.random());
		int val;
		if (ale <= 0.6) { // 60% 2
			val=2;
		} else { // 40% 4
			val=4;
		}
		return val;
	}
	
	/**
	 * Fonction ajoutant une case aléatoirement dans l'espace dispo
	 * val de 2 ou 4
	 */
	public void ajouteCaseAleat(){
		ArrayList<Position> vide = this.caseVides();
		int rand = (int)(Math.random()*(vide.size() )); // un aleatoire parmis les vides
		Position p = vide.get(rand);
		Case c = new Case(valDep(),p); // nouvelle case
    	this.lcase[p.getY()][p.getX()]=c; // insertion de la case
	}
	
	/**
	 * Fonction retournant la liste des position libres
	 * @return positions libres
	 */
	public ArrayList<Position> caseVides() {
		ArrayList<Position> liVide = new ArrayList<Position>();
		for (int i=0;i<this.lcase.length;i++){
			for (int j=0;j<this.lcase[i].length;j++) {
				if(this.lcase[i][j]== null ) {
					liVide.add(new Position(i,j));
				}
			}
		}
		return liVide;	
	}
		
	
	
}


