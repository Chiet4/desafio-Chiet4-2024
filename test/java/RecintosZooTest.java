import com.anchietaalbano.RecintosZoo;
import com.anchietaalbano.ResultadoAnalise;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RecintosZooTest {

    @Test
    public void deveRejeitarAnimalInvalido() {
        RecintosZoo zoo = new RecintosZoo();
        ResultadoAnalise resultado = zoo.analisaRecintos("UNICORNIO", 1);

        assertEquals("Animal inválido", resultado.getErro());
        assertNull(resultado.getRecintosViaveis());
    }

    @Test
    public void deveRejeitarQuantidadeInvalida() {
        RecintosZoo zoo = new RecintosZoo();
        ResultadoAnalise resultado = zoo.analisaRecintos("MACACO", 0);

        assertEquals("Quantidade inválida", resultado.getErro());
        assertNull(resultado.getRecintosViaveis());
    }

    @Test
    public void naoDeveEncontrarRecintosPara10Macacos() {
        RecintosZoo zoo = new RecintosZoo();
        ResultadoAnalise resultado = zoo.analisaRecintos("MACACO", 10);

        assertEquals("Não há recinto viável", resultado.getErro());
        assertNull(resultado.getRecintosViaveis());
    }

    @Test
    public void deveEncontrarRecintoPara1Crocodilo() {
        RecintosZoo zoo = new RecintosZoo();
        ResultadoAnalise resultado = zoo.analisaRecintos("CROCODILO", 1);

        assertNull(resultado.getErro());
        List<String> recintosViaveis = resultado.getRecintosViaveis();
        assertNotNull(recintosViaveis);
        assertEquals(1, recintosViaveis.size());  // Apenas 1 recinto é esperado
        assertEquals("Recinto 4 (bioma: rio, espaço livre: 5, total: 8)", recintosViaveis.get(0));  // Recinto correto esperado
    }


    @Test
    public void deveEncontrarRecintosPara2Macacos() {
        RecintosZoo zoo = new RecintosZoo();
        ResultadoAnalise resultado = zoo.analisaRecintos("MACACO", 2);

        assertNull(resultado.getErro());
        List<String> recintosViaveis = resultado.getRecintosViaveis();
        assertNotNull(recintosViaveis);
        assertEquals(3, recintosViaveis.size());  // Três recintos são esperados
        assertEquals("Recinto 1 (bioma: savana, espaço livre: 5, total: 10)", recintosViaveis.get(0));  // Ordem por espaço livre
        assertEquals("Recinto 2 (bioma: floresta, espaço livre: 3, total: 5)", recintosViaveis.get(1));
        assertEquals("Recinto 3 (bioma: savana, espaço livre: 2, total: 7)", recintosViaveis.get(2));
    }
}
