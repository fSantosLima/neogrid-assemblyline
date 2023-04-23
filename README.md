# Teste técnico Neogrid - AssemblyLine - Linhas de Montagem

# Sobre o projeto

A aplicação consiste em um input e output de dados. Onde dado um arquivo txt contendo diversas etapas de uma linha de
montagem, é necessário organizá-las e imprimí-las com as seguintes premissas:

- O período da manhã começa às 9h e deve terminar até as 12h, para o almoço.
- O período da tarde começa às 13h e deve terminar no horário das atividades de ginástica laboral.
- As atividades de ginástica laboral não poderão ser iniciadas antes das 16h00 e no máximo às 17h00.

## Tecnologias utilizadas:

- Java 8
- JUnit
- AssertJ

# Como executar o projeto

Pré-requisitos: Java 8

```bash
# clonar repositório
git clone https://github.com/fSantosLima/neogrid-assemblyline

# entrar na pasta do projeto 
cd neogrid-assemblyline

# Gerar o executável do projeto 
mvn clean install

# executar o projeto passando o nome do arquivo como argumento
java -jar AssemblyLineNeogrid-1.0-SNAPSHOT.jar input.txt

o resultado será exibido no console
![assembly-lines](https://github.com/fSantosLima/assetsRepo/blob/6a2ffd80304c5030682be2688490ce1e17385fd0/assembly-lines.PNG)

```



# Autor

Fernando Barros dos Santos de Lima

https://www.linkedin.com/in/fernando-santos-de-lima-8a2aa4209/

