#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 21/06/2023
# version: 1.0

Funcionalidade: Registrar pedidos de compras
  Com essa funcionalidade iremos conseguir registrar um pedido de compras

  Como um usuário logado na aplicação
  Eu quero inserir os dados do pedido
  Para registrar a entrada do pedido de compras

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |
    E acessar a página pedido de compras

  @Smoke_test @Pedido_de_compras @Compras
  Cenário: Registrar pedido de compras
    Quando estiver na página de incluir pedido de compras
    E registrar novo pedido
      | Codigo_produto_pedido | Quantidade_produto_pedido |
      | 20000                 | 3                         |
    Então deve visualizar a mensagem "Pedido concluido com sucesso."
