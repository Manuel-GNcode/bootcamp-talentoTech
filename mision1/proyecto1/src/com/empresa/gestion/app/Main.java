package com.empresa.gestion.app;
import com.empresa.gestion.model.*;
import com.empresa.gestion.service.NominaService;
public class Main {
  public static void main(String[] args) {
    //crear empleado
    Empleado eduardo = new Empleado(1, "Eduardo", 25, true, 'M', 500, 10);
    Gerente manuel = new Gerente(2, "Manuel", 88, true, 'M', 2000, 25, "Antioquia", 800);

    // eduardo.presentarse();
    // manuel.presentarse();

    NominaService nomina = new NominaService();
    
    // System.out.println(nomina.calcularSalarioAnual(manuel));

    System.out.println("==============");
    // System.out.println(manuel.obtenerTipoEmpleado());
    // System.out.println(eduardo.obtenerTipoEmpleado());

    double[] salarios = {eduardo.getSalario(), manuel.getSalario()};

    System.out.println(nomina.calcularTotalNomina(salarios));

    nomina.simularPagos(8);
  }
}
