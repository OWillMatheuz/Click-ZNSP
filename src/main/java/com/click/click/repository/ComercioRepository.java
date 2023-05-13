package com.click.click.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.click.click.model.Comercio;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Long>{
	List<Comercio> findAllByNomeComercioContainingIgnoreCase(@Param("nomeComercio") String nomeComercio);
}
