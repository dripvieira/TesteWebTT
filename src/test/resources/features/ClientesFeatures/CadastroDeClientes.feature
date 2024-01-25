#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 18/10/2023
# version: 1.0

Funcionalidade: cadastrar cliente
  Com essa funcionalidade iremos conseguir cadastrar um novo cliente
  Como um usuário logado na aplicação
  Eu quero cadastrar um novo cliente
  Para poder dar realizar novas vendas, vendas assistidas e faturas

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

  @Smoke_test @CadastrarCliente @Produtos
  Esquema do Cenário: Validar o cadastramento de clientes
    Quando estiver na tela de manutenção de clientes
    E inserir os dados do cliente
      | Vendedor   | Nome   | Nome_Alternativo   | Telefone_fixo   | Telefone_móvel   | Cod_Convenio   | Condição_Pagto   | Rede_SubRede   | Forma_Pagto   | Limite   | Limite_Disponivel   | Desconto_financeiro%   | Desconto_financeiro$   | Saldo_PrePago   | Web   | Transportadora   | Email   | Data_nasc   | Comentario   | Mensagem   | Tipo   | CEP   | NUMERO   |
      | <Vendedor> | <Nome> | <Nome_Alternativo> | <Telefone_fixo> | <Telefone_móvel> | <Cod_Convenio> | <Condição_Pagto> | <Rede_SubRede> | <Forma_Pagto> | <Limite> | <Limite_Disponivel> | <Desconto_financeiro%> | <Desconto_financeiro$> | <Saldo_PrePago> | <Web> | <Transportadora> | <Email> | <Data_nasc> | <Comentario> | <Mensagem> | <Tipo> | <CEP> | <NUMERO> |
    Então após pesquisar o cliente pelo código gerado, deve visualizar o nome do cliente
      | Nome   |
      | <Nome> |

    Exemplos:
      | Vendedor | Nome               | Nome_Alternativo | Telefone_fixo | Telefone_móvel | Cod_Convenio | Condição_Pagto | Rede_SubRede | Forma_Pagto | Limite  | Limite_Disponivel | Desconto_financeiro% | Desconto_financeiro$ | Saldo_PrePago | Web              | Transportadora | Email                        | Data_nasc  | Comentario         | Mensagem                       | Tipo     | CEP      | NUMERO |
      | 18       | Manuel Cardoso     | Conká            | 1180706050    | 119545496274   | 2            | 30             | 02.01        | 1           | 1000000 | 1000000           | 0                    | 20                   | 0             | site.dominio.com | 2954           | suporte@titansoftware.com.br | 01/01/2005 | TESTE AUTOMATIZADO | Criado pelo teste automatizado | Fisica   | 06412140 | 463    |
      | 18       | Borracharia Dricos | Dricos           | 1140302010    | 119545496274   | 2            | 30             | 01.03        | 1           | 1000000 | 1000000           | 0                    | 20                   | 0             | site.dominio.com | 2954           | suporte@titansoftware.com.br | 12/10/2012 | TESTE AUTOMATIZADO | Criado pelo teste automatizado | Juridica | 06412140 | 1000   |
