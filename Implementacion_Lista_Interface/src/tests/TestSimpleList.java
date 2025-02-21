package tests;

import models.Persona;
import structures.SimpleList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestSimpleList {
    public static void main(String[] args) {
        SimpleList<Persona> lista = new SimpleList<>();
        System.out.println("\nPRUEBAS DE METODOS SERGIO \n\n");

        lista.add(new Persona("Juan", 25));
        printList(lista);

        lista.add(new Persona("Ana", 30));
        lista.add(new Persona("Carlos", 40));
        lista.add(new Persona("Elena", 22));
        printList(lista);

        lista.add(1, new Persona("Miguel", 28));
        printList(lista);

        lista.add(0, new Persona("Lucía", 35));
        printList(lista);

        lista.add(lista.size(), new Persona("Pedro", 27));
        printList(lista);

        try {
            lista.add(10, new Persona("Invalido", 99));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error esperado: " + e.getMessage() + "\n");
        }

        List<Persona> nuevos = Arrays.asList(new Persona("David", 33), new Persona("Sofía", 29));
        lista.addAll(nuevos);
        printList(lista);

        List<Persona> intermedios = Arrays.asList(new Persona("Andrés", 26), new Persona("Paula", 31));
        lista.addAll(3, intermedios);
        printList(lista);

        try {
            lista.addAll(null);
        } catch (NullPointerException e) {
            System.out.println("Error esperado: " + e.getMessage() + "\n");
        }

        boolean resultado = lista.addAll(new ArrayList<>());
        System.out.println("Resultado esperado: false, Resultado obtenido: " + resultado + "\n");
    }

    private static void printList(SimpleList<Persona> lista) {
        Iterator<Persona> it = lista.iterator();
        System.out.print("  >  " + "[");
        while (it.hasNext()) {
            System.out.print(it.next());
            if (it.hasNext()) System.out.print(", ");
        }
        System.out.println("] \n");
    }
}
