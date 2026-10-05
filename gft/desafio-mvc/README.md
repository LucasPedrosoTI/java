# Projeto MVC

## Dados de acesso para teste:

- e-mail: admin@gft.com, senha: 123456
- e-mail: user@gft.com, senha: 123456

## Objetivo:

Aplicar os conceitos MVC aprendidos durante as semanas de estudo.

## Escopo:

Criar um sistema para gerenciar funcionários GFT em WA (Sem alocação).

## Tecnologias utilizadas:

1. Spring Boot.
2. Spring MVC.
3. Spring Data JPA.
4. Thymeleaf.

## Telas da aplicação

### Home: http://localhost:8080/wa

- Esta tela, deverá possuir um botão que popule a base de dados.

### Listar Funcionário: http://localhost:8080/wa/funcionarios

- Nesta tela, deverá ser exibida a listagem de funcionários que constam em WA.
- Deve se implementar um sistema de busca/filtro.
- Criar um botão que redireciona para uma tela de cadastro de
  Funcionário.
- Implementar paginação da listagem (desafio bônus).
- Caso não possuir funcionário em WA, exibir uma mensagem “Nenhum
  funcionário cadastrado no sistema.”

### Cadastrar Funcionário: http://localhost:8080/wa/funcionarios/cadastrar

- Nesta tela, deverá ser implementado o cadastro de um Funcionário no
  sistema de WA.
- Deve se aplicar validações, não aceitar campos em branco ou entrada de
  dados inválidos.
- Após cadastrar, redirecionar para tela de pesquisa de Funcionários.
- Obs: Modelo de dados no final do documento.

### Listar Vagas: http://localhost:8080/wa/vagas

- Nesta tela, deverá ser exibida a listagem de vagas disponíveis.
- Deve se implementar um sistema de busca/filtro.
- Criar um botão que redireciona para uma tela de cadastro de Vagas.
- Implementar paginação da listagem (desafio bônus).
- Caso não possuir Vagas, exibir uma mensagem “Nenhuma vaga
  cadastrada no sistema.”

### Cadastrar Funcionário: http://localhost:8080/wa/vagas/cadastrar

- Nesta tela, deverá ser implementado o cadastro de uma vaga no sistema
  de WA.
- Deve se aplicar validações, não aceitar campos em branco ou entrada de
  dados inválidos.
- Após cadastrar, redirecionar para tela de pesquisa de vagas.
- Obs: Modelo de dados no final do documento.

### Alocar em projeto: http://localhost:8080/wa/alocar

- Nesta tela, deverá ser implementada uma lógica para alocar um
  funcionário em uma vaga (implementar o modelo de dados para esta
  lógica).
- Após ser alocado, o funcionário deverá ser removido da lista de
  “Funcionários em WA”.
- Caso a vaga possua uma quantidade maior que 1, deverá diminuir após a
  alocação de um funcionário, caso a vaga tenha apenas quantidade = 1,
  deverá ser removida da listagem.

### Histórico: http://localhost:8080/wa/historico

- Nesta tela, deverá ser exibida a relação de funcionários alocados,
  detalhando o cliente e a vaga no qual o funcionário foi alocado.
- Deve se implementar um sistema de busca/filtro.
- Implementar paginação da listagem (desafio bônus).

## Desafio Bônus:

1. Implementar login utilizando Spring Security.

- Login:
- Cadastro:

2. Implementar funcionalidades de acordo com a “role”.

- Se o usuário possuir role de “user”, ele apenas poderá visualizar os
  funcionários e vagas.
- Se o usuário possuir role de “admin”, ele terá acesso total, podendo
  cadastrar, deletar e atualizar dados de funcionários, vagas e visualizar
  o histórico de alocação.
