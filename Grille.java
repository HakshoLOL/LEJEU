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
		ArrayList<Position> liVide = new ArrayList<Position>(); // liste vide
		for (int i=0;i<this.lcase.length;i++){ // parcourt de "x"
			for (int j=0;j<this.lcase[i].length;j++) { // pacourt des "y"
				if(this.lcase[i][j]== null ) { // si null ajou a la liste des cases vides
					liVide.add(new Position(i,j));
				}
			}
		}
		return liVide;	
	}
		
	public ArrayList<Position> casePleines() {
		ArrayList<Position> liPlein = new ArrayList<Position>(); 
		for (int i=0;i<this.lcase.length;i++){ // parcourt de "x"
			for (int j=0;j<this.lcase[i].length;j++) { // pacourt des "y"
				if(this.lcase[i][j]!= null ) { // si null ajou a la liste des cases pleine
					liPlein.add(new Position(i,j));
				}
			}
		}
		return liPlein;	
	}
	

	
	public void mvntDroit() {
		ArrayList<Position> lplein = this.casePleines();// récupération des cases pleines
		int temp = -1;
		for (int i=0;i<lplein.size();i++) { // parcourt des x avec des cases
	
			if (temp != lplein.get(i).getX()) { // UN TRAITEMENT PAR LIGNE
				System.out.println("traitement en X="+ lplein.get(i).getX() );
				Case[] ligne = this.lcase[lplein.get(i).getX() ];
				// traitement par ligne mouvement horizontal
				int taille=0;
				for( int k=0;k<ligne.length;k++){
					if (ligne[k] != null)
						taille++;
				}
				
				// un seul élément
				if (taille == 1) {
					if (ligne[TAILLE-1]== null) { // pas déjà a la fin
						int col=-1;
						for (int j = 0; j < ligne.length; j++) {
							if (ligne[j]!=null) {
								col=j;
							}	
						}
						this.lcase[lplein.get(i).getX()][TAILLE-1]=this.lcase[lplein.get(i).getX()][col];
						this.lcase[lplein.get(i).getX()][TAILLE-1].setPos(new Position(lplein.get(i).getX(),TAILLE-1));
						this.lcase[lplein.get(i).getX()][col] = null;
						
					}
				}
				
				
				
				temp=lplein.get(i).getX(); // var temporaire pour traitement par ligne
			}
		}
		
	}
	
	
}


