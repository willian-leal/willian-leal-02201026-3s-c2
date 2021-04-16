package com.example.willianlealac2.controle;

import com.example.willianlealac2.dominio.Lutadores;
import com.example.willianlealac2.repositorio.LutadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadoresController {

    @Autowired
    private LutadoresRepository repository;

    @PostMapping
    public ResponseEntity postFilme(@RequestBody @Valid Lutadores novoLutador){
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutadores(){
        List<Lutadores> lutadores = repository.findAllByOrderByForcaGolpeDesc();
        if (lutadores.isEmpty()){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.status(200).body(lutadores);
        }
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getVivos(){
        int lutadores = repository.CountAllByVivoTrue();
        return ResponseEntity.status(200).body(lutadores);
    }
}
