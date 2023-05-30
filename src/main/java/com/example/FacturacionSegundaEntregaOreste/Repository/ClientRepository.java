package com.example.FacturacionSegundaEntregaOreste.Repository;

import com.example.FacturacionSegundaEntregaOreste.Models.Client;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
