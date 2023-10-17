package me.dio.domain.repository;

import me.dio.domain.model.EmpresarioMei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresarioMeiRepository extends JpaRepository<EmpresarioMei, Long> {
    boolean existsByEmpresaCnpj(String cnpj);
}
