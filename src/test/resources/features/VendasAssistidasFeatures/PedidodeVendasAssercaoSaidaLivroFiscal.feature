#language: pt
# encoding: UTF-8
# author: Caique Walter
# Date: 17/07/2023
# version: 1.0

Funcionalidade: Realizar asserção no faturamento a partir do pedido de vendas assistidas
  Com essa funcionalidade iremos conseguir, gerar um pedido de vendas, emitir uma fatura e realizar a asserção no faturamento

  Como um usuário logado na aplicação
  Eu quero gerar um pedido de venda no módulo vendas assistidas
  Para verificar o envio de nota ao faturamento

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |


  @Smoke_test @AssercaoVendasAssistidasNoFaturamento @VendasAssistidas
  Esquema do Cenário: Realizar Pedido de Vendas Assistidas, emitir uma fatura e realizar a asserção no faturamento
    Quando acessar a tela de Vendas Assistidas
    E criar uma nova venda no vendas assistida
      | Destinatário   | Produto   | Quantidade   | Frete   |
      | <Destinatário> | <Produto> | <Quantidade> | <Frete> |
    E enviar nota ao faturamento
    E emitir nota de vendas assistidas no faturamento
    Então deve visualizar a NF emitida no faturamento
    Exemplos:
      | Destinatário | Produto | Quantidade | Frete |
      | 16           | 20000   | 4          | 15    |
