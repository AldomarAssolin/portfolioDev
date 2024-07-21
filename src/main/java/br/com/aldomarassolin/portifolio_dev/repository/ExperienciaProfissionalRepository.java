package br.com.aldomarassolin.portifolio_dev.repository;

import br.com.aldomarassolin.portifolio_dev.model.ExperienciaProfissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {
}
