package com.empresa.gestion.model;

public class Gerente extends Empleado{
  private String departamento;

  public Gerente(String nombre, int edad, double salario, String departamento) {
    super(nombre, edad, salario);
    this. departamento = departamento;
  }

  public String getDepartamento() {
    return this.departamento;
  }
  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  @Override
  public void presentarse() {
    System.out.println("Soy el empleado " + getNombre() + ", gano " + getSalario() + "y departamento " + departamento);
  }
}
