package com.example.ProyectoBreadCiclo3.controllers;

import com.example.ProyectoBreadCiclo3.dto.loginDTO;
import com.example.ProyectoBreadCiclo3.dto.registroDTO;
import com.example.ProyectoBreadCiclo3.entities.Empleado;
import com.example.ProyectoBreadCiclo3.entities.Empresa;
import com.example.ProyectoBreadCiclo3.services.EmpleadoService;
import com.example.ProyectoBreadCiclo3.services.EmpresaService;
import com.example.ProyectoBreadCiclo3.services.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class LoginController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/")
    public String root(){
        return "login/login";
    }

    @GetMapping("login")
    public String login(){
        return "login/login";
    }

    @GetMapping("registro")
    public String registro(Model data){

        ArrayList<Empresa> empresas = this.empresaService.selectAll();

        data.addAttribute("misempresas", empresas);

        return "login/registro";
    }

    @PostMapping("postregistro")

    public RedirectView postRegistro(registroDTO data){

        if(data.getPassword().equals(null) || data.getPassword().equals("")){
            return new RedirectView("/error");
        }
        if(!data.getPassword().equals(data.getValidaPassword())){
            return new RedirectView("/error");
        }

        Empleado empleado = new Empleado();
        empleado.setCorreoEmpleado(data.getCorreoEmpleado());
        empleado.setNombreEmpleado(data.getNombreEmpleado());
        empleado.setEmpresaEmpleado(data.getEmpresa());
        empleado.setPassword(data.getPassword());

        Response response = this.empleadoService.createEmpleado(empleado);
        if (response.getCode() == 200) {
            return new RedirectView("/login");
        } else {
            return new RedirectView("/error");
        }

    }

    @PostMapping("postlogin")
    public RedirectView postLogin(loginDTO data) {

        Empleado empleado = new Empleado();

        empleado.setCorreoEmpleado(data.getCorreoEmpleado());
        empleado.setPassword(data.getPassword());

        Response response = this.empleadoService.loginUser(empleado);
        if (response.getCode() == 200) {
            return new RedirectView("/inicio");
        } else {
            return new RedirectView("/error");
        }
    }
}
