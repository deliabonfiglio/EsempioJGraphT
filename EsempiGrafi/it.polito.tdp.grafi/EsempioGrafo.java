import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.SimpleGraph;

public class EsempioGrafo {
/*
 * grafo non diretto, semplice e non pesato
 * oggetto di tipo simple graph
 */
	void esempio1(){
		UndirectedGraph<Integer, DefaultEdge> grafo = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
		//voglio creare un grafo
		//aggiungo i vertici
		for(int i=1; i<=6; i++)
			grafo.addVertex(i);
		System.out.println(grafo.toString());
		//aggiungo archi
		grafo.addEdge(1,2);
		grafo.addEdge(2,3);
		grafo.addEdge(1,3);
		
		grafo.addEdge(5,6);
		System.out.println(grafo.toString());
		
		//questo arco viene scartato xk già esiste
		grafo.addEdge(5,6);
	}
	/*
	 * grafo diretto, multi, e pesato
	 */
	void esempio2(){
		DirectedWeightedMultigraph<Integer, DefaultWeightedEdge>grafo= new 	DirectedWeightedMultigraph<Integer, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		//voglio creare un grafo
		//aggiungo i vertici
		for(int i=1; i<=6; i++)
			grafo.addVertex(i);
		
		System.out.println(grafo.toString());
		//aggiungo archi
		grafo.addEdge(1,2);
		grafo.addEdge(2,3);
		grafo.addEdge(1,3);
		
		grafo.addEdge(5,6);
		System.out.println(grafo.toString());
		grafo.addEdge(5,6);
		
		//oppure cosi iterando sugli archi
		DefaultWeightedEdge e = grafo.addEdge(1, 2);
		grafo.setEdgeWeight(e, 0.2);
		
		for(DefaultWeightedEdge arch: grafo.edgeSet()){
			System.out.println(arch);
			//System.out.println(grafo.getEdgeWeight(arch));
			System.out.format("%d-%d peso: %f\n", grafo.getEdgeSource(arch),
											grafo.getEdgeTarget(arch),
											grafo.getEdgeWeight(arch));
		}
		//itero sui vertici
		for(Integer vertex: grafo.vertexSet()){
			//archi incidenti sul v
			System.out.format("vertex: %d\n", vertex);
			for(DefaultWeightedEdge arch: grafo.edgesOf(vertex)){
				//posso usare questo
				System.out.format("---adiacent vertex: %d\n", Graphs.getOppositeVertex(grafo, arch, vertex));
				//oppure questo ma ottengo lo stesso risultato
				if(grafo.getEdgeSource(arch)== vertex){
					System.out.format("adiacent vertex: %d\n", grafo.getEdgeTarget(arch));
				} else {
					System.out.format("adiacent vertex: %d\n",grafo.getEdgeSource(arch));
				}
			}
			//stampare per ogni ertice il grado
			System.out.format("inDegree: %d -- outDegree: %d\n",
								grafo.inDegreeOf(vertex),
								grafo.outDegreeOf(vertex));			
		}	
		
		System.out.println("\nNeighbours of 3:");
		System.out.println(Graphs.neighborListOf(grafo,  3));
		
		System.out.println("\nSuccessors of 3:");
		System.out.println(Graphs.successorListOf(grafo,  3));
	}
	public static void main(String[] args) {

		EsempioGrafo eg = new EsempioGrafo();
		eg.esempio1();

		System.out.println();

		eg.esempio2();

	}

}
