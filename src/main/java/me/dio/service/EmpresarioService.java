package me.dio.service;

import me.dio.domain.model.EmpresaMei;
import me.dio.domain.model.EmpresarioMei;

public interface EmpresarioService {
    EmpresarioMei findById(Long id);
    EmpresarioMei create(EmpresarioMei empresarioToCreate);

}
