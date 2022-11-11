package matdisc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DigraphSMatrix<T> implements Digraph<T>{

    private T[] vertexes;

    private boolean[][] matrix;

    private int size;

    private int capacity;

    @SuppressWarnings
    public DigraphSMatrix(int capacity){
        this.capacity = capacity;
        this.vertexes = (T[]) new Object[capacity];
        this.matrix = new boolean[capacity][];
        this.size = 0;
    }

    @Override
    public void addVertex(T element) {
        vertexes.add(element);
    }

    @Override
    public void addEdge(int v, int w) {
        matrix[v][w] = true;
        
    }

    @Override
    public void deleteEdge(int v, int w) {
        matrix[v][w] = false;
        
    }

    @Override
    public void deleteVertex(int v) {
        
        
    }

    @Override
    public boolean existsEdge(int v, int w) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int order() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int edgeQuantity() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public T getVertex(int v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Set<Integer>> getListInheritors(int v) {
        // TODO Auto-generated method stub
        return null;
    }
    

}
