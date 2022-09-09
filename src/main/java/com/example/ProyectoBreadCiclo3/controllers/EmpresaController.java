package com.example.ProyectoBreadCiclo3.controllers;

import com.example.ProyectoBreadCiclo3.entities.Empresa;
import com.example.ProyectoBreadCiclo3.services.EmpresaService;
import com.example.ProyectoBreadCiclo3.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("empresa")
public class EmpresaController {

    public EmpresaService empresaService;

    public EmpresaController(EmpresaService emp){
        this.empresaService = emp;
    }

    @PostMapping("createempresa")
    public Response createEmpresa(@RequestBody Empresa emp){
        return this.empresaService.createEmpresa(emp);
    }

    
    @RequestMapping("getempresas")
    public ArrayList<Empresa> getEmpresas(){
        return this.empresaService.selectAll();
    }


}
