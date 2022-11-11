package matdisc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class DigraphApi<T> {

    public void putDataInGraph(T[] vertexes, int[][] edges, Digraph<T> digraph) {
        for (T vertex : vertexes) {
            digraph.addVertex(vertex);
        }
        for (int[] edge : edges) {
            digraph.addEdge(edge[0], edge[1]);
        }
    }

    public void ShowGraph(Digraph<T> digraph) {
        ArrayList<T> list_of_Vertex = new ArrayList<>();
        ArrayList<Object[]> list_of_Edges = new ArrayList<>();
        for (int i = 0; i < digraph.order(); i++) {
            list_of_Vertex.add(digraph.getVertex(i));
            for (int vertexes : digraph.getListInheritors(i)) {
                Object[] edge = {digraph.getVertex(i), digraph.getVertex(vertexes)};
                list_of_Edges.add(edge);
            }

        }
        System.out.println(list_of_Vertex);
        for (Object[] edges : list_of_Edges) {
            System.out.println("(" + edges[0] + " -> " + edges[1] + ")");
        }
    }


    public int amtOfFountainVertex(Digraph<T> digraph) {
        int amt_of_font_Vertex = 0;
        for (int i = 0; i < digraph.order(); i++) {
            if (!digraph.getListInheritors(i).isEmpty() && digraph.getListPredecessor(i).isEmpty()) {
                amt_of_font_Vertex++;
            }
        }
        return amt_of_font_Vertex;
    }

    public List<T> amtOfSinkVertex(Digraph<T> digraph) {
        ArrayList<T> list_of_sink_Vertex = new ArrayList<>();
        for (int i = 0; i < digraph.order(); i++) {
            if (digraph.getListInheritors(i).isEmpty() && !digraph.getListPredecessor(i).isEmpty()) {
                list_of_sink_Vertex.add(digraph.getVertex(i));
            }
        }
        return list_of_sink_Vertex;
    }

    public TreeSet<T> vertexInDistanceLessThanTwo(Digraph<T> digraph, T vertex) {
        TreeSet<T> vertexes = new TreeSet<>();
        int vertex_pos = digraph.getVertex(vertex);
        for (int i = 0; i < digraph.getListInheritors(vertex_pos).size(); i++) {
            List<Integer> vertex_inheritors = digraph.getListInheritors(vertex_pos);
            vertexes.add(digraph.getVertex(vertex_inheritors.get(i)));
            for (int j = 0; j < digraph.getListInheritors(vertex_inheritors.get(i)).size(); j++) {
                int auxVertex = digraph.getListInheritors(vertex_inheritors.get(i)).get(j);
                if (auxVertex != vertex_pos) {
                    vertexes.add(digraph.getVertex(auxVertex));
                }
            }

        }

        return vertexes;
    }

    public boolean isStronglyConnected(Digraph<T> digraph) {
        for (int i = 0; i < digraph.order(); i++) {
            if (!StronglyConnectedDFS(digraph, i)) {
                return false;
            }
        }
        return true;

    }

    private boolean StronglyConnectedDFS(Digraph<T> digraph, int vertex) {
        boolean[] visited = new boolean[digraph.order()];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> dfs_stack = new Stack<>();
        dfs_stack.add(vertex);
        while (!dfs_stack.isEmpty()) {
            Integer v = dfs_stack.pop();
            if (!visited[v]) {
                result.add(v);
                visited[v] = true;
            }
            for (int inheritor : digraph.getListInheritors(v)) {
                if (!visited[inheritor]) {
                    dfs_stack.add(inheritor);
                }

            }

        }
        return (result.size() == digraph.order());
    }
    public Digraph<T> Warshall(Digraph<T> digraph){
        boolean[][] matrix = new boolean[digraph.order()][digraph.order()];
        for (int i = 0; i < digraph.order();i++){
            for (int inheritor : digraph.getListInheritors(i)){
                matrix[i][inheritor] = true;
            }
        }
        for (int k = 0; k < digraph.order(); k++) {
            for (int i = 0; i < digraph.order(); i++) {
                for (int j = 0; j < digraph.order(); j++) {
                    if (matrix[i][k]==true && matrix[k][j]==true){
                        matrix[i][j] = true;
                    }
                }
            }
        }
        Digraph<T> digraph2 = new DigraphSMatrix<>(10);
        for (int i = 0; i < digraph.order(); i++) {
            digraph2.addVertex(digraph.getVertex(i));
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j]){
                    digraph2.addEdge(i,j);
                }
            }
        }
        return digraph2;


    }

}
