package com.example.ProyectoBreadCiclo3.services;

import com.example.ProyectoBreadCiclo3.entities.Empleado;
import com.example.ProyectoBreadCiclo3.repository.IEmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpleadoService {

    private IEmpleadoRepository empleadoRepository;

    public EmpleadoService(IEmpleadoRepository rep){
        this.empleadoRepository = rep;
    }

    public ArrayList<Empleado> selectAll(){

        return (ArrayList<Empleado>) this.empleadoRepository.findAll();
    }

    Response response = new Response();

    public Response createEmpleado(Empleado emp){

        this.empleadoRepository.save(emp);
        response.setCode(200);
        response.setMessage("Empleado creado exitosamente");

        return response;
    }
}
