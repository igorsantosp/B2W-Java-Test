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
        int numero = leia.nextInt();                                            // Entrada: Número qual se quer descobrir as combinações possíveis sem zeros à esquerda
        String numeros = String.valueOf(numero);                                // Transformando a entrada em String
        String numeros2 = numeros;                                              // Cópia da entrada
        int tamanho = numeros.length();                                         // Obtendo a quantidade total de digitos
        int zeros = 0;                                                          // Variável que armazenará a quantidade total de zeros
        int repetidos = 0;                                                      // Variável que armazenará a quantidade de números repetidos                                                                
        for (int i = 0; i < tamanho; i++) {                                     // Loop que conta a quantidade de zeros e números repetidos
            if (numeros.charAt(i) == '0') {
                zeros++;                                                        // Se o catactere atual for '0' incrementa o contador de zeros 
            } else {
                if (numeros2.contains(String.valueOf(numeros.charAt(i)))) {
                    if (numeros2.indexOf(numeros2.charAt(i)) != i) {            // Se o caractere atual não for '0' e há uma correspondencia dele num index diferente do atual,
                        repetidos++;                                            // repetidos é incrementado
                    }
                }
            }
        }
                                                                                // Nesse ponto do código já temos as informações da quantidade de digitos, zeros e números repetidos
                                                                                // Com essas informações abstraimos uma formula baseada em permutação matemática
        int combinacao = tamanho - zeros - repetidos;                           // O primeiro termo do "fatorial" que nos dá a resposta é sempre tamanho - quantidade de zeros - quantidade de números repetidos
        if (combinacao > 1 || (repetidos > 0 && repetidos<tamanho-1)) {
            if (zeros >= 1) {                                                   // A quantidade de iterações para quando o numero tem algum digito 0 é diferente para quando não tem, por isso separei em ifs e loops diferentes
                for (int i = tamanho - 1; i >= zeros; i--) {                    // Iteração correspondente à quando há zeros no número (tamanho-zeros-repetidos)*(tamanho-1) ...
                    combinacao *= i;
                    i--;
                }
            } else {
                for (int i = tamanho - 1; i >= 1; i--) {                        //Quando não há zeros, a itereção do fatorial comum deve se dar normalmente, alterando apenas o primeiro termo a depender de quanto numeros repetidos há, (tamanho-repetidos)*(tamanho-1)*(tamanho-2)... 
                    combinacao *= i;                                            
                    i--;
                }
            }
        }
        System.out.println(String.valueOf(combinacao));                         // Resposta final equivalente à quantidades de números diferentes gerados pela entrada, desconsiderando combinações com números iguais e números com 0 à esquerda
    }
    
}

