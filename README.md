# APP-SIMULATIONS-KOTLIN

Aplicação desenvolvida em Kotlin com SpringBoot que consegue reproduzir alguns procedimentos bancários, como simulações
e contratações de empréstimos. O desenvolvimento inicial foi realizado em torno do seguinte desafio
https://github.com/Creditas/challenge/blob/master/backend/code-challenges/kotlin/README.pt-BR.md, as demais funcionalidades foram desenvolvidas
com o propósito de se aprofundar na linguagem Kotlin. Tanto o desafio acima quando outros podem ser encontrados no seguinte repositorio
https://github.com/leonardodantas/backend-challenges

<div style="display: inline_block">

  <img align="center" alt="java" src="https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white" />
  <img align="center" alt="spring" src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
</div>

## Documentação da API

### Retorna as modalidades de empréstimo disponíveis para o cliente

```
  POST /available-loans
```
Utilizando informações como renda, data de aniversário e localização, o sistema retorna 
as modalidade disponíveis ao cliente para a realização de empréstimo, como por exemplo,
empréstimo com garantia, pessoal e consignado, o seguinte body se faz necessário para isso. O retorno só será
positivo se o cliente não possuir nenhum empréstimo ativo.

| Atributo   | Tipo       | Descrição                           |Validações|
| :---------- | :--------- | :---------------------------------- |----|
| `birthDate` | `Date` | **Obrigatório**. Data de nascimento |Todo cliente precisa ter no mínimo 18 anos|
| `cep` | `String` | **Obrigatório**. CEP do Cliente |O cliente deve possuir um CEP valido|
| `cpf` | `String` | **Obrigatório**. CPF do cliente |Deve estar em um formato valido|
| `income` | `BigDecimal` | **Obrigatório**. Renda do cliente |Deve ser maior que 0 e não nulo|
| `name` | `String` | **Obrigatório**. Nome do cliente |Não deve ser nulo e nem branco, com o tamanho mínimo de 10 e máximo de 60 |

### Retorna uma lista de simulações para o cliente

```
  POST /simulations
```

Após a validação das modalidades disponíveis, é possível visualizar a proposta com as simulações. No retorno é possível consultar simulações que possuem de 1 parcela até 12 parcelas,
em cada simulação é possível ver a taxa de juros, calculo do imposto e valor do IOF, tanto o fixo quanto o diário. A proposta após gerada tem duração de 30 minutos, caso o tempo tenha se esgotado é possível a sua renovação desde que a data de criação menos a data atual seja menor que 30 dias. Duas simulações iguais não podem existir, ou seja
é impossível a realização de duas simulações com os mesmos valores. Caso o cliente já possua um empréstimo em andamento, ficara inviável 
que o mesmo realize simulações.
| Atributo   | Tipo       | Descrição                           |Validações|
| :---------- | :--------- | :---------------------------------- |----|
| `birthDate` | `Date` | **Obrigatório**. Data de nascimento |Todo cliente precisa ter no minino 18 anos|
| `cep` | `String` | **Obrigatório**. CEP do Cliente |O cliente deve possuir um CEP valido|
| `cpf` | `String` | **Obrigatório**. CPF do cliente |Deve estar em um formato valido|
| `income` | `BigDecimal` | **Obrigatório**. Renda do cliente |Deve ser maior que 0 e não nulo|
| `loanAmount` | `BigDecimal` | **Obrigatório**. Valor do emprestimo |Deve ser um número positivo e maior que zero |
| `modality` | `Modality` | **Obrigatório**. Modalidade do cliente |Valores que são aceitos: PERSONAL, GUARANTEE, CONSIGNED|

### Aceitar proposta

```
  POST /accept-proposal
```

Endpoint onde é possível aceitar uma proposta anteriormente gerada. A proposta precisa ser valida, e o cliente não deve possuir nenhum
empréstimo em andamento
| Atributo   | Tipo       | Descrição                           |Validações|
| :---------- | :--------- | :---------------------------------- |----|
| `simulationId` | `String` | **Obrigatório**. ID da simulação |A proposta deve estar ativa|
| `proposalId` | `String` | **Obrigatório**. ID da proposta |O ID deve pertencer a proposta que também está sendo enviada|
| `cpf` | `String` | **Obrigatório**. CPF do cliente |Deve estar em um formato valido e não possuir nenhum empréstimo em andamento|

### Realiza a renovação da proposta

```
  PUT /renew-proposal
```
Realiza a renovação de propostas expiradas, que possuem mais de 30 minutos de duração e menos que 30 dias de criação. Durante a renovação da
proposta é verificado se o cliente ainda é elegível na antiga modalidade, caso não seja o procedimento será encerrado
| Atributo   | Tipo       | Descrição                           |Validações|
| :---------- | :--------- | :---------------------------------- |----|
| `birthDate` | `Date` | **Obrigatório**. Data de nascimento |Todo cliente precisa ter no mínimo 18 anos|
| `cep` | `String` | **Obrigatório**. CEP do Cliente |O cliente deve possuir um CEP valido|
| `cpf` | `String` | **Obrigatório**. CPF do cliente |Deve estar em um formato valido e não possuir empréstimo ativo|
| `income` | `BigDecimal` | **Obrigatório**. Renda do cliente |Deve ser maior que 0 e não nulo|
| `proposalId` | `String` | **Obrigatório**. ID da proposta |Deve ser um ID valido e a proposta ainda deve ser renovável |

### Retorna os empréstimos do cliente

```
  GET /loans/customers/{cpf}
```

Retorna todos os empréstimos realizados pelo cliente, usando como paramento o seu cpf, caso não exista será retornado 
um status code 404
| Parâmetro   | Tipo       | Descrição                           
| :---------- | :--------- | :------------------------ 
| `cpf` | `String` | **Obrigatório**. CPF do cliente |


```
  GET /proposals/{proposalId}
```

Retorna informações da proposta através do id da proposta, caso não exista será retornado 
um status code 404
| Parâmetro   | Tipo       | Descrição                           
| :---------- | :--------- | :------------------------ 
| `proposalId` | `String` | **Obrigatório**. Proposta a ser buscada |

```
  GET /proposals/{proposalId}/details
```

Retorna os detalhes da proposta, como todas as simulações e informações das parcelas através do id da proposta, caso não exista será retornado 
um status code 404
| Parâmetro   | Tipo       | Descrição                           
| :---------- | :--------- | :------------------------ 
| `proposalId` | `String` | **Obrigatório**. Proposta a ser buscada |

```
  GET /proposals/customer/{cpf}
```

Retorna todas as propostas disponíveis para o cliente através do seu CPF, caso não exista será retornado 
um status code 404
| Parâmetro   | Tipo       | Descrição                           
| :---------- | :--------- | :------------------------ 
| `cpf` | `String` | **Obrigatório**. CPF do cliente |

