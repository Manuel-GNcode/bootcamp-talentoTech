package com.empresa.gestion.model;

public class Empleado extends Persona{
  private double salario;
  private int horasTrabajadas;

  public Empleado(String nombre, int edad, boolean active, char genero, double salario, int horasTrabajadas) {
    super(nombre, edad, active, genero);
    this.salario = salario;
    this.horasTrabajadas = horasTrabajadas;
  }

  public double getSalario() {
    return this.salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }
  public int getHorasTrabajadas() {
    return horasTrabajadas;
  }
  public void setHorasTrabajadas(int horasTrabajadas) {
    this.horasTrabajadas = horasTrabajadas;
  }

  @Override
  public void presentarse() {
    System.out.println("Soy el empleado " + getNombre() + ", tengo " + getEdad() + " años y gano " + salario);
  }

  public double calcularSalarioMensual() {
    double valorHora = salario/160;
    return horasTrabajadas*valorHora;
  }

  public boolean esMayorEdad() {
    return getEdad() >= 18;
  }

  public boolean puedeTrabajar() {
    return getEdad() >= 18 && active;
  }
}
