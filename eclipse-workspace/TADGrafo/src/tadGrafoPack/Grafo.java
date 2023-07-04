package tadGrafoPack;

import java.util.ArrayList;

public class Grafo {
	
	public ArrayList<Vertice> VerticesGrafo;

	/* ===============Vertice é a quina/esquina/encruzilhada===========
	 * 
	 * representado de diversas maneiras:
		• Matriz de adjacência
		• Matriz de custos
		• Matriz de incidência
		• Lista de adjacência
		• Lista de arestas V (e se eu tiver um array de arestas? até as isoladas vão aparecer)
		
		
		METODOS	
		– finalVertices(e)
		• Retorna um array armazenando os vértices finais da aresta e.
		
		– oposto(v, e)
		• Retorna o vértice oposto de v em e, ou seja, o vértice final da
		aresta e separado do vértice v. Um erro ocorre se e não é
		incidente a v
		
		– éAdjacente(v, w)
		• Retorna true se v e w são adjacentes
		
		(acesso -simplificado)
		
		– substituir(v, x)
		• Substitui o elemento armazenado no vértice V por X
		
		– substituir(e, x)
		• Substitui o elemento armazenado na aresta e com x
		
		(Métodos Iteradores -simplificado)
		– arestasIncidentes(v)
		• Retorna uma coleção de todas as arestas incidentes sob o
		vértice v (vértice v)
		
		– vertices()
		• Retorna uma coleção de todos os vértices no grafo.
		– arestas()
		• Retorna uma coleção de todas as arestas no grafo
		
		(Métodos Iteradores -simplificado)
		– arestasIncidentes(v)
		• Retorna uma coleção de todas as arestas incidentes sob o
		vértice v (vértice v)
		
		– vertices()
		• Retorna uma coleção de todos os vértices no grafo.
		– arestas()
		• Retorna uma coleção de todas as arestas no grafo
		
		– éDirecionado(e)
		• Testa se a aresta é direcionada
		
		– inserirArestaDirecionada(v,w,o)
		• Insirir uma nova aresta dirigida com origem em v e destino
		em w e armazenando o elemento o.
		
				
	 * */
	
	public Grafo(){}
	//==================Insert=====================

	public void inserirVertice(Vertice newVertice){
		this.VerticesGrafo.add(newVertice);
		System.out.println("Vertice "+newVertice.varVertice+" foi adicionado ao grafo");
	}
	
	public void insertAresta(Vertice Vertice1, Vertice Vertice2, int NewAresta ){
		Aresta novaAresta = new Aresta(Vertice1, Vertice2, NewAresta);
		Vertice1.arestas.add(novaAresta);
		Vertice2.arestas.add(novaAresta);
		
	}
	
	//=================Remove======================

	public int removeAresta(Aresta aresta){
		aresta.VerInit.arestas.remove(aresta);
		aresta.VerFim.arestas.remove(aresta);
		
		return aresta.varAresta;
	}

	public int reomoveVertice(Vertice vertice){
		for(int i = 0 ; i < vertice.arestas.size() ; i ++ ){
			removeAresta(vertice.arestas.get(i));	
		}
		this.VerticesGrafo.remove(vertice);
		return vertice.varVertice;
	}
	
	
	//============Métodos Find Element===========
    public Vertice findVertice(int procurado) {
    	// Eu não tenho ideia de como fazer essa busca
    	for(i=0; ;){
    		
    	}
    	
    	
    	Vertice encontrado = procurado;
    	return encontrado;
    }
    public Aresta findAresta(int procurado) {
    	// Eu não tenho ideia de como fazer essa busca
    	Aresta encontrado = procurado;
    	return encontrado;
    }
    //============================================
}
