package com.example.ProyectoBreadCiclo3.services;

import com.example.ProyectoBreadCiclo3.entities.Empleado;
import com.example.ProyectoBreadCiclo3.repository.IEmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    //Metodo para crear un empleado
    public Response createEmpleado(Empleado emp){

        this.empleadoRepository.save(emp);
        response.setCode(200);
        response.setMessage("Empleado creado exitosamente");

        return response;
    }

    //Metodo para buscar un usuario por ID

    public Empleado empleadoById(long id){

        Optional<Empleado> empleado = this.empleadoRepository.findById(id);

        if(empleado.isPresent()){
            return empleado.get();
        }else{
            return null;
        }
    }


    //Metodo para eliminar un usuario
    public Response deleteEmpleadoById(long id){
        try{
            this.empleadoRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("Empleado eliminado exitosamente");

            return response;
        }catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error " + ex.getMessage());
            return response;
        }

    }

    public Response updateEmpleado(Empleado empleado){

        if(empleado.getId()==0){
            response.setCode(500);
            response.setMessage("Error, el ID del empleado no es valido");
            return response;
        }

        Empleado empCompleto = empleadoById(empleado.getId());

        if(empCompleto == null){
            response.setCode(500);
            response.setMessage("Error, el empleado no existe");
            return response;
        }

        if(empleado.getNombreEmpleado() == null || empleado.getNombreEmpleado() == ""){
            response.setCode(500);
            response.setMessage("Error, el nombre ingresado es incorrecto");
            return response;
        }

        empCompleto.setNombreEmpleado(empleado.getNombreEmpleado());

        this.empleadoRepository.save(empCompleto);
        response.setCode(200);
        response.setMessage("Empleado modificado exitosamente");

        return response;

    }
}
