package com.example.ProyectoBreadCiclo3.controllers;

import com.example.ProyectoBreadCiclo3.dto.crearMovimientoDTO;
import com.example.ProyectoBreadCiclo3.dto.editEmpleadoDTO;
import com.example.ProyectoBreadCiclo3.dto.registroDTO;
import com.example.ProyectoBreadCiclo3.entities.Empleado;
import com.example.ProyectoBreadCiclo3.entities.Empresa;
import com.example.ProyectoBreadCiclo3.entities.EnumRol;
import com.example.ProyectoBreadCiclo3.entities.movimientoDinero;
import com.example.ProyectoBreadCiclo3.services.EmpleadoService;
import com.example.ProyectoBreadCiclo3.services.EmpresaService;
import com.example.ProyectoBreadCiclo3.services.MovimientoService;
import com.example.ProyectoBreadCiclo3.services.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("admin")
public class EmpleadoAdminController {

    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("empleados")
    public String usuariosRegistrados(Model usuarios){
        ArrayList<Empleado> usersDB = this.empleadoService.selectAll();
        usuarios.addAttribute("empleados", usersDB);


        return "/admin/empleadoregistrados";
    }

    @GetMapping("editempleado/{id}")
    public String edituser(@PathVariable long id, Model data){

        Empleado empleadoId = this.empleadoService.empleadoById(id);
        data.addAttribute("empleado", empleadoId);


        return "/admin/editempleado";

    }

    @PostMapping("editempleadopost")
    public RedirectView editEmpleadoPost(editEmpleadoDTO data){
        Empleado emp = new Empleado();

        emp.setId(data.getId());
        emp.setNombreEmpleado(data.getNombreEmpleado());

        if(data.getRolEmpleado().equals("ADMINISTRADOR")){
            emp.setRolEmpleado(EnumRol.ADMINISTRADOR);
            Response response = this.empleadoService.updateEmpleadoNombresRol(emp);
        } else if (data.getRolEmpleado().equals("OPERATIVO")) {
            emp.setRolEmpleado(EnumRol.OPERATIVO);
            Response response = this.empleadoService.updateEmpleadoNombresRol(emp);
        }else{
            return new RedirectView("/admin/empleados");
        }

        return new RedirectView("/admin/empleados");
    }

    @GetMapping("deleteempleado/{id}")
    public RedirectView deleteEmpleado(@PathVariable long id){

        Empleado user = this.empleadoService.empleadoById(id);

        Response response = this.empleadoService.deleteEmpleadoById(user.getId());

        return new RedirectView("/admin/empleados");
    }

    @GetMapping("createempleados")
    public String createUser(Model data){
        ArrayList<Empresa> empresas = this.empresaService.selectAll();

        //Pasamos la información al modelo de thymeleaf
        data.addAttribute("misempresas", empresas);

        return "/admin/createempleado";
    }

    @PostMapping("postregistro")
    public RedirectView postRegistro(registroDTO data){

        Empleado emp = new Empleado();
        emp.setCorreoEmpleado(data.getCorreoEmpleado());
        emp.setNombreEmpleado(data.getNombreEmpleado());
        emp.setEmpresaEmpleado(data.getEmpresa());
        emp.setPassword(data.getPassword());

        Response response = this.empleadoService.createEmpleado(emp);
        if (response.getCode() == 200) {
            return new RedirectView("/admin/empleados");
        } else {
            return new RedirectView("/login/error");
        }
    }


    @GetMapping("empleadosmovimientos")
    public String empleadosMovimientos(Model usuarios){
        ArrayList<Empleado> usersDB = this.empleadoService.selectAll();
        usuarios.addAttribute("empleados", usersDB);


        return "/admin/empleadomovimiento";
    }

    @GetMapping("movimientosdinero/{id}")
    public String movimientosEmpleado(@PathVariable long id, Model data){
        Empleado empleadoId = this.empleadoService.empleadoById(id);
        data.addAttribute("empleado", empleadoId);

        ArrayList<movimientoDinero> movimientos = this.movimientoService.getMovimientoIdEmpleado(empleadoId.getId());
        data.addAttribute("movimientos", movimientos);

        return "/admin/movimientosEmpleado";
    }


    @GetMapping("createmovimientos/{id}")
    public String createMovimiento(@PathVariable long id,Model data){
        Empleado empleadoId = this.empleadoService.empleadoById(id);
        data.addAttribute("empleado", empleadoId);



        return "/admin/createmovimiento";
    }

    @PostMapping("postmovimiento")
    public RedirectView postMovimiento(crearMovimientoDTO data){

        movimientoDinero mov = new movimientoDinero();
        mov.setEmpleadoMovimiento(data.getIdEmpleado());
        mov.setMontoMovimiento(data.getMontoMovimiento());
        mov.setConceptoMovimiento(data.getConceptoMovimiento());

        boolean response = this.movimientoService.saveOrUpdateMovimiento(mov);
        if (response == true) {
            return new RedirectView("/admin/empleadosmovimientos");
        } else {
            return new RedirectView("/login/error");
        }
    }
}
