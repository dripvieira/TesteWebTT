#language: pt
# encoding: UTF-8
# author: Caique Walter
# Date: 20/09/2023
# version: 1.0

Funcionalidade: Realizar asserção de estoque após exclusão de faturas geradas por meio de pedido de vendas assistidas
  Com essa funcionalidade iremos conseguir dar entrada em um pedido de vendas assistidas, emissão fatura, excluir a nota no faturamento e realizar a asserção do estorno de estoque

  Como um usuário logado na aplicação
  Eu quero inserir os dados do pedido de vendas assistidas e emitir nota no faturamento
  Para cancelar a nota no faturamento e validar estorno dos produtos no estoque

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

    E coletar a quantidade em estoque

  @Smoke_test @ExclusaoFaturaAssercaoEstoque @VendasAssistidas
  Esquema do Cenário: Realizar asserção de estoque após exclusão de faturas
    Quando acessar a tela de Vendas Assistidas
    E criar uma nova venda no vendas assistida
      | Destinatário   | Produto   | Quantidade   | Frete   |
      | <Destinatário> | <Produto> | <Quantidade> | <Frete> |
    E enviar nota ao faturamento
    E emitir nota de vendas assistidas no faturamento
    E visualizar a quantidade em estoque após exclusão da fatura
      | Quantidade   |
      | <Quantidade> |
    E excluir a nota no faturamento
    Então deve visualizar quantidade baixada em estoque!
    Exemplos:
      | Destinatário | Produto | Quantidade | Frete |
      | 2923         | 20000   | 3          | 10    |

