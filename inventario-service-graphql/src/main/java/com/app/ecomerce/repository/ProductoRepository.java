package com.app.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ecomerce.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {

}
