public class Case {
	
	private int val;
	private Position pos;
	
	public Case(int n, Position p) {
		this.pos=p;
		this.val = n;
	}

	public Position getPos() { return this.pos; }
	public int getVal() { return this.val; }
}
