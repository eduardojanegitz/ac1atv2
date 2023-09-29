package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;
import com.example.ac1.repository.CategoriaRepository;
import com.example.ac1.repository.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(
			@Autowired ProdutoRepository produtoRepository,
			@Autowired CategoriaRepository categoriaRepository) {
		return args -> {
			Categoria categoriaTI = new Categoria((long) 1, "TI");
			categoriaRepository.save(categoriaTI);

			Categoria categoriaAcessorios = new Categoria((long) 2, "Acessórios");
			categoriaRepository.save(categoriaAcessorios);

			Produto novoProduto = new Produto();
			novoProduto.setNome("Notebook");
			novoProduto.setPreco(2000.0);
			novoProduto.setCategoria(categoriaTI);

			Produto novoProduto2 = new Produto();
			novoProduto2.setNome("Teclado");
			novoProduto2.setPreco(100.0);
			novoProduto2.setCategoria(categoriaTI);

			Produto novoProduto3 = new Produto();
			novoProduto3.setNome("Fone");
			novoProduto3.setPreco(70.0);
			novoProduto3.setCategoria(categoriaAcessorios);

			produtoRepository.save(novoProduto);
			produtoRepository.save(novoProduto2);
			produtoRepository.save(novoProduto3);

			System.out.println("** OBTER TODOS **");
			List<Produto> listaProdutos = produtoRepository.findAll();
			listaProdutos.forEach(System.out::println);
		
			System.out.println("** OBTER POR NOME **");
			listaProdutos = produtoRepository.findByNomeLike("%Notebook");
			listaProdutos.forEach(System.out::println);

			System.out.println("** OBTER POR PREÇO MAIOR QUE: 80**");
			listaProdutos = produtoRepository.findByPrecoGreaterThan(80.0);
			listaProdutos.forEach(System.out::println);

			System.out.println("** OBTER CATEGORIA POR NOME **");
			List<Categoria> listaCategoria = categoriaRepository.findAll();
			listaCategoria = categoriaRepository.findByNomeLike("%TI%");
			listaCategoria.forEach(System.out::println);
			
			// System.out.println("** OBTER CATEGORIA E PRODUTOS POR ID **");
			// listaCategoria = categoriaRepository.findWithProdutosById((long) 1);
			// listaCategoria.forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);

	}

}
