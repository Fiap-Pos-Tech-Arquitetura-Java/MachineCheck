package br.com.fiap.postech.machinecheck.repository;

import br.com.fiap.postech.machinecheck.entities.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends JpaRepository<Check, Long> {

}
