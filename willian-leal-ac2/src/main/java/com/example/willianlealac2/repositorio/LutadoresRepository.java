package com.example.willianlealac2.repositorio;

import com.example.willianlealac2.dominio.Lutadores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LutadoresRepository extends JpaRepository<Lutadores, Integer> {

    List<Lutadores> findAllByOrderByForcaGolpeDesc();

    List<Lutadores> findAllByVivoTrue();


    int CountAllByVivoTrue();
}
