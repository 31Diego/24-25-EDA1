package entregas.martinezDiego.reto003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Compresor {

    public static class ResultadoCompresion {

        List<String> salida;
        Map<Integer, String> diccionario;

        public ResultadoCompresion(List<String> salida, Map<Integer, String> diccionario) {
            this.salida = salida;
            this.diccionario = diccionario;
        }

        @Override
        public String toString() {
            return "Salida: " + salida.toString() + "\nDiccionario: " + diccionario.toString();
        }
    }

    public static ResultadoCompresion comprimir(String cadena) {

        Map<String, Integer> diccionario = new HashMap<>();
        int tamanoDiccionario = 1;

        List<String> salida = new ArrayList<>();
        StringBuilder prefijo = new StringBuilder();

        for (char caracter : cadena.toCharArray()) {

            String prefijoMasCaracter = prefijo.toString() + caracter;

            if (diccionario.containsKey(prefijoMasCaracter)) {
                prefijo.append(caracter);
            } else {

                if (prefijo.length() > 0) {
                    int indice = diccionario.getOrDefault(prefijo.toString(), 0);
                    salida.add("(" + indice + "," + caracter + ")");
                } else {
                    salida.add("(0," + caracter + ")");
                }

                diccionario.put(prefijoMasCaracter, tamanoDiccionario++);
                prefijo = new StringBuilder(String.valueOf(caracter));
            }
        }

        if (prefijo.length() > 0) {
            salida.add("(" + diccionario.getOrDefault(prefijo.toString(), 0) + ",)");
        }

        Map<Integer, String> diccionarioFinal = new HashMap<>();

        for (Map.Entry<String, Integer> entrada : diccionario.entrySet()) {
            diccionarioFinal.put(entrada.getValue(), entrada.getKey());
        }

        return new ResultadoCompresion(salida, diccionarioFinal);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la cadena original para comprimir: ");
        String cadena = scanner.nextLine();

        ResultadoCompresion resultado = comprimir(cadena);

        System.out.println("\n--- Resultados ---");
        System.out.println("Cadena original: " + cadena);
        System.out.println("Diccionario final: " + resultado.diccionario);
        System.out.println("Cadena comprimida: " + resultado.salida);
    }
}