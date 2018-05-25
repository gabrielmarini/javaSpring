package com.marini.gabriel;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marini.gabriel.domain.Categoria;
import com.marini.gabriel.domain.Cidade;
import com.marini.gabriel.domain.Estado;
import com.marini.gabriel.domain.Produto;
import com.marini.gabriel.repositories.CategoriaRepository;
import com.marini.gabriel.repositories.CidadeRepository;
import com.marini.gabriel.repositories.EstadoRepository;
import com.marini.gabriel.repositories.ProdutoRepository;

@SpringBootApplication
public class MyApiSpringApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository catRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	@Autowired
	private CidadeRepository cidRepo;
	@Autowired
	private EstadoRepository estRepo;

	public static void main(String[] args) {
		SpringApplication.run(MyApiSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		List<Categoria> list1 = new ArrayList<>();
		list1.add(cat1);
		list1.add(cat2);
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 70.00);
		
		List<Produto> list2 = new ArrayList<>();
		list2.add(p1);
		list2.add(p2);
		list2.add(p3);
		
		List<Produto> cat1List = new ArrayList<>();
		cat1List.add(p1);
		cat1List.add(p2);
		cat1List.add(p3);
		cat1.getProdutos().addAll(cat1List);
		
		List<Produto> cat2List = new ArrayList<>();
		cat2List.add(p2);
		cat1.getProdutos().addAll(cat2List);
		
		List<Categoria> prod1Cat = new ArrayList<>();
		prod1Cat.add(cat1);
		p1.getCategorias().addAll(prod1Cat);
		
		List<Categoria> prod2Cat = new ArrayList<>();
		prod2Cat.add(cat1);
		prod2Cat.add(cat2);
		p2.getCategorias().addAll(prod2Cat);
		
		List<Categoria> prod3Cat = new ArrayList<>();
		prod3Cat.add(cat1);
		p2.getCategorias().addAll(prod3Cat);
		
		
		catRepo.saveAll(list1);
		prodRepo.saveAll(list2);
		
		Cidade cid1 = new Cidade(null, "São Paulo");
		Cidade cid2 = new Cidade(null, "Uberlândia");
		Cidade cid3 = new Cidade(null, "Campinas");
		
		List<Cidade> listCid = new ArrayList<>();
		listCid.add(cid1);
		listCid.add(cid2);
		listCid.add(cid3);
		
		Estado est1 = new Estado(null,"São Paulo");
		Estado est2 = new Estado(null,"Minas Gerais");
		
		List<Estado> estList = new ArrayList<>();
		estList.add(est1);
		estList.add(est2);
		
		List<Cidade> listCidEst = new ArrayList<>();
		listCidEst.add(cid1);
		listCidEst.add(cid3);
		est1.getCidades().addAll(listCidEst);
		
		List<Cidade> listCidEst2 = new ArrayList<>();
		listCidEst2.add(cid2);
		est2.getCidades().addAll(listCidEst2);
		
		cid1.setEstado(est1);
		cid2.setEstado(est2);
		cid3.setEstado(est1);
		
		estRepo.saveAll(estList);
		cidRepo.saveAll(listCid);
		
	}

}
