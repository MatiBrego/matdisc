package matdisc.graph;


import java.util.List;



public class Guia3 {
    public <T> boolean existsPath(Graph<T> g, int v, int w){ //Exercise 1
        return existsPath(g, v, w, new boolean[g.orden()]);
    }

    private <T> boolean existsPath(Graph<T> g, int v, int w, boolean[] visited){
        if (v == w) //Vertices son iguales
            return true;
        else if(g.existsEdge(v, w))//Si existe vertice entre v y w
            return true;
        else if(g.getListAdy(v).size() == 0)//Si v no tiene adyacentes
            return false;
        else {
            List<Integer> ady = g.getListAdy(v);
            visited[v] = true;
            for (int i = 0; i < ady.size(); i++) {
                int current = ady.get(i);
                if(!visited[current] && existsPath(g, current, w, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public <T> boolean existsCycle(Graph<T> g, int v){        
        return existsCycle(g, v, new boolean[g.orden()], -1, v);
    }

    private <T> boolean existsCycle(Graph<T> g, int v, boolean[] visitState, int parent, int original){
        visitState[v] = true;
        List<Integer> ady = g.getListAdy(v);
        for (int i = 0; i < ady.size(); i++) {
            int w = ady.get(i);
            if(visitState[w] && w != parent && w == original)
            return true;
            else if(!visitState[w] && existsCycle(g, w, visitState, v, original))
            return true;
        } 

        return false;
    }

    public <T> boolean hasCycle(Graph<T> g){
        for (int i = 0; i < g.orden(); i++) {
            if(existsCycle(g, i)) return true;
        }

        return false;
    }


    public <T> boolean isConnected(Graph<T> g){
        boolean connected = true;
        for (int i = 0; i < g.orden(); i++) {
            for (int j = i + 1; j < g.orden(); j++) {
                connected = existsPath(g, i, j);
                if(!connected) return false;
            }
        }
        return true;
    }

    public <T> int pathLenght(Graph<T> g, int v, int w){
        return pathLenght(g, v, w, new boolean[g.orden()]);
    }

    private <T> int pathLenght(Graph<T> g, int v, int w, boolean[] visited){
        if (v == w) //Vertices son iguales
            return 0;
        else if(g.existsEdge(v, w))//Si existe vertice entre v y w
            return 1;
        else if(g.getListAdy(v).size() == 0)//Si v no tiene adyacentes
            return -1;
        else {
            List<Integer> ady = g.getListAdy(v);
            visited[v] = true;
            for (int i = 0; i < ady.size(); i++) {
                int current = ady.get(i);
                if(!visited[current]){
                    int len = pathLenght(g, current, w, visited);
                    if(len != -1)
                        return len + 1;
                    
                
                }
            }
        }
        return -1;
    }
}
