# Aplicativo de Calculadora de Troco

Este projeto, foi uma ideia surgida pelos Porfessores do Senai, como uma **prova** a ser realizada com o objetivo de calcular o **troco** a ser devolvido ao cliente após uma compra. Ele também calcula a quantidade mínima de **notas** e **moedas** necessárias para devolvê-lo. Além disso, armazena as transações realizadas e fornece um **fechamento de caixa** ao final do dia.

### Pré-requisitos

- **Eclipse IDE** instalado
- **Java JDK** configurado corretamente
- **Banco de Dados SQL**

## Funcionalidades

### 1. Cálculo do Troco
O operador deve inserir os seguintes valores:
- **Valor total da compra**
- **Valor recebido**

O sistema calcula a diferença entre o valor recebido e o valor total da compra, fornecendo o troco a ser devolvido.

### 2. Cálculo das Notas e Moedas
Após o cálculo do troco, o sistema calcula o menor número de notas e moedas necessárias para devolver o valor correto. As notas e moedas utilizadas são:

- **Notas:** R$ 100, R$ 50, R$ 20, R$ 10, R$ 5, R$ 2
- **Moedas:** R$ 1, R$ 0,50, R$ 0,25, R$ 0,10, R$ 0,05, R$ 0,01

Exemplo:
- **Valor total das compras:** R$ 86,45
- **Valor recebido:** R$ 100,00
- **Troco:** R$ 13,55
  - **Notas:**
    - 1 x R$ 10,00
    - 1 x R$ 2,00
  - **Moedas:**
    - 1 x R$ 1,00
    - 1 x R$ 0,50
    - 1 x R$ 0,05

### 3. Armazenamento de Transações
Todas as transações realizadas são armazenadas em um banco de dados MySQL. Isso permite ao operador realizar o **fechamento de caixa** ao final do dia e visualizar o total das vendas realizadas.

### 4. Fechamento de Caixa
O operador pode consultar o total das vendas realizadas durante o dia por meio da funcionalidade de fechamento de caixa. O valor total das transações será exibido.

## Banco de Dados

O aplicativo utiliza o banco de dados MySQL para armazenar as transações. A tabela **calculadora_troco** contém as seguintes colunas:

### Tabela: `calculadora_troco`

| Coluna               | Tipo    | Descrição                                                   |
|----------------------|---------|-------------------------------------------------------------|
| `idCalculadora_Troco`| INT     | Chave primária, identificador único da transação (auto incremento). |
| `valorCompra`         | DOUBLE  | Valor total da compra.                                      |
| `valorRecebido`       | DOUBLE  | Valor recebido do cliente.                                  |
| `troco`               | DOUBLE  | Valor do troco a ser devolvido ao cliente.                   |


## Fluxo de Funcionamento
- Cadastro da Transação
O operador insere os valores do valorCompra e valorRecebido. O sistema realiza o cálculo do troco e registra a transação no banco de dados.

- Exemplo de inserção:
Valor da compra: R$ 86,45
Valor recebido: R$ 100,00
O sistema calcula o troco de R$ 13,55 e o armazena no banco de dados.

- Exibição das Notas e Moedas
O sistema exibe as notas e moedas necessárias para o troco calculado.
 

## Considerações Finais
Este aplicativo foi desenvolvido para oferecer uma solução rápida e precisa para calcular o troco e gerenciar as transações de um ponto de venda. O uso do banco de dados MySQL permite o armazenamento persistente das transações, facilitando o controle financeiro e o fechamento de caixa.

