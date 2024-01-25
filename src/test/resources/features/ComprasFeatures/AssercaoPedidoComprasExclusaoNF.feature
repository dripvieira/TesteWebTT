#language: pt
# encoding: UTF-8
# author: Caique Walter
# Date: 31/08/2023
# version: 1.0

Funcionalidade: Asserção pedidos de compras após exclusão de nota fiscal no recebimento
  Com essa funcionalidade iremos conseguir criar um pedido de compras inclui-lo a nota fiscal, excluir a mesma no livro fiscal e fazer asserção do status do pedido

  Como um usuário logado na aplicação
  Eu quero inserir os dados do pedido
  Para registrar a entrada o pedido de compras e fazer a asserção

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |
    E acessar a página pedido de compras


  @Smoke_test @Pedido_de_compras_assercao_exclusao @Recebimento @Compras
  Esquema do Cenário: Validar pedido de compras após exclusão de livro fiscal
    Quando estiver na página de incluir pedido de compras
    E registrar novo pedido
      | Codigo_produto_pedido   | Quantidade_produto_pedido   |
      | <Codigo Produto Pedido> | <Quantidade produto pedido> |
    E confirmar o registro
    E estiver na tela de Gerenciamento de Notas Fiscais
    E inserir os dados da Nota Fiscal
      | Emitente   | Data   | Natureza_da_Operação   | Número_NF   | Série_NF   | Modelo_Documento_Fiscal   | Chave_NFE   | Valor_Total   | Código_Produto   | Quantidade_produto   | Preço_produto   | Quantidade_Romaneio   | Validade_Romaneio   |
      | <Emitente> | <Data> | <Natureza da Operação> | <Número NF> | <Série NF> | <Modelo Documento Fiscal> | <Chave NFE> | <Valor Total> | <Código Produto> | <Quantidade produto> | <Preço produto> | <Quantidade Romaneio> | <Validade Romaneio> |
    E  inserir os dados do romaneio
      | Quantidade_Romaneio   | Validade_Romaneio   |
      | <Quantidade Romaneio> | <Validade Romaneio> |
    E inserir o  pedido
      | Quantidade_pedido   |
      | <Quantidade Pedido> |
    E criticar a entrada de NF
    E validar a entrada de NF
    E deve visualizar o status no meio do processo de pedido "Baixado"
    E excluir NF no livro fiscal
    Então deve visualizar o status de pedido "Pendente"
    Exemplos:
      | Codigo Produto Pedido | Quantidade produto pedido | Emitente | Data     | Natureza da Operação | Número NF | Série NF | Modelo Documento Fiscal | Chave NFE                                    | Valor Total | Código Produto | Quantidade produto | Preço produto | Quantidade Romaneio | Validade Romaneio | Quantidade Pedido |
      | 20000                 | 3                         | 2059     | 23062023 | 3                    |           | 23       | 01                      | 11112222333344445555666677778888999900001111 | 36,00       | 20000          | 3                  | 12,00         | 3                   | 31012024          | 3                 |


