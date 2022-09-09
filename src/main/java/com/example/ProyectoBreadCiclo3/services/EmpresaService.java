package com.example.ProyectoBreadCiclo3.services;


import com.example.ProyectoBreadCiclo3.entities.Empresa;
import com.example.ProyectoBreadCiclo3.repository.IEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpresaService {

    private IEmpresaRepository empresaRepository;

    public EmpresaService(IEmpresaRepository rep){
        this.empresaRepository = rep;
    }

    public ArrayList<Empresa> selectAll(){

        return (ArrayList<Empresa>) this.empresaRepository.findAll();
    }

    Response response = new Response();

    public Response createEmpresa(Empresa emp){

        this.empresaRepository.save(emp);
        response.setCode(200);
        response.setMessage("Empresa creada exitosamente");

        return response;
    }
}
