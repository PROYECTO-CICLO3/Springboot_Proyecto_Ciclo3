package com.example.ProyectoBreadCiclo3.dto;

import com.example.ProyectoBreadCiclo3.entities.Empleado;

public class crearMovimientoDTO {

    private int montoMovimiento;

    private String conceptoMovimiento;

    private Empleado idEmpleado;


    public int getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(int montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
