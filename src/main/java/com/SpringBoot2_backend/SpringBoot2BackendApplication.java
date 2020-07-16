package com.SpringBoot2_backend;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SpringBoot2_backend.model.Aluno;
import com.SpringBoot2_backend.repository.AlunoRepository;

@SpringBootApplication
public class SpringBoot2BackendApplication implements CommandLineRunner {
	
	@Autowired
	private AlunoRepository alunoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Aluno al1 = new Aluno(null, "João Santos", 28);
		Aluno al2 = new Aluno(null, "Maria Silva", 30);
		Aluno al3 = new Aluno(null, "João Pedro", 35);
		
		alunoRepository.saveAll(Arrays.asList(al1, al2, al3));
	}

}
