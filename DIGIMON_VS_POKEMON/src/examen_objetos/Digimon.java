/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_objetos;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author chch5500
 */
public class Digimon {

    private String name;
    private int lifePoints;
    private boolean shield;

    public Digimon(String name) {
        this.name = name;
        this.lifePoints = 600;
        this.shield = true;
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;

    }

    public boolean isShield() {
        return shield;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    //METODOS
    //Metodo para cambiar el nombre del digimon
    public void CambiarNombre() {
        Scanner imput = new Scanner(System.in);
        System.out.printf("Nombre actual: %s\n", name);
        System.out.println("Nuevo nombre: ");
        String nuevo_nombre = imput.next();
        System.out.println("");
        name = nuevo_nombre;
    }
    //Mostrar nombre
    public void mostrarName() {
        System.out.printf("Nombre del digimon: %s", name);
    }
    //Mostrar puntos de vida
    public void mostrarLifePoints() {
        System.out.printf("Puntos de vida: %d", lifePoints);
    }
    //Mostrar si el escudo esta activo o no
    public void mostrarEscudo() {
        if (shield) {
            System.out.println("Escudo activado");
        } else {
            System.out.println("Escudo desactivado");
        }

    }
    //Mostrar todos los datos
    public void mostrar() {
        if (lifePoints < 100) {
            System.out.printf("A %s le quedan %d puntos de vida\n", name, lifePoints);
            System.out.println("Esta a punto de morir");
        } else {
            System.out.printf("A %s le quedan %d puntos de vida\n", name, lifePoints);
        }

    }
    
    public String toString() {

        if (shield) {
            return "Digimon: " + name + "\nVida: " + lifePoints + "\nEscudo:Activado\n";
        } else {
            return "Digimon: " + name + "\nVida: " + lifePoints + "\nEscudo:Desactivado\n";
        }

    }
    //Metodo de recibir ataque del digimon
    public boolean recibirAtaque(int ataque) {
        if (shield) {
            shield = false;
            System.out.println("El escudo se ha desactivado");
            return true;
        } else {
            lifePoints = lifePoints - ataque;
            if (lifePoints <= 0) {
                lifePoints = 0;
                return false;
            } else {
                return true;
            }
        }
    }
    //Metodo para retornar el valor de ataque del digimon
    public int ataque() {
        Random rnd = new Random();
        int ataque = rnd.nextInt(30, 201);
        System.out.printf("%s ataca con una fuerza de %d\n", name, ataque);
        return ataque;
    }
}
