package matdisc;

import java.util.TreeSet;

public class TransportApi {

    Digraph<Integer> Warshall_digraph;


    public TransportApi(int[][] connections){
        Digraph<Integer> digraph=new DigraphSMatrix<Integer>(10);
        TreeSet<Integer> vertexes = new TreeSet<Integer>();
        for (int i = 0; i < connections.length; i++) {
            vertexes.add(connections[i][0]);
            vertexes.add(connections[i][1]);
        }

        DigraphApi<Integer> digraphApi = new DigraphApi<>();
        Integer[] vertex_array = new Integer[vertexes.size()];
        vertexes.toArray(vertex_array);
        digraphApi.putDataInGraph(vertex_array,connections,digraph);
        Warshall_digraph = digraphApi.Warshall(digraph);
    }

    public boolean isProvider(int v, int w){
        //0 represents vertex 1 (0 based-index)
        return Warshall_digraph.existsEdge(v,w);
    }
}
