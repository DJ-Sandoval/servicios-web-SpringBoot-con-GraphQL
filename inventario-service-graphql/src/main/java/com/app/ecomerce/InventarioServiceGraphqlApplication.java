package com.app.ecomerce;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.ecomerce.entities.Categoria;
import com.app.ecomerce.entities.Producto;
import com.app.ecomerce.repository.CategoriaRepository;
import com.app.ecomerce.repository.ProductoRepository;

@SpringBootApplication
public class InventarioServiceGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioServiceGraphqlApplication.class, args); }

		@Bean
		CommandLineRunner commandLineRunner(CategoriaRepository categoriaRepository, ProductoRepository productoRepository) {
			Random random = new Random();
			return args -> {
				// Crear y guardar categorías
				List<Categoria> categorias = List.of("Computadoras", "Impresoras", "Smarthphones").stream()
				.map(cat -> Categoria.builder().nombre(cat).build())
				.collect(Collectors.toList());
			
			categoriaRepository.saveAll(categorias);

			// Crear y guardar productos
			categoriaRepository.findAll().forEach(categoria -> {
				for (int i = 0; i < 10; i++) {
					Producto producto = Producto.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Computadora " + i)
					.descripcion("DELL " + i)
                    .precio(100 + Math.random() * 50000)
                    .cantidad(random.nextInt(100))
                    .categoria(categoria)
                    .build();
				productoRepository.save(producto);
				}
			});	


			};
		}
	}



