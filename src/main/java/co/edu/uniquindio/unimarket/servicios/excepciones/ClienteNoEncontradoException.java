package co.edu.uniquindio.unimarket.excepciones;

public class Excepcion extends Exception {

        public Excepcion(String mensaje) {
            super(mensaje);
        }

        public Excepcion(String mensaje, Throwable causa) {
            super(mensaje, causa);
        }
    }

