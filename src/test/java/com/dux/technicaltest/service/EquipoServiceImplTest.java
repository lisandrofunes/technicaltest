package com.dux.technicaltest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dux.technicaltest.entity.Equipo;
import com.dux.technicaltest.exception.BadRequestException;
import com.dux.technicaltest.exception.NotFoundException;
import com.dux.technicaltest.model.EquipoRequest;
import com.dux.technicaltest.model.EquipoResponse;
import com.dux.technicaltest.repository.EquipoRepository;
import com.dux.technicaltest.service.impl.EquipoServiceImpl;

@ExtendWith(MockitoExtension.class)
class EquipoServiceImplTest {

    @InjectMocks
    private EquipoServiceImpl equipoService;

    @Mock
    private EquipoRepository equipoRepository;

    private Equipo equipo;
    private EquipoRequest equipoRequest;

    @BeforeEach
    void setUp() {
        equipo = new Equipo.Builder()
                .nombre("River Plate")
                .liga("Liga Argentina")
                .pais("Argentina")
                .build();

        equipoRequest = new EquipoRequest()
                .nombre("River Plate")
                .liga("Liga Argentina")
                .pais("Argentina");
    }

    @Test
    void testGetEquipos() {
        List<Equipo> mockEquipos = List.of(equipo);

        when(equipoRepository.findAll()).thenReturn(mockEquipos);

        List<EquipoResponse> result = equipoService.getEquipos();

        assertEquals(1, result.size());
        assertEquals("River Plate", result.get(0).getNombre());
        verify(equipoRepository, times(1)).findAll();
    }

    @Test
    void testGetEquipoByIdFound() {
        when(equipoRepository.findById(anyInt())).thenReturn(Optional.of(equipo));

        EquipoResponse result = equipoService.getEquipoById(1);

        assertEquals("River Plate", result.getNombre());
        verify(equipoRepository, times(1)).findById(1);
    }

    @Test
    void testGetEquipoByIdNotFound() {
        when(equipoRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> equipoService.getEquipoById(100));
    }

    @Test
    void testGetEquipoByNombre() {
        List<Equipo> equipos = List.of(equipo);
        when(equipoRepository.findByNombre(anyString())).thenReturn(equipos);

        List<EquipoResponse> result = equipoService.getEquiposByNombre("River Plate");

        assertEquals(1, result.size());
        assertEquals("River Plate", result.get(0).getNombre());
        verify(equipoRepository, times(1)).findByNombre("River Plate");
    }

    @Test
    void testCreateEquipoValid() {
        when(equipoRepository.save(any(Equipo.class))).thenReturn(equipo);

        EquipoResponse response = equipoService.createEquipo(equipoRequest);

        assertEquals("River Plate", response.getNombre());
        verify(equipoRepository).save(any(Equipo.class));
    }

    private void testValidateEquipoRequest(EquipoRequest equipoRequest) {
        assertThrows(BadRequestException.class, () -> equipoService.createEquipo(equipoRequest));
        verify(equipoRepository, never()).save(any());
    }

    @Test
    void testCreateEquipoInvalid_NombreEmpty() {
        EquipoRequest request = new EquipoRequest()
                .nombre("").liga("liga").pais("pais");

        testValidateEquipoRequest(request);
    }

    @Test
    void testCreateEquipoInvalid_LigaEmpty() {
        EquipoRequest request = new EquipoRequest()
                .nombre("Nombre").liga("").pais("pais");

        testValidateEquipoRequest(request);
    }

    @Test
    void testCreateEquipoInvalid_PaisEmpty() {
        EquipoRequest request = new EquipoRequest()
                .nombre("Nombre").liga("liga").pais("");

        testValidateEquipoRequest(request);
    }

    @Test
    void testUpdateEquipoValid() {
        EquipoRequest request = new EquipoRequest()
                .nombre("Manchester United").liga("Premier League").pais("Inglaterra");

        when(equipoRepository.findById(1)).thenReturn(Optional.of(equipo));
        when(equipoRepository.save(equipo)).thenReturn(equipo);

        EquipoResponse response = equipoService.updateEquipo(1, request);

        assertEquals("Manchester United", response.getNombre());
        verify(equipoRepository).findById(1);
        verify(equipoRepository).save(equipo);
    }

    @Test
    void testUpdateEquipoNotFound() {
        when(equipoRepository.findById(100)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> equipoService.updateEquipo(100, equipoRequest));
        verify(equipoRepository, never()).save(any());
    }

    @Test
    void testUpdateEquipoInvalid_NombreNull() {
        EquipoRequest request = new EquipoRequest().nombre(null).liga("liga").pais("pais");
        testValidateEquipoRequest(request);
    }

    @Test
    void testUpdateEquipoInvalid_PaisNull() {
        EquipoRequest request = new EquipoRequest().nombre("nombre").liga(null).pais("pais");
        testValidateEquipoRequest(request);
    }

    @Test
    void testUpdateEquipoInvalid_LigaNull() {
        EquipoRequest request = new EquipoRequest().nombre("nombre").liga("liga").pais(null);
        testValidateEquipoRequest(request);
    }

    @Test
    void testDeleteEquipo() {
        when(equipoRepository.findById(10)).thenReturn(Optional.of(equipo));

        equipoService.deleteEquipo(10);

        verify(equipoRepository).delete(equipo);
    }

    @Test
    void testDeleteEquipoNotFound() {
        when(equipoRepository.findById(123)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> equipoService.deleteEquipo(123));
        verify(equipoRepository, never()).delete(any());
    }



}