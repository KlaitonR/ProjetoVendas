import br.com.kr.vendas.anotation.Transactional;
import br.com.kr.vendas.model.Produto;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    @Transactional
    public void salvarProduto(){
        Produto produto = new Produto();
        produto.setNome("TESTE");
        produto.setValor(10.0);
        produto.setEstoque(10);



    }

}
