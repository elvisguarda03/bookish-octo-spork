package br.com.guacom.estoque.domain.service;

import br.com.guacom.estoque.domain.entity.Produto;
import br.com.guacom.estoque.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }
}
