package br.com.aldomarassolin.portifolio_dev.repository;

import br.com.aldomarassolin.portifolio_dev.model.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    Page<Usuarios> findAllByAtivoTrue(Pageable paginacao);

}
