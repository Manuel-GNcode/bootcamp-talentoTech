package com.empresa.gestion.model;

public class Empleado extends Persona{
  private double salario;
  private int horasTrabajadas;

  public Empleado(int id, String nombre, int edad, boolean active, char genero, double salario, int horasTrabajadas) {
    super(id, nombre, edad, active, genero);
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
    return edad >= 18;
  }

  public boolean puedeTrabajar() {
    return edad >= 18 && active;
  }

  public String clasificarEmpleado() {
    if (edad < 18) {
      return "Es menor de edad";
    } else if (edad < 60) {
      return "puede trabajar";
    }
    return "No puede trabajar";
  }

  public String obtenerTipoEmpleado() {
    switch (genero) {
      case 'M':
        return "Es un macho";
      case 'F':
        return "Es una hembre";
      default:
        return "salio loca";
    }
  }
}

