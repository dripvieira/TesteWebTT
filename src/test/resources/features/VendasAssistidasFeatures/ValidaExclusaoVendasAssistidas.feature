#language: pt
# encoding: UTF-8
# author: Caique Walter
# Date: 14/09/2023
# version: 1.0

Funcionalidade: Emitir pedido de vendas assistidas, emitir uma fatura, exluir fatura e realizar a asserção do título no módulo vendas assistidas
  Com essa funcionalidade iremos gerar uma fatura atrávés do vendas assistida, excluir excluir a nota no faturamento e realizar a asserção do título no módulo vendas assistidas

  Como um usuário logado na aplicação
  Eu quero inserir os dados do Pedido de vendas assistidas
  Para gerar uma fatura, posteriormente baixa-la e realizar a asserção do título no módulo vendas assistida

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

  @Smoke_test @ExclusaoValidaVendasAssistidas @VendasAssistidas

  Esquema do Cenário: Realizar Pedido de Vendas Assistidas, emitir uma fatura e realizar a asserção do pedido no modulo vendas assistidas
    Quando acessar a tela de Vendas Assistidas
    E criar uma nova venda no vendas assistida
      | Destinatário   | Produto   | Quantidade   | Frete   |
      | <Destinatário> | <Produto> | <Quantidade> | <Frete> |
    E enviar nota ao faturamento
    E emitir nota de vendas assistidas no faturamento
    E excluir a nota no faturamento
    E entrar no módulo vendas assitidas
    Então deve visualizar o status "Cancelado"
    #Este cenário se encontra sob análise junto aos gestores pois o status do pedido de vendas não é alterado após exclusão da NF no faturamento. CH 0035313

    Exemplos:
      | Destinatário | Produto | Quantidade | Frete |
      | 2923         | 20000   | 3          | 10    |

