package matdisc.graph;
import java.util.ArrayList;

public class GraphAdyMatrix<T> implements Graph<T>{
    private T V[];
    private boolean[][] A;
    private int n;
    private int alfa;
    
    GraphAdyMatrix (){
        V = (T[]) new Object[10];
        A = new boolean[10][10];
        n = 0;
        alfa = 0;
    }
    GraphAdyMatrix(int capacidad) {
        V = (T[]) new Object[capacidad];
        A = new boolean[capacidad][capacidad];
        n = 0;
        alfa = 0;
    }
    public void addVertex(T x){
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

    public void addEdge(int v, int w){
        if (!A[v][w]){
         A[v][w]=A[w][v] = true;
         alfa++;
        }
    }

    public void deleteEdge(int v, int w){
        if (A[v][w]){
        A[v][w]=A[w][v] = false;
        alfa--;
        }
    }  

    public void deleteVertex(int v){
        A[v] = null;
    }

    public boolean existsEdge(int v, int w){
        return A[v][w];
    }

    public int orden(){
       return n;
    }
    public int quantityEdge(){
        return alfa;
    }
    public T getVertice(int v){
        return V[v];
    }
    public ArrayList<Integer> getListAdy(int v){
        ArrayList<Integer> lst = new ArrayList<>();
        for (int w = 0; w < n ; w++)
        if (A[v][w])
        lst.add(w);
        return lst;
    }
    
}