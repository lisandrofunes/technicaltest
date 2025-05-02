package com.dux.technicaltest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dux.technicaltest.entity.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    @Query("SELECT e FROM Equipo e WHERE lower(e.nombre) LIKE lower(concat('%',:nombre,'%'))")
    List<Equipo> findByNombre(@Param("nombre") String nombre);
}
