package co.edu.ucc.Maria.bridge;

import java.util.Base64;

interface Renderizador {
    void renderizar(String figura);
}

class OpenGL implements Renderizador {
    public void renderizar(String figura) {
        System.out.println("Renderizando " + figura + " con OpenGL");
    }
}

class DirectX implements Renderizador {
    public void renderizar(String figura) {
        System.out.println("Renderizando " + figura + " con DirectX");
    }
}

abstract class Figura {
    protected Renderizador renderizador;

    public Figura(Renderizador renderizador) {
        this.renderizador = renderizador;
    }

    public abstract void dibujar();
}

class Circulo extends Figura {
    public Circulo(Renderizador renderizador) {
        super(renderizador);
    }

    public void dibujar() {
        renderizador.renderizar("Círculo");
    }
}

class Rectangulo extends Figura {
    public Rectangulo(Renderizador renderizador) {
        super(renderizador);
    }

    public void dibujar() {
        renderizador.renderizar("Rectángulo");
    }
}

public class Main {
    public static void main(String[] args) {
        mostrarEncabezado();
        
        Figura f1 = new Circulo(new OpenGL());
        Figura f2 = new Rectangulo(new DirectX());

        f1.dibujar();
        f2.dibujar();
    }

    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Como desarrollador de un banco digital,");
        System.out.println("   necesito un sistema que permita a los clientes solicitar diferentes tipos de préstamos");
        System.out.println("   (hipotecario, automotriz, personal) con diferentes tasas de interés y plazos.");
        System.out.println("   El sistema debe garantizar que las reglas de negocio sean aplicadas correctamente según el tipo de préstamo seleccionado.");
        System.out.println("============================");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("============================");
    }

    public static String getIdentidad() {
        String nombre = "María José";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    public static String getPatron() {
        return "Bridge";
    }
}
