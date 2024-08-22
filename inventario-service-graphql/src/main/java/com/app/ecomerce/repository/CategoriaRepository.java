package com.app.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ecomerce.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
