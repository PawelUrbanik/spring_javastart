package pl.javastart.springangularhttp.controller.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.springangularhttp.model.Product;
import pl.javastart.springangularhttp.service.ProductService;

import javax.security.auth.kerberos.KerberosTicket;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/products", produces = "application/json")
public class ProductControllerRest {

    ProductService productService;

    public ProductControllerRest(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<?> getProducts(){
        List<Product> products = productService.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id)
    {
        Optional<Product> product = productService.getProduct(id);
        if (product.isPresent())return ResponseEntity.ok(product.get());
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> addProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


}
