package br.com.guacom.estoque.domain.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    T save(T obj);
    List<T> findAll();
    Optional<T> findById(Long id);
    void deleteById(Long id);
}
