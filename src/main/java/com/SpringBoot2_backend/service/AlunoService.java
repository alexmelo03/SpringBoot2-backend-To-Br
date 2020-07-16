package com.SpringBoot2_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot2_backend.model.Aluno;
import com.SpringBoot2_backend.repository.AlunoRepository;
import com.SpringBoot2_backend.service.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	public Aluno recuperarPorId(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Aluno.class.getName()));
	
	}
	
	public Aluno inserir(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Aluno atualizar(Aluno obj) {
		recuperarPorId(obj.getId());
		return repo.save(obj);
	}
	
	public void remover(Integer id) {
		recuperarPorId(id);
		repo.deleteById(id);
	}
	
	public List<Aluno> recuperarTodos() {
		return repo.findAll();
	}
	

}
