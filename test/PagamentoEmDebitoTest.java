import com.exemplo.exception.SaldoInsuficienteException;
import com.exemplo.strategy.Cliente;
import com.exemplo.strategy.ContaCorrente;
import com.exemplo.strategy.PagamentoEmDebito;
import com.exemplo.strategy.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PagamentoEmDebitoTest {


    private PagamentoEmDebito pagamento= new PagamentoEmDebito();
    private  Cliente cliente= new Cliente("gileno","000.0.0.00");
    private ContaCorrente contaCorrente= new ContaCorrente("2");
    private Pedido pedido= new Pedido(cliente, "pagamento em debito");
    @Before
    public  void setUp(){
        this.cliente.setContaCorrente(contaCorrente);
        this.contaCorrente.setSaldo(50);
        this.pedido.setPrecoTotal(20);
    }

    @Test
    public  void testRealizarPagamentoComSucesso(){
        try {
            this.contaCorrente.debitar(this.pedido.getPrecoTotal());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo Insuficiente");
        }
        assertEquals(30, this.contaCorrente.getSaldo(), 0.1);
    }

    @Test
    public void testRealizarPagamentoDebitoComFalha(){
        try {
            this.contaCorrente.debitar(60);
            fail("Teste não falhou!");
        }catch (SaldoInsuficienteException ex){
            assertThat(ex.getMessage(), is("Saldo insuficiente!"));
        }
    }
}
