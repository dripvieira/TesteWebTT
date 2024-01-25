#language: pt
# encoding: UTF-8
# author: Caíque W.
# Date: 05/10/2023
# version: 1.0

Funcionalidade: Validar movimentação automática de estoque  pelo inventário
  Com essa funcionalidade iremos conseguir realizar a movimentação automática de estoque pelo inventário e validar se a quantidade foi debitada corretamente do estoque

  Como um usuário logado na aplicação
  Eu quero realizar movimentação de estoque
  Para validar a quantidade em estoque pós movimentação emitida pelo inventário

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |


  @Smoke_test @MovimentacaoAutomaticaDeEstoque @Estoque
  Esquema do Cenário: Validar movimentação automática de estoque
    Quando estiver na tela de inventário
    E criar um novo inventário
      | Descrição   | Max. Lote   | Produto   | Loja   |
      | <Descrição> | <Max. Lote> | <Produto> | <Loja> |
    E inserir quantidade contada em estoque
      | Produto   | Contador   | Quantidade_Contada   |
      | <Produto> | <Contador> | <Quantidade_Contada> |
#    E gerar nota de movimentação automática
#      | Quantidade_Contada   |
#      | <Quantidade_Contada> |
    Então realizar a asserção da movimentação de estoque autómatica
      | Quantidade_Contada   | Produto   | Loja   |
      | <Quantidade_Contada> | <Produto> | <Loja> |
    Exemplos:
      | Descrição          | Max. Lote | Produto | Contador | Quantidade_Contada | Loja |
      | TESTE AUTOMATIZADO | 999       | 6577374 | 1        | 50                 | 8    |
