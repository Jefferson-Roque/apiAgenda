package principal;

import controllers.ProdutoController;

public class Main {

	public static void main(String[] args) {

		ProdutoController produtoController = new ProdutoController();
		
		produtoController.cadastrarProduto();
	}

}
