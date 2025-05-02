package com.dux.technicaltest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dux.technicaltest.model.EquipoRequest;
import com.dux.technicaltest.model.EquipoResponse;
import com.dux.technicaltest.service.EquipoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
public class EquiposApiController implements EquiposApi {

    @Autowired
    private EquipoService equipoService;

    @Override
    public ResponseEntity<List<EquipoResponse>> getEquipos() {
        return ResponseEntity.ok(equipoService.getEquipos());
    }

    @Override
    public ResponseEntity<EquipoResponse> getEquipoById(Integer id) {
        EquipoResponse equipo = equipoService.getEquipoById(id);
        return ResponseEntity.ok(equipo);
    }

    @Override
    public ResponseEntity<List<EquipoResponse>> getEquiposByNombre(@NotNull @Valid String nombre) {
        return ResponseEntity.ok(equipoService.getEquiposByNombre(nombre));
    }

    @Override
    public ResponseEntity<EquipoResponse> createEquipo(@Valid EquipoRequest equipoRequest) {
        EquipoResponse response = equipoService.createEquipo(equipoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<EquipoResponse> updateEquipo(String id, @Valid EquipoRequest equipoRequest) {
        return ResponseEntity.ok(equipoService.updateEquipo(id, equipoRequest));
    }

    @Override
    public ResponseEntity<Void> deleteEquipo(String id) {
        equipoService.deleteEquipo(id);
        return ResponseEntity.noContent().build();
    }
   
}
