package com.empresa.gestion.model;

public class Persona {
  private String nombre;
  private int edad;

  public Persona(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }
  public void setEdad(int edad) {
    this.edad = edad;
  }

  //método de la instancia
  public void presentarse() {
    System.out.println("hola, soy " + nombre + " y tengo " + edad + " años.");
  }
}
