package com.app.ecomerce.dto;

public record ProductoRequest(
    String id,
    String nombre,
    String descripcion,
    int cantidad,
    double precio,
    Long categoriaId
) {
    
}
