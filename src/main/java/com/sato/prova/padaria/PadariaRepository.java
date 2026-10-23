package com.sato.prova.padaria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PadariaRepository extends JpaRepository<PadariaModel, Long> {
	Optional <PadariaModel> findByNome(String nome);
}
