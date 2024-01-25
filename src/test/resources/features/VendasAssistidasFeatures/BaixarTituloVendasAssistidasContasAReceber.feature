#language: pt
# encoding: UTF-8
# author: Caique Walter
# Date: 17/07/2023
# version: 1.0

Funcionalidade: Emitir pedido de vendas assistidas, emitir uma fatura e realizar a asserção do título no módulo contas à receber
  Com essa funcionalidade iremos conseguir, gerar um pedido de vendas emitir uma NF no faturamento e realizar a asserção do título em contas a receber

  Como um usuário logado na aplicação
  Eu quero inserir os dados do Pedido de vendas assistidas
  Para baixar um ttulo financeiro no módulo contas a receber

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |


  @Smoke_test @TituloContasReceberVendas @VendasAssistidas
  Esquema do Cenário: Realizar Pedido de Vendas Assistidas, emitir uma fatura e realizar a asserção do título no módulo contas à receber
    Quando acessar a tela de Vendas Assistidas
    E criar uma nova venda no vendas assistida
      | Destinatário   | Produto   | Quantidade   | Frete   |
      | <Destinatário> | <Produto> | <Quantidade> | <Frete> |
    E enviar nota ao faturamento
    E emitir nota de vendas assistidas no faturamento
    E entrar no módulo contas à receber
    E consultar o titulo no contas a receber
    Então deve visualizar os dados do título
    Exemplos:
      | Destinatário | Produto | Quantidade | Frete |
      | 2923         | 20000   | 3          | 10    |

