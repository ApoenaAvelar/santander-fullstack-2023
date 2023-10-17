package me.dio.service.imp;

import me.dio.domain.model.EmpresarioMei;
import me.dio.domain.repository.EmpresarioMeiRepository;
import me.dio.service.EmpresarioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EmpresarioServiceImp implements EmpresarioService {

    private final EmpresarioMeiRepository empresarioRepositorio;

    public EmpresarioServiceImp(EmpresarioMeiRepository empresarioRepositorio){
        this.empresarioRepositorio = empresarioRepositorio ;
    }
    @Override
    public EmpresarioMei findById(Long id) {
        return empresarioRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public EmpresarioMei create(EmpresarioMei empresarioToCreate) {
        if (empresarioRepositorio.existsByEmpresaCnpj(empresarioToCreate.getEmpresa().getCnpj())){
            throw new IllegalArgumentException("Esse cnpj já existe.");
        }
        return empresarioRepositorio.save(empresarioToCreate);
    }
}
