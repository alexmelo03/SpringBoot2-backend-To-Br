package com.SpringBoot2_backend.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SpringBoot2_backend.model.Aluno;
import com.SpringBoot2_backend.service.AlunoService;


@RestController
@RequestMapping(value="/aluno")
public class AlunoController {
	
	@Autowired
    private AlunoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Aluno> recuperarPorId(@PathVariable Integer id) {
		Aluno obj = service.recuperarPorId(id);
		return ResponseEntity.ok().body(obj);		
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody Aluno obj){
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build(); 

   }
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@Valid @RequestBody Aluno obj, @PathVariable Integer id){
		obj.setId(id);
		obj= service.atualizar(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable Integer id) {
		service.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Aluno>> recuperarTodos() {
		List<Aluno> list = service.recuperarTodos();
		return ResponseEntity.ok().body(list);		
		
	}
	
}
