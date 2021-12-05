package com.CTDECommerce.ECommerce.controller;

import com.CTDECommerce.ECommerce.model.dto.ProductDTO;
import com.CTDECommerce.ECommerce.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity salvar(@RequestBody ProductDTO product){
        ProductDTO productDTO = produtoService.salvar(product);
        if(productDTO!=null)
            return ResponseEntity.ok(productDTO);

        return ResponseEntity.badRequest().body("Produto nao cadatradado");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/buscartodos")
    public ResponseEntity<List<ProductDTO>>findAll(){

        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProductDTO> buscarPorId(@PathVariable Long id) {

        ProductDTO productDTO = produtoService.buscarPorId(id);
        return ResponseEntity.ok(productDTO);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDTO>> findbycategory(@PathVariable String category){
        List<ProductDTO> productDTO =produtoService.buscarPorCategoria(category);
        return ResponseEntity.ok(productDTO);
    }
}
