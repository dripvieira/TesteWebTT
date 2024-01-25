#language: pt
# encoding: UTF-8
# author: Caique Walter
# Date: 17/07/2023
# version: 1.0

Funcionalidade: Realizar a asserção de saldo do cliente a partir do pedido de vendas assistidas
  Com essa funcionalidade iremos conseguir gerar um pedido de vendas, emitir uma NF no faturamento e realizar a asserção do saldo do cliente

  Como um usuário logado na aplicação
  Eu quero inserir os dados do Pedido de vendas assistidas
  Para realizar a contabilização do saldo cliente

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |


    E visualizar saldo inicial do cliente

  @Smoke_test @SaldoClienteVendasAssistidas @VendasAssistidas
  Esquema do Cenário: Realizar Pedido de Vendas Assistidas e asserção do saldo do cliente
    Quando acessar a tela de Vendas Assistidas
    E criar uma nova venda no vendas assistida
      | Destinatário   | Produto   | Quantidade   | Frete   |
      | <Destinatário> | <Produto> | <Quantidade> | <Frete> |
    E enviar nota ao faturamento
    E emitir nota de vendas assistidas no faturamento
    E visualizar saldo pos Venda
    E entrar no módulo contas à receber
    E baixar titulo financeiro
    E entrar na página manutenção de clientes
    Então deve visualizar valor do saldo final do cliente!

    Exemplos:
      | Destinatário | Produto | Quantidade | Frete |
      | 16           | 20000   | 3          | 10,00 |
