package tadGrafoPack;

public class Aresta {

	/* =============Aresta é a linha/rua============ 
	 * */
	
	public int varAresta;
	public Vertice VerInit;
	public Vertice VerFim;
	
	public Aresta(Vertice VerInit, Vertice VerFim, int varAresta ){
		this.VerInit = VerInit;
		this.VerFim = VerFim;
		this.varAresta = varAresta;
		
	}
	
}
