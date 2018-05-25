package com.marini.gabriel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marini.gabriel.domain.Categoria;
import com.marini.gabriel.repositories.CategoriaRepository;
import com.marini.gabriel.services.exceptions.CreateObjectException;
import com.marini.gabriel.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServices{
	
	@Autowired
	CategoriaRepository repo;
	
	public Categoria listaPorId(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria "+ id +" não encontada"));
	}
	
	public Categoria postSave(Categoria cat) {
		return repo.save(cat);
	}
	
	public List<Categoria> getAll(){
		return repo.findAll();
	}
}
