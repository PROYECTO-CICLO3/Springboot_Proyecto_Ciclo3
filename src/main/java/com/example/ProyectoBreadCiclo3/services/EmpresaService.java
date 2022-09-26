package com.example.ProyectoBreadCiclo3.services;


import com.example.ProyectoBreadCiclo3.entities.Empleado;
import com.example.ProyectoBreadCiclo3.entities.Empresa;
import com.example.ProyectoBreadCiclo3.repository.IEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private IEmpresaRepository empresaRepository;

    public EmpresaService(IEmpresaRepository rep){
        this.empresaRepository = rep;
    }

    //Metodo para traer todos las empresas
    public ArrayList<Empresa> selectAll(){

        return (ArrayList<Empresa>) this.empresaRepository.findAll();
    }

    Response response = new Response();

    //Metodo para crear una empresa
    public Response createEmpresa(Empresa emp){

        this.empresaRepository.save(emp);
        response.setCode(200);
        response.setMessage("Empresa creada exitosamente");

        return response;
    }

    //Metodo para traer empresa por id

    public Empresa empresaById(long id){
        Optional<Empresa> empresa = this.empresaRepository.findById(id);

        if(empresa.isPresent()){
            return empresa.get();
        }else {
            return null;
        }
    }

    public Response deleteEmpresaById(long id){
        try{
            this.empresaRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("Empresa eliminado exitosamente");

            return response;
        }catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error " + ex.getMessage());
            return response;
        }

    }

    public Response updateEmpresa(Empresa empresa){

        if(empresa.getId()==0){
            response.setCode(500);
            response.setMessage("Error, el ID de la empresa no es valido");
            return response;
        }

        Empresa empCompleto = empresaById(empresa.getId());

        if(empCompleto == null){
            response.setCode(500);
            response.setMessage("Error, la empresa no existe");
            return response;
        }

        if(empresa.getNombreEmpresa() == null || empresa.getNombreEmpresa() == ""){
            response.setCode(500);
            response.setMessage("Error, el nombre ingresado es incorrecto");
            return response;
        }

        empCompleto.setNombreEmpresa(empresa.getNombreEmpresa());

        this.empresaRepository.save(empCompleto);
        response.setCode(200);
        response.setMessage("Empresa modificada exitosamente");

        return response;

    }

    public Empresa getEmpresaIdEmpleado(long id){

        return this.empresaRepository.findEmpresaEmpleado(id);
    }
}
