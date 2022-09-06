package com.example.ProyectoBreadCiclo3.entities;

public class Empresa {

    private String nombreEmpresa;
    private String direccionEmpresa;
    private int telefonoEmpresa;
    //Posible primaryKey
    private int NITEmpresa;


    //CONSTRUCTOR

    public Empresa(String nombreEmpresa, String direccionEmpresa, int telefonoEmpresa, int NITEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.NITEmpresa = NITEmpresa;
    }


    //GETTER AND SETTERS

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public int getTelefono() {
        return telefonoEmpresa;
    }

    public void setTelefono(int telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public int getNITEmpresa() {
        return NITEmpresa;
    }

    public void setNITEmpresa(int NITEmpresa) {
        this.NITEmpresa = NITEmpresa;
    }
}
