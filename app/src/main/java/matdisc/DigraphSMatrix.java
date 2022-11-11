package matdisc;

import java.util.ArrayList;
import java.util.List;

public class DigraphSMatrix<T> implements Digraph<T> {

    private List<T> vertexes;

    private boolean[][] matrix;

    private int size;

    private int capacity;

    public DigraphSMatrix(int capacity){
        this.vertexes = new ArrayList<>();
        this.matrix = new boolean[capacity][capacity];
        this.size = 0;
    }

    @Override
    public void addVertex(T element) {
        vertexes.add(element);
        if(size == capacity)
            grow();
        size++;
    }

    @Override
    public void addEdge(int v, int w){
        matrix[v][w] = true;
    }

    @Override
    public void deleteEdge(int v, int w) {
        matrix[v][w] = false;
    }

    @Override
    public void deleteVertex(int v) {
        vertexes.set(v,null);
        for (int i = 0; i < size; i++) {
            matrix[i][v] = false;
            matrix[v][i] = false;
        }
        size--;
    }

    @Override
    public boolean existsEdge(int v, int w) {
        return matrix[v][w];
    }

    @Override
    public int order() {
        return size;
    }

    @Override
    public int edgeQuantity() {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j]) count++;
            }
        }
        return count;
    }

    @Override
    public T getVertex(int v) {
        return vertexes.get(v);
    }

    @Override
    public int getVertex(T v) {
        return vertexes.indexOf(v);
    }

    @Override
    public List<Integer> getListInheritors(int v) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[v][i]) l.add(i);
        }
        return l;
    }
    
    @Override
    public List<Integer> getListPredecessor(int v){
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][v]) l.add(i);
        }
        return l;
    }

    public int getCapacity(){
        return capacity;
    }

    private void grow(){
        capacity += 10;
        boolean[][] newMatrix = new boolean[capacity][capacity];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        this.matrix = newMatrix;
    }
}
