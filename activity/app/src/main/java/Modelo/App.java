/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Modelo;

import Clases.Persona;
import DAO.DAO;
import java.util.Date;
import java.util.Scanner;
import javax.persistence.EntityManager;

public class App {

    public static void main(String[] args) {
        ConexionOBD conexionOBD = new ConexionOBD("miUnidadPersistencia");

        try {
            EntityManager entityManager = conexionOBD.getEM();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Seleccione una opción:");
            System.out.println("1. Insertar Persona");
            System.out.println("2. Eliminar Persona");
            System.out.println("3. Modificar Persona");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    DAO.insertar(entityManager, Persona.class);
                    break;
                case 2:
                    // Lógica para eliminar persona
                    break;
                case 3:
                    // Lógica para modificar persona
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            entityManager.close();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
