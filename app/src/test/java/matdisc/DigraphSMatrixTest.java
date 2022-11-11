package matdisc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DigraphSMatrixTest {
    
    @Test
    public void testAddRemoveVertex(){
        Digraph<Character> d = new DigraphSMatrix<>(10);
        d.addVertex('a');
        d.addVertex('b');

        d.addVertex('c');
        d.deleteVertex(1);

        assertEquals(2, d.order());
        assertEquals('a', d.getVertex(0));
        assertEquals('c', d.getVertex(1));
    }

    @Test
    public void testAddRemoveEdge(){
        Digraph<Character> d = new DigraphSMatrix<>(10);
        d.addVertex('a');
        d.addVertex('b');
        d.addVertex('c');
        
        d.addEdge(0, 1);

        assertTrue(d.existsEdge(0, 1));
        assertFalse(d.existsEdge(0, 2));
        assertFalse(d.existsEdge(1, 0));

        assertEquals(1, d.getListInheritors(0).size());
        assertEquals(1, d.getListPredecessor(1).size());
        assertEquals(0, d.getListInheritors(2).size());
    }
}
