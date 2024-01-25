#language: pt
# encoding: UTF-8
# author: Adriano Pereira
# Date: 17/07/2023
# version: 1.0

Funcionalidade: Realizar asserção contábil através do pedido de vendas assistidas
  Com essa funcionalidade iremos conseguir realizar asserção contábil através do pedido de vendas assistidas

  Como um usuário logado na aplicação
  Eu quero inserir os dados do Pedido de vendas assistidas
  Para o registro contábil no Módulo Contábil

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

  @Smoke_test @PedidoVendasEAssercaoContabil @VendasAssistidas
  Esquema do Cenário: Realizar asserção contábil através do Pedido de Vendas Assistidas
    Quando acessar a tela de Vendas Assistidas
    E criar uma nova venda no vendas assistida
      | Destinatário   | Produto   | Quantidade   | Frete   |
      | <Destinatário> | <Produto> | <Quantidade> | <Frete> |
    E enviar nota ao faturamento
    E emitir nota de vendas assistidas no faturamento
    Então deve acessar os lançamentos no módulo contábil
    E visualizar o lançamento realizado
    Exemplos:
      | Destinatário | Produto | Quantidade | Frete |
      | 16           | 20000   | 3          | 10    |