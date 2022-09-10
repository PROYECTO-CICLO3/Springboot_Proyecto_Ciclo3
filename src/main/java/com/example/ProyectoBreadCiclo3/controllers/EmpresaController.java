package com.example.ProyectoBreadCiclo3.controllers;

import com.example.ProyectoBreadCiclo3.entities.Empleado;
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

    //Metodo para crear empresas
    @PostMapping("createempresa")
    public Response createEmpresa(@RequestBody Empresa emp){
        return this.empresaService.createEmpresa(emp);
    }

    //Metodo para traer todas las empresas
    @GetMapping("getempresas")
    public ArrayList<Empresa> getEmpresas(){
        return this.empresaService.selectAll();
    }

    @GetMapping("getempresa/{id}")
    public Empresa empresaById(@PathVariable long id){
        return this.empresaService.empresaById(id);
    }

    @DeleteMapping("deleteempresa/{id}")
    public Response deleteEmpresaById(long id){
        return this.empresaService.deleteEmpresaById(id);
    }

    @PatchMapping("updateempresa")
    public Response updateEmpresa(@RequestBody Empresa emp){
        return this.empresaService.updateEmpresa(emp);
    }
}
