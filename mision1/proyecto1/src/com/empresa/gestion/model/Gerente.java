package com.empresa.gestion.model;

public class Gerente extends Empleado{
  private String departamento;
  private double bono;

  public Gerente(String nombre, int edad, boolean active, char genero, double salario,int horasTrabajadas, String departamento, double bono) {
    super(nombre, edad, active, genero, salario, horasTrabajadas);
    this. departamento = departamento;
    this.bono = bono;
  }

  public String getDepartamento() {
    return this.departamento;
  }
  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }
  public double getBono() {
    return bono;
  }

  public void setBono(double bono) {
    this.bono = bono;
  }

  @Override
  public void presentarse() {
    System.out.println("Soy el empleado " + getNombre() + ", gano " + getSalario() + " y departamento " + departamento);
  }

  @Override
  public double calcularSalarioMensual() {
    double salario = super.calcularSalarioMensual();
    return salario + bono;
  }
}
