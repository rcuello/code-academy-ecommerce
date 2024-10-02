package com.tecno.api_sec.controllers.api.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecno.api_sec.persistence.entity.Product;
import com.tecno.api_sec.services.business.IProductService;

@CrossOrigin
@RestController
@RequestMapping("/customer/products")
public class CustomerProductController {
    @Autowired
    private IProductService productService;

    //@PreAuthorize("hasRole('CUSTOMER')")
    @CrossOrigin
    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable){

        Page<Product> productsPage = productService.findAll(pageable);

        if(productsPage.hasContent()){
            return ResponseEntity.ok(productsPage);
        }

        return ResponseEntity.notFound().build();
    }
}
