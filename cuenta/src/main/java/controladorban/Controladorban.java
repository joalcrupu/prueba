package controladorban;

import modeloban.Modelocon;
import vistacon.Vistacon;

public class Controladorban {

    private Modelocon modelo;
    private Vistacon vista;

    public Controladorban(Modelocon modelo, Vistacon vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void realizarTransaccion() {
        boolean salir = false;
        while (!salir) {
            String opcion = vista.obtenerTipoTransaccion();

            if (opcion.equals("depositar")) {
                int cantidad = vista.obtenerCantidad();
                modelo.depositar(cantidad);
                vista.mostrarMensaje("Depósito exitoso. Saldo actual: " + modelo.getSaldo());
            } else if (opcion.equals("retirar")) {
                int cantidad = vista.obtenerCantidad();
                boolean exito = modelo.retirar(cantidad);

                if (exito) {
                    vista.mostrarMensaje("Retiro exitoso. Saldo actual: " + modelo.getSaldo());
                } else {
                    vista.mostrarMensaje("Fondos insuficientes. Saldo actual: " + modelo.getSaldo());
                }
            } else if (opcion.equals("salir")) {
                {

                    System.exit(0);
                }
            }
        }
    }
}
