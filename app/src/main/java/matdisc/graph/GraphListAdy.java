package matdisc.graph;
import java.util.ArrayList;

import matdisc.graph.util.Vertex;
 

public class GraphListAdy<T> implements Graph<T>{
    private Vertex<T> [] V;
    int n;
    int alfa;

    GraphListAdy(){
        V = new Vertex[10];
        n = 0;
        alfa = 0;
    }
    

    public void addVertex(T x){
        if (n == V.length)
            grow();
        V[n] = new Vertex<T>(x);
        n++;
    }

    private void grow(){
        Vertex<T> aux[] = (Vertex<T>[]) new Object[V.length*2];
        for (int i = 0; i < V.length; i++) {
            aux[i] = V[i];
        }
        V = aux;

    }

    public void addEdge(int v1, int v2){
        if(!V[v1].isAdy(v2))
            V[v1].addAdy(v2);
            V[v2].addAdy(v1);
            alfa++;
    }

    public void deleteEdge(int v1, int v2){
        if(!V[v1].isAdy(v2)){
            V[v1].getAdy().remove(v2);
            V[v2].getAdy().remove(v1);
        }
    }
    
    public void deleteVertex(int v){
        V[v] = null;
    }

    public boolean existsEdge(int v, int w){
        return V[v].isAdy(w);
    }

    public int orden(){
        return n;
    }

    public int quantityEdge(){
        return alfa;
    }

    public T getVertice(int v){
        return (T) V[v].getData();
    }

    public ArrayList<Integer> getListAdy(int v){
        return V[v].getAdy();
    }

}

