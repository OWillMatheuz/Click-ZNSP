package com.click.click.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.click.click.model.Bairro;
@Repository
public interface BairroRepository extends JpaRepository <Bairro, Long>{
	public List<Bairro> findAllByNomeBairroContainingIgnoreCase(@Param("nomeBairro") String nomeBairro);
}
