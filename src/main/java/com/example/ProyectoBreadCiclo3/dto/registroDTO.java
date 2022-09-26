package com.example.ProyectoBreadCiclo3.dto;

import com.example.ProyectoBreadCiclo3.entities.Empresa;

public class registroDTO {
    private String nombreEmpleado;
    private String correoEmpleado;
    private Empresa empresa;
    private String password;
    private String validaPassword;

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidaPassword() {
        return validaPassword;
    }

    public void setValidaPassword(String validaPassword) {
        this.validaPassword = validaPassword;
    }
}
