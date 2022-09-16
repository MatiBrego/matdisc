package matdisc.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestGuia3 {
    Guia3 api = new Guia3();
    Graph<String> g = new GraphAdyMatrix<>();

    public void reset(){
        g = new GraphAdyMatrix<>();
    }

    @Test
    public void testExistsPath(){
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");
        g.addVertex("e");

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        assertTrue(api.existsPath(g, 0, 3));
        assertTrue(api.existsPath(g, 1, 3));
        assertFalse(api.existsPath(g, 0, 4));

        reset();
    }

    @Test
    public void testExistsCycle(){
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        assertTrue(api.existsCycle(g, 0));
        reset();

        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        assertFalse(api.existsCycle(g, 0));
    }    

    @Test
    public void testIsConnected(){
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        assertTrue(api.isConnected(g));

        reset();

        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");
        g.addVertex("e");

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        assertFalse(api.isConnected(g));

        reset();
    }    

    @Test
    public void testHasCycle(){
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");
        g.addVertex("e");

        g.addEdge(0, 1);
        
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 2);

        assertTrue(api.hasCycle(g));
        reset();

    }   

    @Test
    public void testPathLength(){
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        assertEquals(3, api.pathLenght(g, 0, 3));
    }
}
