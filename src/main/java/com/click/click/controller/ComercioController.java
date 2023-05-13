package com.click.click.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.click.click.model.Comercio;
import com.click.click.repository.ComercioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/comercios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComercioController {
	@Autowired
	private ComercioRepository comercioRepository;
	
	@GetMapping
	public ResponseEntity<List<Comercio>> getAll(){
		return ResponseEntity.ok(comercioRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Comercio> getById(@PathVariable Long id){
		return comercioRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@GetMapping("/comercio/{nomeComercio}")
	public ResponseEntity<List<Comercio>> getByNomeComercio(@PathVariable String nomeComercio){
		return ResponseEntity.ok(comercioRepository.findAllByNomeComercioContainingIgnoreCase(nomeComercio));
	}
	@PostMapping
	public ResponseEntity<Comercio> post(@Valid @RequestBody Comercio comercio) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(comercioRepository.save(comercio));
	}
	@PutMapping
	public ResponseEntity<Comercio> put(@Valid @RequestBody Comercio comercio) {
		return comercioRepository.findById(comercio.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(comercioRepository.save(comercio)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Comercio> postagem = comercioRepository.findById(id);
		
		if(postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		comercioRepository.deleteById(id);				
	}


}
