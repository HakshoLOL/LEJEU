
public class main {

	public static void affiche(Grille g)  {
	for( int i=0;i<g.getLiCases()[0].length;i++){
		for (int j=0;j<g.getLiCases()[i].length;j++) {
			
			if (g.getLiCases()[i][j] == null)  {
				System.out.print("0|");
			}else {
				System.out.print(g.getLiCases()[i][j].getVal()+" | ");
			}
		}
		System.out.println("");
	}
	}
	
	public static void main(String args[]) {
		
		
		Grille g =new Grille();
		affiche(g);		
		g.mvntDroit();
		affiche(g);
	
	}
}

