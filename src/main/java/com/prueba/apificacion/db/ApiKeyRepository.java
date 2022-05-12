package com.prueba.apificacion.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface ApiKeyRepository extends JpaRepository<ApiKeyDTO,Long> {
    Optional<ApiKeyDTO> findByPassword(String password);

}
