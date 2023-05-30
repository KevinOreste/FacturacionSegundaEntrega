package com.example.FacturacionSegundaEntregaOreste.Controllers;


import com.example.FacturacionSegundaEntregaOreste.DTO.ClientDTO;
import com.example.FacturacionSegundaEntregaOreste.DTO.ProductDTO;
import com.example.FacturacionSegundaEntregaOreste.Models.Product;
import com.example.FacturacionSegundaEntregaOreste.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping (path = "/")
    public String createProduct (@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return "se agrego el producto";
    }

    @GetMapping (path = "/")
    public List<Product> getProducts (){
        return productService.getProducts();
    }

    @DeleteMapping (path = "/{id}")
    public String deleteProduct(@PathVariable int id){

        try{
            productService.deleteProduct(id);
            return "se borro el producto";
        }catch (Exception e){
            return "ocurrio un error al borrar el producto";
        }

    }

    @PutMapping (path = "/{id}")
    public String modifyProduct (@RequestBody ProductDTO productDTO, @PathVariable int id){

        try {
            productService.modifyProduct(productDTO, id);
            return "se modifico el producto";
        }catch (Exception e){
            return "no se encontro el producto";
        }

    }



}
