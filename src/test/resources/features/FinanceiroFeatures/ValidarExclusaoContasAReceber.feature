#language: pt
# encoding: UTF-8
# author: Caique Walter
# Date: 19/09/2023
# version: 1.0


Funcionalidade: Emitir pedido de vendas assistidas, emitir a fatura, exluir a fatura e realiza a asserção do título no módulo contas à receber
  Com essa funcionalidade iremos gerar uma fatura atrávés do vendas assistida, gerar e excluir a nota no faturamento e realizar a asserção do título em contas à receber


  Como um usuário logado na aplicação
  Eu quero inserir os dados do Pedido de vendas assistidas
  Para gerar uma fatura, posteriormente baixa-la e realizar a asserção do título no módulo contas à receber

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |


  @Smoke_test @VAExclusaoFaturaValidaContasAReceber @VendasAssistidas
  Esquema do Cenário: Realizar Pedido de Vendas Assistidas, emitir e excluir uma fatura e realizar a asserção do título no contas à receber
    Quando acessar a tela de Vendas Assistidas
    E criar uma nova venda no vendas assistida

      | Destinatário   | Produto   | Quantidade   | Frete   |
      | <Destinatário> | <Produto> | <Quantidade> | <Frete> |
    E enviar nota ao faturamento
    E emitir nota de vendas assistidas no faturamento
    E excluir a nota no faturamento
    E entrar no módulo contas à receber
    E consultar o titulo no contas a receber
    Então validar status "E" no titulo contas a receber

    Exemplos:
      | Destinatário | Produto | Quantidade | Frete |
      | 2923         | 20000   | 3          | 10    |

