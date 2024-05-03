package interfaces;

import entities.Produto;

public interface ProdutoRepository {
	void exportar(Produto produto) throws Exception;
}
