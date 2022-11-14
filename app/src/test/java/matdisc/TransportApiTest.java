package matdisc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TransportApiTest {
    @Test
    public void testTransport(){
        //0 represents vertex 1 (0 based-index)
        int[][] connections = {{0,1},{0,2},{1,2},{1,4},{2,3},{2,4},{3,1},{3,4}};
        TransportApi transportApi = new TransportApi(connections);
        assertEquals(true, transportApi.isProvider(0,4));
        assertEquals(false, transportApi.isProvider(4,0));
        assertEquals(true, transportApi.isProvider(1,4));
        assertEquals(false, transportApi.isProvider(3,0));
    }
}
