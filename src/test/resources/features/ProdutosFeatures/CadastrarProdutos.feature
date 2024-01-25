#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 11/05/2023
# version: 1.0

Funcionalidade: cadastrar produto
  Com essa funcionalidade iremos conseguir cadastrar um novo produto

  Como um usuário logado na aplicação
  Eu quero cadastrar um novo produto
  Para poder dar entrada dos produtos no estoque fururamente

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

  @Smoke_test @CadastrarProduto @Produtos
  Esquema do Cenário: Validar o cadastramento de produtos
    Quando estiver na tela de manutenção de produtos
    E inserir os dados do produto
      | Tipo_PLU   | Tipo_Produto   | Descrição_curta   | Descrição_comercial   | Descrição_tecnica   | Referencia   | Classificação_Mercadologica   | Fornecedor_principal   | Divisão   | Etiqueta   | Etiqueta_facing   | Prazo_de_entrega   | Mix_de_produtos   | Volume   | Peso_bruto   | Peso_liquido   |
      | <Tipo_PLU> | <Tipo_Produto> | <Descrição_curta> | <Descrição_comercial> | <Descrição_tecnica> | <Referencia> | <Classificação_Mercadologica> | <Fornecedor_principal> | <Divisão> | <Etiqueta> | <Etiqueta_facing> | <Prazo_de_entrega> | <Mix_de_produtos> | <Volume> | <Peso_bruto> | <Peso_liquido> |

    Então deve visualizar  o EAN na tela de consulta!!!

    Exemplos:
      | Tipo_PLU | Tipo_Produto               | Descrição_curta      | Descrição_comercial      | Descrição_tecnica                | Referencia | Classificação_Mercadologica | Fornecedor_principal | Divisão | Etiqueta | Etiqueta_facing | Mix_de_produtos | Prazo_de_entrega | Volume | Peso_bruto | Peso_liquido |
      | Normal   | 00-Mercadoria para Revenda | REFRIG TITAN COLA 1L | REFRIG TITAN COLA 1L PET | REFRIG TITAN COLA 1L PET CAFEINA | 1354       | 01.01.02.001.002            | 1                    | Divisão | 5        | 5               | CARGA IFOOD     | 7                | 350    | 3500000    | 3450000      |