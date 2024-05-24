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
public class Pokemon {

    private String name;
    private int lifePoints;
    private int combatPoint;

    public Pokemon(String name, int lifePoints) {
        //Condicionamos el constructor para que si el enter de vida es mayor a 1000 se construya con 1000
        //Los puntos de combate son aleatorios
        Random rnd = new Random();
        if (lifePoints > 1000) {
            this.name = name;
            this.lifePoints = 1000;
            this.combatPoint = rnd.nextInt(100, 201);
        } else {
            this.name = name;
            this.lifePoints = lifePoints;
            this.combatPoint = rnd.nextInt(100, 201);
        }

    }

    public String toString() {
        return "Pokemon: " + name + "\nVida: " + lifePoints + "\nPuntos de combate: " + combatPoint + "\n";
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getCombatPoint() {
        return combatPoint;
    }

    //SETTERS
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setCombatPoint(int combatPoint) {
        this.combatPoint = combatPoint;
    }

    //METODOS
    //Mostrar nombre
    public void mostrarName() {
        System.out.printf("Nombre del digimon: %s", name);
    }

    //Mostrar puntos de vida
    public void mostrarLifePoints() {
        System.out.printf("Puntos de vida: %d", lifePoints);
    }
    //Mostrar puntos de combate
    public void mostrarCombatPoints() {
        System.out.printf("Puntos de combate %d", combatPoint);
    }

    //Metodo para mostrar datos del pokemon
    public void mostrar() {
        System.out.printf("A %s le quedan %d puntos de vida\n", name, lifePoints);
    }

    //Metodo para generar de nuevo los puntos de combate del pokemon
    public void cambiarCombatPoints() {
        Random rnd = new Random();
        combatPoint = rnd.nextInt(100, 201);
        System.out.printf("Tu pokemon ahora tiene %d puntos de combate", combatPoint);
    }

    //Metodo critCombat privado para que solo se pueda acceder desde este documento
    private void critCombat(int ataque) {
        System.out.printf("%s ataca con una fuerza de %d\n", name, ataque);
    }

    //Metodo para que el pokemon reciba el ataque
    public boolean recibirAtaque(int ataque) {
        lifePoints = lifePoints - ataque;
        if (lifePoints <= 0) {
            lifePoints = 0;
            return false;
        } else {
            return true;
        }
    }

    //Metodo para calcular el numero de ataque del pokemon
    public int atacar() {
        if (lifePoints < 100) {
            combatPoint = combatPoint * 2;
            critCombat(combatPoint);
            return combatPoint;
        } else {
            critCombat(combatPoint);
            return combatPoint;
        }

    }
}
