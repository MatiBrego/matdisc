package matdisc.graph;
import java.util.ArrayList;
import java.util.LinkedList;

public class GraphListEdges<T> implements Graph<T>{

    T V[];
    int n;
    int alfa;
    LinkedList<Integer[]> edges;

    GraphListEdges(){
        V = (T[]) new Object[10];
        n = 0;
        alfa = 0;
        edges = new LinkedList<>();
    }

    @Override
    public void addVertex(T x) {
        if (n == V.length)
            grow();
        V[n] = x;
        n++;
    }

    private void grow(){
        T aux[] = (T[]) new Object[V.length*2];
        for (int i = 0; i < V.length; i++) {
            aux[i] = V[i];
        }
        V = aux;
    }

    @Override
    public void addEdge(int v, int w) {
        if(!existsEdge(v, w)){
            edges.add(new Integer[]{v, w});
            alfa++;
        }
    }

    @Override
    public void deleteEdge(int v, int w) {
        int index = 0;
        for (Integer[] edge : edges) {
            if((edge[0] == v && edge[1] == w) || ((edge[0] == w && edge[1] == 1))){
                edges.remove(index);
                break;
            }
            index++;
        }
        
        
    }

    @Override
    public void deleteVertex(int v) {
        V[v] = null;
    }

    @Override
    public boolean existsEdge(int v, int w) {
        for (Integer[] edge : edges) {
            if((edge[0] == v && edge[1] == w) || ((edge[0] == w && edge[1] == 1)))
            return true;
        }
        return false;
    }

    @Override
    public int orden() {
        return n;
    }

    @Override
    public int quantityEdge() {
        return alfa;
    }

    @Override
    public T getVertice(int v) {
        return V[v];
    }

    @Override
    public ArrayList<Integer> getListAdy(int v) {
        ArrayList<Integer> aux = new ArrayList<>();
        for (Integer[] edge : edges) {
            if(edge[0] == v)
                aux.add(edge[1]);
            else if (edge[1] == v)
                aux.add(edge[0]);
        }
        return aux;
    }

}