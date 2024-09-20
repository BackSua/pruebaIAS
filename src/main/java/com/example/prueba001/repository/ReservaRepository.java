package com.example.prueba001.repository;

import com.example.prueba001.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    Optional<ReservaEntity> findByIdUsuarioAndIdVueloAndIdTiqueteAndCiudadAndId(
            Long idUsuario, Long idVuelo, Long idTiquete, String ciudad, Long idReserva);
}
