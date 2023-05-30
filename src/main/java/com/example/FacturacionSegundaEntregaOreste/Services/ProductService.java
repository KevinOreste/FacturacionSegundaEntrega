package com.example.FacturacionSegundaEntregaOreste.Services;


import com.example.FacturacionSegundaEntregaOreste.DTO.ProductDTO;
import com.example.FacturacionSegundaEntregaOreste.Models.Client;
import com.example.FacturacionSegundaEntregaOreste.Models.Product;
import com.example.FacturacionSegundaEntregaOreste.Repository.ProductRepository;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct (ProductDTO productDTO){
        Product product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setCode(productDTO.getCode());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        return productRepository.save(product);
    }

    public List<Product> getProducts(){ return productRepository.findAll();}

    public void deleteProduct(int id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new Exception();
        }
        productRepository.delete(product.get());
    }

    public Product modifyProduct (ProductDTO productDTO, int id) throws Exception {

        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new Exception();
        }
        Product newProduct = product.get() ;
        newProduct.setDescription(productDTO.getDescription());
        newProduct.setStock(productDTO.getStock());
        newProduct.setPrice(productDTO.getPrice());
        newProduct.setCode(productDTO.getCode());
        return productRepository.save(newProduct);
    }

}
