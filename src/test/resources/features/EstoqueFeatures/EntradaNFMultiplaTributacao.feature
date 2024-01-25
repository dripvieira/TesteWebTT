#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 09/10/2023
# version: 1.0

Funcionalidade: Entrada de NF via importação XML com multiplas tributações
  Com essa funcionalidade iremos conseguir gerar uma NF XML no faturamento, fazer a importação do XML no recebimento com diversos produtos de diferentes tributações.
  Como um usuário logado na aplicação
  Eu quero gerar uma nota XML no faturamento e realizar a importação no recebimento com diversos produtos de diferentes tributações.
  Para registrar a entrada da NF com mútiplas tributações

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

  @Smoke_test @EntradaMultiplaTributacao @Recebimento
  Cenário: Gerar um NF XML no faturamento e realizar a importação da NF com mútiplas tributações no recebimento
    Quando estiver na tela de emissão de fatura
    E inserir o código do cliente
      | Código |
      | 381    |
    E iserir os dados do produto
      | Produto | Quantidade | Preco  |
      | 700562  | 8          | 12,00  |
      | 167097  | 7          | 120,00 |
      | 819342  | 3          | 18,99  |
      | 100526  | 2          | 85,00  |
      | 21933   | 5          | 90,00  |
      | 100185  | 10         | 12,99  |
      | 915338  | 5          | 77,50  |
      | 101885  | 10         | 12,99  |
      | 466661  | 5          | 56,75  |
      | 4018    | 15         | 10,10  |
      | 4015    | 15         | 10,10  |
      | 197665  | 3          | 34,50  |
    E estiver na tela de importação de Notas Fiscais
    E realizar a importação do XMl
    E  inserir os dados do romaneio
      | Quantidade_Romaneio | Validade_Romaneio |
      | 8                   | 31/12/2045        |
      | 7                   | 31/12/2045        |
      | 3                   | 31/12/2045        |
      | 2                   | 31/12/2045        |
      | 5                   | 31/12/2045        |
      | 10                  | 31/12/2045        |
      | 5                   | 31/12/2045        |
      | 10                  | 31/12/2045        |
      | 5                   | 31/12/2045        |
      | 15                  | 31/12/2045        |
      | 15                  | 31/12/2045        |
      | 3                   | 31/12/2045        |
    E criticar a entrada de NF
    E validar a entrada de NF
    Então deve visualizar o extrato de validação com o calculo dos tributos
      | TI             |
      | ICMS-ST A=0    |
      | FCP-ST         |
      | Pauta          |
      | RBC-ICMS-N     |
      | RBC-ICMS-ST    |
      | C-IPI          |
      | S-IPI          |
      | C-PIS/COFINS-N |
      | C-PIS/COFINS-I |
      | ICMS - I       |
      | ICMS - NT      |
      | ICMS-ST AC     |




