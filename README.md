# Teste técnico Neogrid - AssemblyLine - Linhas de Montagem

# Sobre o projeto

A aplicação consiste em um input e output de dados. Onde dado um arquivo txt contendo diversas etapas de uma linha de
montagem, é necessário organizá-las e imprimí-las com as seguintes premissas:
 
- A produção tem várias linhas de montagem e cada uma tem os períodos da manhã, almoço e tarde.
- Cada período tem várias etapas do processo de produção. Exceto o horário de almoço.
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

# gerar o executável do projeto 
mvn clean install

# entrar na pasta target para obter o .jar da aplicação 
cd target

# mover o arquivo .jar para o mesmo diretório do arquivo a ser lido

# executar o projeto passando o nome do arquivo como argumento
java -jar AssemblyLineNeogrid-1.0-SNAPSHOT.jar input.txt
```

# O resultado será exibido no console
![assembly-lines](https://github.com/fSantosLima/assetsRepo/blob/main/assembly-lines.PNG)


# OBS: 

é necessário que o input.txt esteja no mesmo diretório do arquivo .jar

# Autor

Fernando Barros dos Santos de Lima

https://www.linkedin.com/in/fernando-santos-de-lima-8a2aa4209/

