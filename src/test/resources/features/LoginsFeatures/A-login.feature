#language: pt
#encoding: UTF-8
#author: Adriano Vieira
#date: 10/05/2023
#version: 1.0

@Smoke_test @login
Funcionalidade: Login
  Com essa aplicação iremos conseguir realizar o login na aplicação com um usuário já cadastrado

  Como um usuário já cadastrado na aplicação
  Eu quero inserir meus dados cadastrais
  Para realizar o login na aplicação

  Contexto: Entrar na tela de login
    Dado estiver na tela de login

  @Smoke_test @LoginAplicacao
  Cenário: validar o login na aplicação
    Quando inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |
    Então deve visualizar o nome "Usuário: ADM"


  @Smoke_test @LoginIncorreto
  Esquema do Cenário: validar a mensagem de erro ao inserir dados incorretos
    Quando inserir os dados incorretos do usuário
      | login           | senha   |
      | <dados_usuário> | <senha> |
    Então deve visualizar a mensagem de erro "Usuário e/ou senha inválidos"

    Exemplos:
      | dados_usuário | senha      |
      | adm@          | tit@n_2006 |
      | adm           | tit@n_2007 |
