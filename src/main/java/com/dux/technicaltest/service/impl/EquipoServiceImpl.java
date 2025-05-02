package com.dux.technicaltest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dux.technicaltest.entity.Equipo;
import com.dux.technicaltest.exception.BadRequestException;
import com.dux.technicaltest.exception.NotFoundException;
import com.dux.technicaltest.model.EquipoRequest;
import com.dux.technicaltest.model.EquipoResponse;
import com.dux.technicaltest.repository.EquipoRepository;
import com.dux.technicaltest.service.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public List<EquipoResponse> getEquipos() {
        List<Equipo> equipos = equipoRepository.findAll();
        return equipos.stream().map(equipo -> mapToEquipoResponse(equipo)).toList();
    }

    private EquipoResponse mapToEquipoResponse(Equipo equipo) {
        return new EquipoResponse()
            .id(equipo.getId())
            .nombre(equipo.getNombre())
            .liga(equipo.getLiga())
            .pais(equipo.getPais());
    }

    @Override
    public EquipoResponse getEquipoById(Integer id) {
        Equipo equipo = findEquipoById(id);
        return mapToEquipoResponse(equipo);
    }

    @Override
    public List<EquipoResponse> getEquiposByNombre(String nombre) {
        List<Equipo> equipos = equipoRepository.findByNombre(nombre);
        return equipos.stream().map(equipo -> mapToEquipoResponse(equipo)).toList();
    }

    @Override
    public EquipoResponse createEquipo(EquipoRequest equipoRequest) {
        validateProperties(equipoRequest);

        Equipo newEquipo = new Equipo.Builder()
                .nombre(equipoRequest.getNombre())
                .liga(equipoRequest.getLiga())
                .pais(equipoRequest.getPais())
                .build();

        Equipo equipo = equipoRepository.save(newEquipo);
        return mapToEquipoResponse(equipo);
    }
    
    private void validateProperties(EquipoRequest equipoRequest) {
        if (equipoRequest.getNombre() == null || equipoRequest.getNombre().isEmpty() ||
            equipoRequest.getLiga() == null || equipoRequest.getLiga().isEmpty() ||
            equipoRequest.getPais() == null || equipoRequest.getPais().isEmpty()) {
            throw new BadRequestException("La solicitud es invalida");
        }
    }

    @Override
    public EquipoResponse updateEquipo(String id, EquipoRequest equipoRequest) {
        Equipo equipo = findEquipoById(Integer.parseInt(id));
        equipo.setNombre(equipoRequest.getNombre());
        equipo.setLiga(equipoRequest.getLiga());
        equipo.setPais(equipoRequest.getPais());
        Equipo updatedEquipo = equipoRepository.save(equipo);
        return mapToEquipoResponse(updatedEquipo);
    }

    private Equipo findEquipoById(Integer id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipo no encontrado"));
    }

    @Override
    public void deleteEquipo(String id) {
        Equipo equipo = findEquipoById(Integer.parseInt(id));
        equipoRepository.delete(equipo);
    }

    
    
}
