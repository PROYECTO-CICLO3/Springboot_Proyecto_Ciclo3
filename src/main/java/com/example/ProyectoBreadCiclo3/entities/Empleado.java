package com.example.ProyectoBreadCiclo3.entities;

enum EnumRol{
    ADMINISTRADOR,
    OPERATIVO
}

public class Empleado {

    private String nombreEmpleado;
    //Primary key
    private String correoEmpleado;

    //foreing key?
    private Empresa empresaEmpleado;

    //Se inicializa en el constructor?
    private EnumRol rolEmpleado;


    //CONSTRUCTOR

    public Empleado(String nombreEmpleado, String correoEmpleado, Empresa empresaEmpleado, EnumRol rolEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.empresaEmpleado = empresaEmpleado;
        this.rolEmpleado = rolEmpleado;
    }


    //GETTER AND SETTERS


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

    public Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    //Poner una condicion que solo puede ser admin u operativo
    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public EnumRol getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(EnumRol rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }
}
