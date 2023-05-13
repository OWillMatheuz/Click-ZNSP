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

import com.click.click.model.Bairro;
import com.click.click.repository.BairroRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bairros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BairroController {
	 @Autowired
	    private BairroRepository bairroRepository;
	    
	    @GetMapping
	    public ResponseEntity<List<Bairro>> getAll(){
	        return ResponseEntity.ok(bairroRepository.findAll());
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Bairro> getById(@PathVariable Long id){
	        return bairroRepository.findById(id)
	            .map(resposta -> ResponseEntity.ok(resposta))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	    
	    @GetMapping("/bairros/{nomeBairro}")
	    public ResponseEntity<List<Bairro>> getByNomeBairro(@PathVariable 
	    String nomeBairro){
	        return ResponseEntity.ok(bairroRepository
	            .findAllByNomeBairroContainingIgnoreCase(nomeBairro));
	    }
	    
	    @PostMapping
	    public ResponseEntity<Bairro> post(@Valid @RequestBody Bairro bairro){
	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(bairroRepository.save(bairro));
	    }
	    
	    @PutMapping
	    public ResponseEntity<Bairro> put(@Valid @RequestBody Bairro bairro){
	        return bairroRepository.findById(bairro.getId())
	            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
	            .body(bairroRepository.save(bairro)))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	    
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        Optional<Bairro> bairro = bairroRepository.findById(id);
	        
	        if(bairro.isEmpty())
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        
	        bairroRepository.deleteById(id);              
	    }

	}