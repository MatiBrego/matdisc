package matdisc.graph;
import java.util.ArrayList;


public class Guia2<T> {
    public void a(Graph<T> graph){ //Mostrar el grafo. 
        System.out.println("Vertices:");
        for (int i = 0; i < graph.orden(); i++) {
            System.out.println(graph.getVertice(i));
        }
        System.out.println("Aristas:");
        for (int i = 0; i < graph.orden(); i++) {
            ArrayList<Integer> ady = graph.getListAdy(i);
            for (Integer num : ady) {
                System.out.println(graph.getVertice(i) + " " + graph.getVertice(num));
            }
        }
    }

    public int b(Graph<T> graph){ //Retornar la cantidad de lazos de un grafo
        int qty = 0;
        for (int i = 0; i < graph.orden(); i++) {
            if (graph.existsEdge(i, i))
                qty ++;
        }
        return qty;
    }

    public ArrayList<T> c(Graph<T> graph){ //Retornar un arreglo con los vértices que tienen lazos
        ArrayList<T> vertexes_with_lazos = new ArrayList<>();
        for (int i = 0; i < graph.orden(); i++) {
            if (graph.existsEdge(i, i))
                vertexes_with_lazos.add(graph.getVertice(i));
        }
        return vertexes_with_lazos;
    }

    public boolean d(Graph<T> graph,  int vertex){ //Dado un vértice informar si es aislado
        return graph.getListAdy(vertex).size() == 0;
    }
    
    public int e(Graph<T> graph){ //Calcular cuantos vértices son aislados.
        int qty = 0;
        for (int i = 0; i < graph.orden(); i++) {
            if(d(graph, i))
                qty ++;
        }
        return qty;
    }

    public ArrayList<T> f(Graph<T> graph){ //Retornar todos los vértices aislados
        ArrayList<T> a = new ArrayList<>();
        for (int i = 0; i < graph.orden(); i++) {
            if(d(graph, i))
                a.add(graph.getVertice(i));
        }
        return a;
    }

    public Graph<T> g_ady(Graph<T> graph){ //Dado un grafo debe retornar otro grafo sin lazos y sin vértices aislados
        Graph<T> newGraph = getCopyAdy(graph);
        for (int i = 0; i < newGraph.orden(); i++) {
            if(d(newGraph, i)){
                newGraph.addEdge(0, i);
            }
            if(newGraph.existsEdge(i, i))
                newGraph.deleteEdge(i, i);
        }
        return newGraph;
    }

    private Graph<T> getCopyAdy(Graph<T> graph){ //Retorna copia del grafo
        Graph<T> newGraph = new GraphAdyMatrix<>();
        for (int i = 0; i < graph.orden(); i++) {
            newGraph.addVertex(graph.getVertice(i));
            for (int j = 0; j < graph.getListAdy(i).size(); j++) {
                newGraph.addEdge(i, graph.getListAdy(i).get(j));
            }
        }

        return newGraph;
    }

    public void h(Graph<T> graph){ //Calcular y mostrar la matriz de adyacencia.
        boolean[][] matrix = new boolean[graph.orden()][graph.orden()];
        for (int i = 0; i < graph.orden(); i++) {
            ArrayList<Integer> ady = graph.getListAdy(i);
            for (int j = 0; j < ady.size(); j++) {
                matrix[i][ady.get(j)] = true;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.print("\n");
        }
        
    }

    
}
