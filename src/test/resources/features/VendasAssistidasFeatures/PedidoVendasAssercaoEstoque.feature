#language: pt
# encoding: UTF-8
# author: Caique Walter
# Date: 12/07/2023
# version: 1.0

Funcionalidade: Realizar asserção de estoque através do pedido de vendas assistidas
  Com essa funcionalidade iremos conseguir dar entrada numa NF no faturamento e a devida baixa no estoque através do pedido de vendas assistidas

  Como um usuário logado na aplicação
  Eu quero inserir os dados do Pedido de vendas assistidas
  Para registrar a nota no faturamento e a baixa dos produtos no estoque

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

    E coletar a quantidade em estoque

  @Smoke_test @PedidoVendas @VendasAssistidas
  Esquema do Cenário: Realizar Pedido de Vendas Assistidas
    Quando acessar a tela de Vendas Assistidas
    E criar uma nova venda no vendas assistida
      | Destinatário   | Produto   | Quantidade   | Frete   |
      | <Destinatário> | <Produto> | <Quantidade> | <Frete> |
    E enviar nota ao faturamento
    E emitir nota de vendas assistidas no faturamento
    Entao deve visualizar a quantidade em estoque!
    Exemplos:
      | Destinatário | Produto | Quantidade | Frete |
      | 16           | 20000   | 3          | 10    |

