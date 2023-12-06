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

            Object nuevo_objeto = entity.getDeclaredConstructor().newInstance();

            Class<?> claseActual = entity;
            while (claseActual != null) {
                Field[] columnas = claseActual.getDeclaredFields();
                for (Field columna : columnas) {
                    if (!"id".equals(columna.getName())) {
                        System.out.println("Ingrese el valor para " + columna.getName() + ":");
                        Object valor = obtenerValorCampo(scanner, columna);
                        columna.setAccessible(true);
                        columna.set(nuevo_objeto, valor);
                    }
                }
                claseActual = claseActual.getSuperclass();
            }
            
            System.out.println(nuevo_objeto.toString());

            entityManager.getTransaction().begin();
            entityManager.persist(nuevo_objeto);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void delete(EntityManager entityManager, Class<?> entity) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el valor para id:");
            int id = scanner.nextInt();

            Object objeto_eliminar = entityManager.find(entity, id);

            if (objeto_eliminar != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(objeto_eliminar);
                entityManager.getTransaction().commit();
                System.out.println("Eliminado exitosamente");
            } else {
                System.out.println("No se encontro el objeto con el ID");
            }
        } catch (Exception e) {

        }
    }

    public static void update(EntityManager entityManager, Class<?> entity) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el valor para id:");
            int id = scanner.nextInt();

            Object objeto_modificar = entityManager.find(entity, id);

            if (objeto_modificar != null) {
                Class<?> claseActual = entity;
                while (claseActual != null) {
                    Field[] campos = claseActual.getDeclaredFields();

                    for (Field campo : campos) {
                        if (!"id".equals(campo.getName())) {
                            campo.setAccessible(true);

                            System.out.println("Ingrese el nuevo valor para " + campo.getName() + ":");
                            Object nuevoValor = obtenerValorCampo(scanner, campo);
                            campo.set(objeto_modificar, nuevoValor);
                        }
                    }

                    claseActual = claseActual.getSuperclass();
                }

                entityManager.getTransaction().begin();
                entityManager.merge(objeto_modificar);
                entityManager.getTransaction().commit();

                System.out.println("Entidad modificada correctamente");
            } else {
                System.out.println("No se encontró el objeto con el ID");
            }
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
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
