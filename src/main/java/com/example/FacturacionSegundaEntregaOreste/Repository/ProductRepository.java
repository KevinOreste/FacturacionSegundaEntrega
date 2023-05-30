package com.example.FacturacionSegundaEntregaOreste.Repository;

import com.example.FacturacionSegundaEntregaOreste.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.sound.sampled.Port;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
