package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(
            CategoriaRepository categoriaRepo,
            ProductoRepository productoRepo) {

        return args -> {

            if (categoriaRepo.count() == 0) {

                Categoria bebidas = new Categoria();
                bebidas.setNombre("Bebidas");

                Categoria snacks = new Categoria();
                snacks.setNombre("Snacks");

                categoriaRepo.save(bebidas);
                categoriaRepo.save(snacks);

                Producto p1 = new Producto();
                p1.setNombre("Coca Cola");
                p1.setPrecio(3.5);
                p1.setCategoria(bebidas);

                Producto p2 = new Producto();
                p2.setNombre("Papas Lays");
                p2.setPrecio(2.0);
                p2.setCategoria(snacks);

                productoRepo.save(p1);
                productoRepo.save(p2);
            }
        };
    }
}