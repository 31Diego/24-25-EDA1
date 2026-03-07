package reto001b;

public class Orden {

    private final int maximo;
    private int numeroElementos = 0;
    private char[] datos;

    public Orden() {
        this.maximo = 50;
        this.datos = new char[maximo];
    }

    public Orden(int limite) {
        this.maximo = limite;
        this.datos = new char[limite];
    }

    public void insertar(char letra) {
        if (numeroElementos < maximo) {
            datos[numeroElementos] = letra;
            numeroElementos++;
        } else {
            System.out.println("No se pueden añadir más elementos");
        }
    }

    public void mostrar() {
        int[] indices = new int[numeroElementos];
        for (int i = 0; i < numeroElementos; i++) {
            indices[i] = i + 1;
        }
        mostrar(indices);
    }

    public void mostrar(int[] indices) {
        System.out.println("-----------------------------");
        for (int i = 0; i < indices.length; i++) {
            System.out.println(indices[i] + " " + datos[indices[i] - 1]);
        }
        System.out.println("-----------------------------");
    }

    public void eliminar(char elemento) {
        for (int i = 0; i < numeroElementos; i++) {
            if (datos[i] == elemento) {
                for (int j = i; j < numeroElementos - 1; j++) {
                    datos[j] = datos[j + 1];
                }
                numeroElementos--;
                i--;
            }
        }
    }
}