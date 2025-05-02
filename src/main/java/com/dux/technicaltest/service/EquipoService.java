package com.dux.technicaltest.service;

import java.util.List;

import com.dux.technicaltest.model.EquipoRequest;
import com.dux.technicaltest.model.EquipoResponse;

public interface EquipoService {

    List<EquipoResponse> getEquipos();

    EquipoResponse getEquipoById(Integer id);

    List<EquipoResponse> getEquiposByNombre(String nombre);

    EquipoResponse createEquipo(EquipoRequest equipoRequest);

    EquipoResponse updateEquipo(String id, EquipoRequest equipoRequest);

    void deleteEquipo(String id);
    
}
