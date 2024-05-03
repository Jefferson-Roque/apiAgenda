package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Categoria;
import entities.Fornecedor;
import entities.Produto;
import repositories.ProdutoRepositoryTxt;
import repositories.ProdutoRepositoryXml;

public class ProdutoController {

	public void cadastrarProduto() {

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("\nCADASTRO DE PRODUTOS:\n");

			Produto produto = new Produto();
			produto.setId(UUID.randomUUID());

			System.out.println("NOME DO PRODUTO.........:");
			produto.setNome(scanner.nextLine());

			System.out.println("PRECO DO PRODUTO.........:");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));

			System.out.println("QUANTIDADE DO PRODUTO.........:");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

			System.out.println("DESEJA INCLUIR FORNECEDOR ?  (S,N)...:");
			String opcaoFornecedor = scanner.nextLine();

			if (opcaoFornecedor.equalsIgnoreCase("S")) {

				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(UUID.randomUUID());

				System.out.println("NOME DO FORNECEDOR..........:");
				fornecedor.setNome(scanner.nextLine());

				System.out.println("CNPJ DO FORNECEDOR..........:");
				fornecedor.setCnpj(scanner.nextLine());

				produto.setFornecedor(fornecedor);

			}

			System.out.println("INFORME A QUANTIDADE DE CATEGORIAS...:");
			Integer numCATEGORIAS = Integer.parseInt(scanner.nextLine());
			if (numCATEGORIAS > 0) {

				Categoria[] categorias = new Categoria[numCATEGORIAS];

				for (int i = 0; i < numCATEGORIAS; i++) {

					Categoria categoria = new Categoria();
					categoria.setId(UUID.randomUUID());

					System.out.print("INFORME A DESCRIÇÃO DA CATEGORIA....: ");
					categoria.setDescricao(scanner.nextLine());

					categorias[i] = categoria;
				}

				produto.setCategorias(categorias);
			}

			ProdutoRepositoryTxt produtoRepositoryTxt = new ProdutoRepositoryTxt();
			produtoRepositoryTxt.exportar(produto);

			System.out.println("\nDADOS GRAVADOS EM TXT COM SUCESSO!");

			ProdutoRepositoryXml produtoRepositoryXml = new ProdutoRepositoryXml();
			produtoRepositoryXml.exportar(produto);

			System.out.println("\nDADOS GRAVADOS EM XML COM SUCESSO!");

		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR O PRODUTO!");
			System.out.println(e.getMessage());
		}

		scanner.close();
	}
}
