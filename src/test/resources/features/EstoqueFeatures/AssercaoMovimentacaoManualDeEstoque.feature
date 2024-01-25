#language: pt
# encoding: UTF-8
# author: Caíque W.
# Date: 06/10/2023
# version: 1.0

Funcionalidade: Validar movimentação manual de estoque
  Com essa funcionalidade iremos conseguir realizar a movimentação manual de estoque e validar se a quantidade foi debitada corretamente do estoque

  Como um usuário logado na aplicação
  Eu quero realizar movimentação manual de estoque
  Para validar a quantidade em estoque pós movimentção

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |


  @Smoke_test @MovimentacaoDeEstoque @Estoque
  Esquema do Cenário: Validar movimentação manual de estoque
    Quando resgatar quantidade inicial de estoque
      | Produto   | Loja   |
      | <Produto> | <Loja> |
    E estiver na tela de movimentação de estoque
    E gerar movimentação de estoque
      | Processo   | Quantidade   | Produto   | Operações   |
      | <Processo> | <Quantidade> | <Produto> | <Operacoes> |
    E resgatar quantidade em estoque pós movimentação
      | Produto   |
      | <Produto> |
    Então realizar a asserção da quantidade em estoque
      | Quantidade   | Processo   | Operações   |
      | <Quantidade> | <Processo> | <Operacoes> |
    Exemplos:
      | Processo | Quantidade | Produto | Operacoes |
      | Quebra   | 3          | 20000   | -         |
      | Ajuste   | 5          | 20000   | -         |
      | Ajuste   | 10         | 20000   | +         |

