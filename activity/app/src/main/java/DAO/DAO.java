/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Scanner;
import javax.persistence.EntityManager;

/**
 *
 * @author Fernando
 */
public class DAO {

    public static void insertar(EntityManager entityManager, Class<?> entity) {
        try {

            Scanner scanner = new Scanner(System.in);

            Field[] columnas = entity.getDeclaredFields();
            Object nuevo_objeto = entity.getDeclaredConstructor().newInstance();

            for (Field columna : columnas) {
                if (!"id".equals(columna.getName())) {
                    System.out.println("Ingrese el valor para " + columna.getName() + ":");
                    Object valor = obtenerValorCampo(scanner, columna);
                    columna.setAccessible(true);
                    columna.set(nuevo_objeto, valor);
                }

            }

            entityManager.getTransaction().begin();
            entityManager.merge(nuevo_objeto);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    private static Object obtenerValorCampo(Scanner scanner, Field campo) {
        if (campo.getType() == String.class) {
            return scanner.next();
        } else if (campo.getType() == int.class || campo.getType() == Integer.class) {
            return scanner.nextInt();
        } else if (campo.getType() == long.class || campo.getType() == Long.class) {
            return scanner.nextLong();
        } else if (campo.getType() == Date.class) {
            while (true) {
                System.out.println("Ingrese el valor para " + campo.getName() + " (formato yyyy-MM-dd):");
                String fechaStr = scanner.next();
                try {
                    java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);
                    return fecha;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: Formato de fecha incorrecto. Inténtelo de nuevo.");
                }
            }
        } else if (campo.getType() == char.class || campo.getType() == Character.class) {
            return scanner.next().charAt(0);
        }

        return null;
    }
}
