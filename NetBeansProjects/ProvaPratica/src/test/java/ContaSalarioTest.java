import com.mycompany.provapratica.ContaSalario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaSalarioTest {

    @Test
    public void testDeposito() {
        ContaSalario conta = new ContaSalario("123");
        conta.depositar(100.0);
        assertEquals(100.0, conta.getSaldo());
    }

    @Test
    public void testPagamentoComSaldoSuficiente() {
        ContaSalario conta = new ContaSalario("123");
        conta.depositar(100.0);
        conta.pagar(50.0);
        assertEquals(50.0, conta.getSaldo());
    }

    @Test
    public void testPagamentoComSaldoInsuficiente() {
        ContaSalario conta = new ContaSalario("123");
        assertThrows(IllegalArgumentException.class, () -> conta.pagar(50.0));
    }
}
