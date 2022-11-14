package matdisc;

import java.util.TreeSet;

public class TransportApi {
    Digraph Warshall_digraph;
    public TransportApi(int[][] connections){
        Digraph<Integer> digraph=new DigraphSMatrix<Integer>(10);
        TreeSet<Integer> vertexes = new TreeSet<>();
        for (int i = 0; i < connections.length; i++) {
            vertexes.add(connections[i][0]);
            vertexes.add(connections[i][1]);
        }
        DigraphApi digraphApi = new DigraphApi();
        Object[] vertex_array =  vertexes.toArray();
        digraphApi.putDataInGraph(vertex_array,connections,digraph);
        Warshall_digraph = digraphApi.Warshall(digraph);

    }
    public boolean isProvider(int v, int w){
        return Warshall_digraph.existsEdge(v,w);
    }
}
