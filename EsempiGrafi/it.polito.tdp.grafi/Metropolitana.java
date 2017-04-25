import org.jgrapht.graph.DirectedWeightedMultigraph;

public class Metropolitana {

	public static void main(String[] args) {
		DirectedWeightedMultigraph<Stazione, Collegamento> grafo = new DirectedWeightedMultigraph<Stazione, Collegamento>(Collegamento.class);
		
		grafo.addVertex(new Stazione("A"));
		grafo.addVertex(new Stazione("B"));
		grafo.addVertex(new Stazione("C"));
		grafo.addVertex(new Stazione("D"));
		
		//posso far creare il collegamento ad addEdge
		Collegamento coll = grafo.addEdge(new Stazione("A"), new Stazione("B"));
		coll.setLinea(1);
		
		coll = grafo.addEdge(new Stazione("A"), new Stazione("B"));
		coll.setLinea(2);
		
		//oppure creo io il collegamento e lo passo ad addEdge come parametro
		coll = new Collegamento(1);
		grafo.addEdge(new Stazione("B"), new Stazione("C"), coll);
		
		coll = new Collegamento(2);
		grafo.addEdge(new Stazione("B"), new Stazione("D"), coll);
		
		System.out.println(grafo.toString());
		
		//voglio la stampa di tutti i collegamenti della linea 1	
		for(Collegamento c : grafo.edgeSet()){
			if(c.getLinea()== 1)
				System.out.format("%s-%s \n", grafo.getEdgeSource(c),
												grafo.getEdgeTarget(c));
		}		
	}
}
