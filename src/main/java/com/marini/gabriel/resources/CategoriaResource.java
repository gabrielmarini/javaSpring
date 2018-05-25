package com.marini.gabriel.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marini.gabriel.domain.Categoria;
import com.marini.gabriel.services.CategoriaServices;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaServices catService;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<?> listaCat(@PathVariable Integer id) {
		Categoria obj = catService.listaPorId(id);
		return ResponseEntity.ok(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> listaCat() {
		List<Categoria> obj = catService.getAll();
		return ResponseEntity.ok(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> post(@RequestBody Categoria cat){
		Categoria obj = catService.postSave(cat);
		return ResponseEntity.ok(cat);
	}
	
}
