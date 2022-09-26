package com.example.ProyectoBreadCiclo3.repository;

import com.example.ProyectoBreadCiclo3.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query(value="SELECT * FROM empresas where id in (select empresa_id from empleados where id= ?1)", nativeQuery = true)
    Empresa findEmpresaEmpleado(long id);
}
