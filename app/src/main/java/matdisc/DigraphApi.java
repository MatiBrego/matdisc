package matdisc;

import java.util.ArrayList;
import java.util.List;

public class DigraphApi<T> {

    public void putDataInGraph(T[] vertexes, int[][] edges, Digraph<T> digraph){
        for(T vertex : vertexes){
            digraph.addVertex(vertex);
        }
        for(int[] edge : edges){
            digraph.addEdge(edge[0], edge[1]);
        }
    }

    public void ShowGraph(){
        //después sigo con la implementación porque no tengo idea que hacer
    }


    public int amtOfFontVertex(Digraph<T> digraph){
        int amt_of_font_Vertex = 0;
        for(int i = 0; i<digraph.order(); i++){
            if(!digraph.getListInheritors(i).isEmpty() && digraph.getListPredecessor(i).isEmpty()){
                amt_of_font_Vertex++;
            }
        }
        return amt_of_font_Vertex;
    }

    public List<T> amtOfSinkVertex(Digraph<T> digraph){
        ArrayList<T> list_of_sink_Vertex = new ArrayList<>();
        for(int i=0; i<digraph.order(); i++){
            if (digraph.getListInheritors(i).isEmpty() && !digraph.getListPredecessor(i).isEmpty()) {
                list_of_sink_Vertex.add(digraph.getVertex(i));
            }
        }
        return list_of_sink_Vertex;
    }


}
