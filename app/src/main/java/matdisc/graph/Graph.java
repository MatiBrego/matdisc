package matdisc.graph;

import java.util.ArrayList;

public interface Graph<T> {
        public void addVertex(T x);
        public void addEdge(int v, int w);
        public void deleteEdge(int v, int w);
        public void deleteVertex(int v);
        public boolean existsEdge(int v, int w);
        public int orden();
        public int quantityEdge();
        public T getVertice(int v);
        public ArrayList<Integer> getListAdy(int v);
}
