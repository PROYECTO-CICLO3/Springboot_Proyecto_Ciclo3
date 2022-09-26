package com.example.ProyectoBreadCiclo3.repository;

import com.example.ProyectoBreadCiclo3.entities.Empleado;
import com.example.ProyectoBreadCiclo3.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {

    @Query("SELECT u FROM Empleado u WHERE u.correoEmpleado = ?1 and u.password = ?2")
    ArrayList<Empleado> validaCredenciales(String usuario, String password);

    @Query("SELECT p FROM Empleado p WHERE p.correoEmpleado = ?1")
    ArrayList<Empleado>existeCorreo(String correoElectronico);

    @Query("SELECT u FROM Empleado u WHERE u.correoEmpleado = ?1")
    Empleado findByUsername(String correoElectronico);


}
