package repositories;


import java.io.PrintWriter;


import entities.Categoria;
import entities.Produto;
import interfaces.ProdutoRepository;


public class ProdutoRepositoryTxt implements ProdutoRepository {


	@Override
	public void exportar(Produto produto) throws Exception {


		PrintWriter printWriter = new PrintWriter("c:\\temp\\produto_"+ produto.getId() +".txt");
		
		printWriter.write("\nID DO PRODUTO..........: " + produto.getId());
		printWriter.write("\nNOME...................: " + produto.getNome());
		printWriter.write("\nPREÇO..................: " + produto.getPreco());
		printWriter.write("\nQUANTIDADE.............: " + produto.getQuantidade());
		
		//verificando se o produto possui uma instancia de um fornecedor
		if(produto.getFornecedor() != null) {
			printWriter.write("\nID DO FORNECEDOR.......: " + produto.getFornecedor().getId());
			printWriter.write("\nNOME DO FORNECEDOR.....: " + produto.getFornecedor().getNome());
			printWriter.write("\nCNPJ...................: " + produto.getFornecedor().getCnpj());
		}
		
		//verificando se o produto possui categorias
		if(produto.getCategorias() != null) {
			for(Categoria categoria : produto.getCategorias()) { //foreach
				printWriter.write("\nID DA CATEGORIA........: " + categoria.getId());
				printWriter.write("\nDESCRIÇÃO DA CATEGORIA.: " + categoria.getDescricao());
			}
		}
		
		printWriter.close();
	}
}





