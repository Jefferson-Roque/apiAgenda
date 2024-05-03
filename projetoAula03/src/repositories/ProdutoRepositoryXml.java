package repositories;

import java.io.PrintWriter;

import entities.Categoria;
import entities.Produto;
import interfaces.ProdutoRepository;

public class ProdutoRepositoryXml implements ProdutoRepository {

	public void exportar(Produto produto) throws Exception {

		PrintWriter printWriter = new PrintWriter("c:\\temp\\produto_" + produto.getId() + ".xml");

		printWriter.write("<?xml version+'1.0 encoding+iso-8859-1'?>");
		printWriter.write("<produto>");
		printWriter.write("<id>" + produto.getId() + "</id>");
		printWriter.write("<nome>" + produto.getNome() + "</nome>");
		printWriter.write("<preco>" + produto.getPreco() + "</preco>");
		printWriter.write("<quantidade>" + produto.getQuantidade() + "</quantidade>");

		if (produto.getFornecedor() != null) {
			printWriter.write("<fornecedor>");
			printWriter.write("<id>" + produto.getFornecedor().getId() + "</id>");
			printWriter.write("<nome>" + produto.getFornecedor().getNome() + "</nome>");
			printWriter.write("<quantidade>" + produto.getFornecedor().getCnpj() + "</quantidade>");
			printWriter.write("</fornecedor>");
		}

		if (produto.getCategorias() != null) {
			printWriter.write("<categorias>");
			for (Categoria categoria : produto.getCategorias()) {
				printWriter.write("<categoria>");
				printWriter.write("<id>" + categoria.getId() + "</id>");
				printWriter.write("<descricao>" + categoria.getDescricao() + "</descricao>");
				printWriter.write("</categoria>");
			}
			printWriter.write("</categorias>");
		}

		printWriter.write("</produto>");
		printWriter.close();
	}

}
