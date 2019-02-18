# Invillia recruitment challenge

## Considerações

* Na especificação das regras de negócio não ficou claro o papel do atributo **status** nas classes **Order** e **Payment**
* Foi utilizado O banco de dados de memória H2, porém a idéia seria utilizar um banco de dados mais robusto dentro de um container Docker.
* Segurança não foi implementada
* A idéia seria confirgurar os serviços em containers Docker utilizando o Docker Swarm para orquestração dos containers.
* Foi utilizado o plugin SonarLint para eclipse para manter escrita de um código mais limpo.
