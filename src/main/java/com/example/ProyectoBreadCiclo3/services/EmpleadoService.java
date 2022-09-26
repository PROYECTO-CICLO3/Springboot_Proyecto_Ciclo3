package com.example.ProyectoBreadCiclo3.services;

import com.example.ProyectoBreadCiclo3.entities.Empleado;
import com.example.ProyectoBreadCiclo3.entities.Empresa;
import com.example.ProyectoBreadCiclo3.entities.movimientoDinero;
import com.example.ProyectoBreadCiclo3.repository.IEmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public Response loginUser(Empleado data){

        //Logica de negocio

        //Validamos password
        if (data.getPassword().equals(null) || data.getPassword().equals("")){
            response.setCode(200);
            response.setMessage("contraseña incorrecta");

            return response;
        }

        ArrayList<Empleado> existe = this.empleadoRepository.validaCredenciales(data.getCorreoEmpleado(), data.getPassword());

        if(existe != null && existe.size() > 0){
            response.setCode(200);
            response.setMessage("" +
                    "Empleado logeado exitosamente");

            return response;
        }

        response.setCode(500);
        response.setMessage("Error, sus datos de acceso no son validos");

        return response;
    }

    public Response updateEmpleadoNombresRol(Empleado data){

        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el ID del usuario no es valido");
            return response;
        }

        //Validar si el usuario existe
        Empleado existe = empleadoById(data.getId());

        //Validar si el ID que llego pertence a un usuario
        if(existe == null){
            response.setCode(500);
            response.setMessage("Error, el Usuario no existe en la base de datos");
            return response;
        }


        existe.setNombreEmpleado(data.getNombreEmpleado());
        existe.setRolEmpleado(data.getRolEmpleado());

        this.empleadoRepository.save(existe);
        response.setCode(200);
        response.setMessage("Usuario modificado exitosamente");

        return response;
    }


}
