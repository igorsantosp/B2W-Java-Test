/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b2w.java;

import java.util.Scanner;

/**
 *
 * @author igors
 */
public class B2WJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Digite o número que deseja obter as combinações sem zeros à esquerda");
        Scanner leia = new Scanner(System.in);
        int numero = leia.nextInt();
        String numeros = String.valueOf(numero);
        String numeros2 = numeros;
        int tamanho = numeros.length();
        int zeros = 0;
        int repetidos = 0;
        for (int i = 0; i < tamanho; i++) {
            if (numeros.charAt(i) == '0') {
                zeros++;
            } else {
                if (numeros2.contains(String.valueOf(numeros.charAt(i)))) {
                    if (numeros2.indexOf(numeros2.charAt(i)) != i) {
                        repetidos++;
                        /* if(i>0){
                    numeros2= numeros2.substring(0, i)+"a"+numeros2.substring(i+1, numeros2.length());
                    }else{
                    numeros2= numeros2.substring(0, i)+"a"+numeros2.substring(i+1, numeros2.length()-1);
                    }*/
                    }
                }
            }
        }
        int combinacao = repetidos == 0 ? tamanho - zeros : tamanho - zeros - (repetidos);
        if (combinacao > 1 || repetidos > 0) {
            if (zeros >= 1) {
                for (int i = tamanho - 1; i >= zeros; i--) {
                    combinacao *= i;
                    i--;
                }
            } else {
                for (int i = tamanho - 1; i >= 1; i--) {
                    combinacao *= i;
                    i--;
                }
            }
        }
        System.out.println(String.valueOf(combinacao));
    }
    
}
