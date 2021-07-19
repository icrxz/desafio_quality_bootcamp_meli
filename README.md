![banner lema do mercado livre](https://media-exp1.licdn.com/dms/image/C4D16AQGfS0oAmsz1CA/profile-displaybackgroundimage-shrink_200_800/0/1614167337659?e=1627516800&v=beta&t=37I3eOgnRWT8N-inY2eorkHOg5z99C0ZyeRa8L8oDkk)

# Desafio Quality, by: Grupo 2.

<p align="justify"> A empresa "Seu Imóvel" precisa ser capaz de calcular a metragem e o custo dos diferentes imóveis que possui em sua carteira de clientes. Para isso, solicita de cada imóvel: um nome do imóvel, um bairro (nome do bairro e valor do metro quadrado no bairro) e a quantidade de cômodos que cada imóvel
tem. Ao mesmo tempo, cada cômodo contém um nome, uma largura e um comprimento.</p>

## Informações Backend
- Tecnologoias utilizadas: 
1. JUnit 5, Java, IntelliJ e Spring Boot;
2. Design Patterns: MVC
3. AWS - EC2 - ([link](http://ec2-18-221-17-176.us-east-2.compute.amazonaws.com:8080/property/calculate-room-m2/1))
4. Documentação e Consumo da API ([link](http://ec2-18-221-17-176.us-east-2.compute.amazonaws.com:8080/swagger-ui.html))

- Procedimentos para rodar local:
1. Clone o repositório desta aplicação pelo terminal do seus sistema operacional, ou realizar o Download no formato zip. e descompactar;
2. Utilizando a IDE de sua preferência (mas que tenha suporte para aplicações SpringBoot);
3. Importar o arquivo "desafio_quality_bootcamp_meli" deste repositório, como arquivo do tipo MAVEN.

## Informações Banco de Dados
- Tecnologoias utilizadas: H2 Console.
- Informações inseridas no Application Properties.
- Criação das tabelas e armazemaneto das informação consumidas da API (no H2 Console).
- Criação de um arquivo data.sql(com dados inseridos para popular o banco).

- Procedimentos para acesso local:
1. Iniciar(run) sua aplicação localmente;
2. Acessar no seu navegador o link "http://localhost:8080/h2-console", click em Test Connection, e depois Connect;
3. Agora já pode explorar o ambiente do Banco de Dados.

### Funcionalidades - Requisitos técnicos funcionais

- US-0001: Calcular a área total de uma propriedade.
- US-0002: Indicar o preço dessa mesma propriedade com base na área total.
- US-0003: Determinar qual é o maior cômodo da propriedade.
- US-0004: Determinar a área de cada cômodo.

### Testes Unitários/Integrais
- Verifica se o total de metros quadrados calculados por propriedade está correto.
- Verifica se o bairro de entrada existe no repositório de bairros.
- Verifica se o maior cômodo foi realmente devolvido.
- Verifica se de fato o total de metros quadrados por cômodo está correto.

### Squad

- Igor Cruz Avelino
- [![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/igor-cruz-avelino/)](https://www.linkedin.com/in/igor-cruz-avelino/)
- [![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/icrxz)](https://github.com/icrxz)

- Jonathan de Paula
- [![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/jonathan-dev-fullstack/)](https://www.linkedin.com/in/jonathan-dev-fullstack/)
- [![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/JCavalcanti-Meli)](https://github.com/JCavalcanti-Meli)

- Marina Pinheiro Fachin
- [![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/marina-pinheiro-fachin/)](https://www.linkedin.com/in/marina-pinheiro-fachin/)
- [![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/mafachin)](https://github.com/mafachin)

- Waschington L. Menezes Filho
- [![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/was-menezes/)](https://www.linkedin.com/in/was-menezes/)
- [![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/WaschingtonMenezes)](https://github.com/WaschingtonMenezes)
