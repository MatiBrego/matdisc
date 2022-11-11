package matdisc;

import java.util.List;

/*
 * Interface for a directed graph.
 */
public interface Digraph<T>{


    /**
     * Adds a vertex with the provided element to the digraph.
     * 
     * @param element the element contained in the new vertex.
     */
    public void addVertex(T element);

    
    /**
     * Adds a directed edge between the vertex in the position v and the vertex in the position w. 
     * The edge goes from v to w.
     * 
     * @param v position of the out vertex.
     * @param w position of the in vertex.
     */
    public void addEdge(int v, int w);

    /**
     * Deletes edge in from vertex v to vertex w. 
     * 
     * @param v position of the out vertex.
     * @param w position of the in vertex.
     */
    public void deleteEdge(int v, int w);

    /**
     * Deletes vertex in position v.
     * 
     * @param v position of the vertex.
     */
    public void deleteVertex(int v);

    /**
     * Returns whether an edge from v to w exists or not.
     * 
     * @param v
     * @param w
     * @return true if an edge from v to w exists, false otherwise.
     */
    public boolean existsEdge(int v, int w);

    /**
     * Returns the quantity of vertexes in the graph
     * 
     * @return an integer representing the quantity of vertexes
     */
    public int order();

    /**
     * Returns the quantity of edges in the graph
     * 
     * @return returns an int representing the edge quantity
     */
    public int edgeQuantity();

    /**
     * Gets the element contained in the vertex v
     * 
     * @param v the position of the vertex to be returned
     * @return the element in the vertex
     */
    public T getVertex(int v);


    /**
     * A list containing the inheritors of the vertex v
     * 
     * @param v the position of the vertex
     * @return A list of integers, containing the inheritor's position.
     */
    public List<Integer> getListInheritors(int v);

    /**
     * A list containing the predecessors of the vertex v
     * 
     * @param v the position of the vertex
     * @return A list of integers, containing the predecessor's position.
     */
    public List<Integer> getListPredecessor(int v);
}
