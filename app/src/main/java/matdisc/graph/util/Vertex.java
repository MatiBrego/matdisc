package matdisc.graph.util;
import java.util.ArrayList;

public class Vertex<J>{
    private J data;
    private ArrayList<Integer> ady;

    public Vertex(J data) {
        ady = new ArrayList<>();
        this.data = data;
    }

    public J getData() {
        return data;
    }

    public ArrayList<Integer> getAdy() {
        return ady;
    }

    public void addAdy(int x){
        ady.add(x);
    }

    public boolean isAdy(int v){
        for (int i = 0; i < ady.size(); i++) {
            if(ady.get(i) == v)
                return true;
        } 
        return false;
    }
}
