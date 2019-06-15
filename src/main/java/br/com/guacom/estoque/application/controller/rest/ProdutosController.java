package br.com.guacom.estoque.application.controller.rest;

import br.com.guacom.estoque.domain.entity.Produto;
import br.com.guacom.estoque.domain.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("api/produtos")
@RestController
public class ProdutosController {
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        var produtos = produtoService.findAll();

        if (produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestParam("id") Optional<Long> record, @RequestBody Produto produto) {
        if (!record.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        var rec = produtoService.findById(record.get());
        rec.ifPresent(id -> produtoService.save(produto));

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestParam("id") Optional<Long> record) {
        if (!record.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        produtoService.deleteById(record.get());

        return ResponseEntity.noContent().build();
    }
}