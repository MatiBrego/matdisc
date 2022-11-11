package matdisc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DigraphApiTest<T> {

    @Test
    public void TestAddDataToGraph(){
        DigraphApi apiTest = new DigraphApi();
        String[] vertex = {"a", "b", "c"};
        DigraphSMatrix<T> digraph = new DigraphSMatrix(vertex.length);
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
        DigraphApi apiTest = new DigraphApi();
        String[] vertex = {"a", "b", "c"};
        DigraphSMatrix<T> digraph = new DigraphSMatrix(vertex.length);
        int[][] edges = {{0,1}, {1,2}};


        apiTest.putDataInGraph(vertex,edges,digraph);
        apiTest.ShowGraph(digraph);
    }

    @Test
    public void TestFountainVertexes(){
        DigraphApi apiTest = new DigraphApi();
        String[] vertex = {"a", "b", "c"};
        DigraphSMatrix<T> digraph = new DigraphSMatrix(vertex.length);
        int[][] edges = {{0,2}, {1,2}};
        apiTest.putDataInGraph(vertex,edges,digraph);

        Assertions.assertEquals(apiTest.amtOfFountainVertex(digraph),2);
    }

    @Test
    public void TestSinkVertexes(){
        DigraphApi apiTest = new DigraphApi();
        String[] vertex = {"a", "b", "c"};
        DigraphSMatrix<T> digraph = new DigraphSMatrix(vertex.length);
        int[][] edges = {{0,2}, {1,2}};
        apiTest.putDataInGraph(vertex,edges,digraph);

        Assertions.assertEquals(apiTest.amtOfSinkVertex(digraph).size(),1);
    }



    @Test
    public void TestVertexes(){
        DigraphApi apiTest = new DigraphApi();
        String[] vertex = {"a", "b", "c"};
        DigraphSMatrix<T> digraph = new DigraphSMatrix(vertex.length);
        int[][] edges = {{0,2}, {1,2}, {2,1}};
        apiTest.putDataInGraph(vertex,edges,digraph);

        apiTest.vertexInDistanceLessThanTwo(digraph,"a").forEach(System.out::println);
    }


}
