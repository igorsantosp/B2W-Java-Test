# B2W-Java-Test
Teste de Lógica de Programação em Java

# Comando da questão:
You need to count the numbers that can be created by rearranging the digits of a positive Integer N (0<N<1000000000 and it has no leading zeros).
Example: There are 6 numbers that can be created by rearranging the digits of 432 and there are 4 numbers that can be formed from the number 120 (you must disconsider numbers with leading zeros).
The code must be written in Java 8.

Em resumo, contar as combinações possíveis de números com os dígitos de um dado número de entrada. Números com 0 à esquerda devem ser desconsiderados.

# Resolução:
Uma das formas de resolver parece ser encontrar uma variação de fórmula simples de análise combinatória, por tanto conclui que pensando em alguma fórmula de análise combinatória conseguiria resolver a questão sem precisar necessariamente gerar todas as combinações possíveis e excluir os casos não desejados, já que, dependendo da quantidade de dígitos no número entrada, gerar todas as combinações possíveis pode requerer um processamento muito alto, tornando o algoritmo não ótimo.   
A quantidade de combinações dada por uma entrada em que todos os números são diferentes entre si e diferentes de 0 é dada por N! (fatorial simples) sendo N a quantidade de dígitos no número. A partir desta fórmula simples tentei generalizar uma fórmula para quando apareçam zeros e números iguais dentre os dígitos do número de entrada.
Percebi que a quantidade de zeros e número iguais impacta diretamente no primeiro termo do fatorial e na quantidade de iterações que o fatorial deve realizar para retornar a resposta correta.
Percebi que o primeiro termo do fatorial é sempre representado por: **Número de dígitos total - Número de zeros - Quantidade de Repetições de número**   
No caso de não haver zeros ou números repetidos, o primeiro termo do fatorial é sempre igual à quantidade de dígitos no número.   
A partir dessa observação criei um código que consegue contar a quantidade de dígitos e de zeros no número de entrada, além da quantidade de vezes que acontece uma repetição de qualquer número, com essas informações o código pode tomar dois tipos de loops diferentes. Um para fatorial simples e outro para quando há zeros.   

## Entradas testadas:
120   (Três dígitos e um zero).   
432   (Três dígitos, sem zeros ou repetições).  
1000  (Quatro dígitos, três zeros).   
1200  (Quatro dígitos, dois zeros).   
12000 (Cinco dígitos, três zeros).   
11000 (Cinco dígitos, dois zeros e dois dígitos repetidos).   
1122  (Quatro dígitos, duas repetições).   
1111  (Quatro dígitos, três repetições).   

Todos os testes retornaram a resposta esperada.   
Utilizei variáveis do tipo int já que em java o valor máximo armazenado ultrapassa dois bilhões, a entrada é prevista de ser menor que um bilhão e o maior número de combinações possível é 10!=3.628.800
