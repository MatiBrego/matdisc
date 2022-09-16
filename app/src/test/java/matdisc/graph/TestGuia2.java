package matdisc.graph;

public class TestGuia2 {
    public static void main(String[] args) {
        Guia2<String> test = new Guia2<>();
        GraphListAdy<String> g1 = new GraphListAdy<>();
        GraphAdyMatrix<String> g2 = new GraphAdyMatrix<>();
        g1.addVertex("a");
        g1.addVertex("b");
        g1.addVertex("c");
        g1.addEdge(0, 0);
        g1.addEdge(0, 2);
        System.out.println(test.c(g1)); 

        System.out.println();

        g2.addVertex("a");
        g2.addVertex("b");
        g2.addVertex("c");
        g2.addEdge(0, 0);
        g2.addEdge(0, 2);
        System.out.println(test.c(g2));
        
    }
}
