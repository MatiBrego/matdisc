package matdisc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DigraphApiTest {

    @Test
    public void TestAddDataToGraph(){
        DigraphApi<String> apiTest = new DigraphApi<>();
        String[] vertex = {"a", "b", "c"};
        DigraphSMatrix<String> digraph = new DigraphSMatrix<>(vertex.length);
        int[][] edges = {{0,1}, {1,2}};
        apiTest.putDataInGraph(vertex,edges,digraph);


        Assertions.assertEquals(digraph.getVertex(0), "a");
        Assertions.assertEquals(digraph.getVertex(1), "b");
        Assertions.assertEquals(digraph.getVertex(2), "c");

        Assertions.assertFalse(digraph.existsEdge(0,2));
        Assertions.assertTrue(digraph.existsEdge(1,2));
    }

    @Test
    public void TestShowGraph(){
        DigraphApi<String> apiTest = new DigraphApi<>();
        String[] vertex = {"a", "b", "c"};
        DigraphSMatrix<String> digraph = new DigraphSMatrix<>(vertex.length);
        int[][] edges = {{0,1}, {1,2}};


        apiTest.putDataInGraph(vertex,edges,digraph);
        apiTest.ShowGraph(digraph);
    }

    @Test
    public void TestFountainVertexes(){
        DigraphApi<String> apiTest = new DigraphApi<>();
        String[] vertex = {"a", "b", "c"};
        DigraphSMatrix<String> digraph = new DigraphSMatrix<>(vertex.length);
        int[][] edges = {{0,2}, {1,2}};
        apiTest.putDataInGraph(vertex,edges,digraph);



        Assertions.assertEquals(apiTest.amtOfFountainVertex(digraph),2);
    }

    @Test
    public void TestSinkVertexes(){
        DigraphApi<String> apiTest = new DigraphApi<>();
        String[] vertex = {"a", "b", "c"};
        DigraphSMatrix<String> digraph = new DigraphSMatrix<>(vertex.length);
        int[][] edges = {{0,2}, {1,2}};
        apiTest.putDataInGraph(vertex,edges,digraph);



        Assertions.assertEquals(apiTest.amtOfSinkVertex(digraph).size(),1);
    }



    @Test
    public void TestVertexesInDistanceLessThanTwo(){
        DigraphApi<String> apiTest = new DigraphApi<>();
        String[] vertex = {"a", "b", "c"};
        DigraphSMatrix<String> digraph = new DigraphSMatrix<>(vertex.length);
        int[][] edges = {{0,2}, {1,2}, {2,1}};
        apiTest.putDataInGraph(vertex,edges,digraph);

        apiTest.vertexInDistanceLessThanTwo(digraph,"a").forEach(System.out::println);
    }
    @Test
    public void TestIfStronglyConnected(){
        DigraphApi<String> apiTest = new DigraphApi<>();
        String[] vertex = {"a", "b", "c", "d"};
        DigraphSMatrix<String> digraph = new DigraphSMatrix<>(vertex.length);
        int[][] edges = {{0,1}, {1,2}, {2,3}, {3,0}};
        apiTest.putDataInGraph(vertex,edges,digraph);
        String[] vertex2 = {"e", "f", "g", "h"};
        DigraphSMatrix<String> digraph2 = new DigraphSMatrix<>(vertex.length);
        int[][] edges2 = {{0,1}, {1,2}, {2,3}};
        apiTest.putDataInGraph(vertex2,edges2,digraph2);
        assertTrue(apiTest.isStronglyConnected(digraph));
        assertFalse(apiTest.isStronglyConnected(digraph2));
    }
    @Test
    public void TestWarshall(){
        DigraphApi<String> apiTest = new DigraphApi<>();
        String[] vertex = {"a", "b", "c", "d"};
        DigraphSMatrix<String> digraph = new DigraphSMatrix<>(vertex.length);
        int[][] edges = {{0,1}, {1,2}, {2,3}, {3,0}};
        apiTest.putDataInGraph(vertex,edges,digraph);
        Digraph<String> digraph2 = apiTest.Warshall(digraph);
        assertEquals(16, digraph2.edgeQuantity());


    }



}
