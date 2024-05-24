/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_objetos;

import java.util.Scanner;

/**
 *
 * @author chch5500
 */
public class Main {

    public static void main(String[] args) {
        Scanner imput = new Scanner(System.in);
        String name_pokemon;
        String name_digimon;
        int lifepoints_pokemon;
        int ataque_pokemon;
        int ataque_digimon = 0;
        boolean gana_pokemon = true;
        boolean gana_digimon = true;
        int turnos = 0;
        
        //Creacion del pokemon
        System.out.println("Creando pokemon...");
        System.out.println("Nombre del pokemon:");
        name_pokemon = imput.next();
        System.out.println("Puntos de vida de pokemon:");
        System.out.println("1000 puntos maximo");
        lifepoints_pokemon = imput.nextInt();
        if (lifepoints_pokemon > 1000) {
            System.out.println("Se han asignado 1000 puntos de vida al pokemon");
        }
        Pokemon A = new Pokemon(name_pokemon, lifepoints_pokemon);
        System.out.println("");
        //Mostramos los datos
        System.out.println(A);

        //Creacion digimon
        System.out.println("Creando digimon...");
        System.out.println("Nombre del digimon:");
        name_digimon = imput.next();
        Digimon B = new Digimon(name_digimon);
        System.out.println("");
        //Mostramos los datos
        System.out.println(B);
        do {
            //Creamos bucle
            ataque_pokemon = A.atacar();
            gana_pokemon = B.recibirAtaque(ataque_pokemon);
            //Colocamos if por si los puntos de vida del digimon han llegado a 0 no pueda atacar ya que estaria debilitado
            if (gana_pokemon == false) {
                System.out.printf("A %s le quedan %d puntos de vida\n", B.getName(), B.getLifePoints());
                System.out.println("");
                turnos++;
                break;
            }
            B.mostrar();
            System.out.println("-----------------------------------");
            ataque_digimon = B.ataque();
            gana_digimon = A.recibirAtaque(ataque_digimon);
            A.mostrar();
            System.out.println("-----------------------------------");
            turnos ++;
            //Condicion del while es que los dos sigan vivos
        } while (gana_pokemon == true && gana_digimon == true);
        //Mensaje por si gana el pokemon
        if (gana_pokemon == false) {
            System.out.printf("Ha ganado %s despues de %d turnos\n", A.getName(),turnos);
        //Mensaje por si gana el digimon
        } else if (gana_digimon == false) {
            System.out.printf("Ha ganado %s despues de %d turnos\n", B.getName(),turnos);

        }

    }
}
