import com.exemplo.strategy.Compra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompraTest {

    private Compra compra= new Compra("Feijao",12);


    @Test
    public void testSetQuantia(){
        this.compra.setQuantia(14);
        assertEquals(14, compra.getQuantia(), 0.1);

    }
}
