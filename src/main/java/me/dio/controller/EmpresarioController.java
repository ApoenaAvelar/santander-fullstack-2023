package me.dio.controller;

import me.dio.domain.model.EmpresarioMei;
import me.dio.service.EmpresarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/empresarios")
public class EmpresarioController {

    private final EmpresarioService empresarioService;
    public EmpresarioController(EmpresarioService empresarioService){
        this.empresarioService = empresarioService ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpresarioMei> findById(@PathVariable Long id){
       var empresario = empresarioService.findById(id) ;
       return ResponseEntity.ok(empresario);
    }

    @PostMapping
    public ResponseEntity<EmpresarioMei> create(@RequestBody EmpresarioMei empresarioToCreate){
        var empresarioCriado = empresarioService.create(empresarioToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(empresarioCriado.getId()).toUri();
        return ResponseEntity.created(location).body(empresarioCriado);
    }


}
