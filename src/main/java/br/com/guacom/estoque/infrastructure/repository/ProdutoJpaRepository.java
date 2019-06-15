package br.com.guacom.estoque.infrastructure.repository;

import br.com.guacom.estoque.domain.entity.Produto;
import br.com.guacom.estoque.domain.repository.ProdutoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoJpaRepository
        extends ProdutoRepository, JpaRepository<Produto, Long> {
}