import com.exemplo.strategy.Compra;
import com.exemplo.strategy.Fatura;
import org.junit.Test;
import static org.junit.Assert.*;

public class Faturatest {
    private  Compra c1 = new Compra("Aroz", 2);
    private Compra c2 = new Compra("Feijao", 2);
    private Fatura f = new Fatura();


    @Test
    public  void testGetFatura(){
            System.out.println("Entrei");
            this.f.addCompra(this.c1);
            this.f.addCompra(this.c2);
            assertEquals(4, this.f.getTotal(), 0.1);
    }


}
