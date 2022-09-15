package com.example.ProyectoBreadCiclo3.repository;

import com.example.ProyectoBreadCiclo3.entities.movimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IMovimientoDineroRepository extends JpaRepository<movimientoDinero, Long> {

    //@Query(value="select * from movimientos_dineros where empresa_id in (select id from empresas where id= ?1)", nativeQuery = true)
    //ArrayList<movimientoDinero> findByEmpresa(long id);
}
