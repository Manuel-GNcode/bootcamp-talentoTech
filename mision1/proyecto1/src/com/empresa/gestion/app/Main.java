package com.empresa.gestion.app;
import com.empresa.gestion.model.*;
import com.empresa.gestion.service.NominaService;

public class Main {
  public static void main(String[] args) {
    //crear empleado
    Empleado eduardo = new Empleado("Eduardo", 25, 500);
    Gerente manuel = new Gerente("Manuel", 28, 2000, "Antioquia");

    eduardo.presentarse();
    manuel.presentarse();

    NominaService nomina = new NominaService();
    System.out.println(nomina.calcularSalarioAnual(manuel));
  }
}
