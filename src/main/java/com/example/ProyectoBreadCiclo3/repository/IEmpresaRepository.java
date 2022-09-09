package com.example.ProyectoBreadCiclo3.repository;

import com.example.ProyectoBreadCiclo3.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {


}
