package com.empresa.gestion.model;

public class Persona {
  private String nombre;
  private int edad;
  protected boolean active;
  private char genero;

  public Persona(String nombre, int edad, boolean active, char genero) {
    this.nombre = nombre;
    this.edad = edad;
    this.active = active;
    this.genero = genero;
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

  public char getGenero() {
    return genero;
  }
  public void setGenero(char genero) {
    this.genero = genero;
  }

  //método de la instancia
  public void presentarse() {
    System.out.println("hola, soy " + nombre + " y tengo " + edad + " años.");
  }
  public void mostrarInfoBasica() {
    System.out.println("Nombre: "+nombre);
    System.out.println("Edad: "+edad);
    System.out.println("Genero: "+genero);
    System.out.println("Estado: "+active);
  }
}
