package com.velasuez.tutorial1;

import java.io.Serializable;

public class Persona  implements Serializable {

    private  int codigo;
    private String funcionario;
    private String cargo;
    private String area;
    private String hijos;
    private String estado;
    private String descuento;

    public Persona() {
    }


    public Persona(int codigo, String funcionario,String cargo,String area,String hijos, String estado, String descuento) {
        this.codigo = codigo;
        this.funcionario = funcionario;
        this.cargo = cargo;
        this.area = area;
        this.hijos = hijos;
        this.estado = estado;
        this.descuento = descuento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHijos() {
        return hijos;
    }

    public void setHijos(String hijos) {
        this.hijos = hijos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
}
