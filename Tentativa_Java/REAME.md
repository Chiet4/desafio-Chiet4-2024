# Projeto RecintosZoo

## Descrição

Este projeto em Java foi uma tentativa de resolver o desafio em uma linguagem que eu estive-se mais habituado.

## Estrutura do Projeto

### Classes

#### `Animal`

Representa um animal no zoológico.

**Atributos:**
- `especie` (String): Nome da espécie do animal.
- `tamanho` (int): Tamanho do animal (em unidades arbitrárias).
- `bioma` (List<String>): Lista de biomas onde o animal pode viver.

**Métodos:**
- `getEspecie()`: Retorna a espécie do animal.
- `getTamanho()`: Retorna o tamanho do animal.
- `getBioma()`: Retorna a lista de biomas onde o animal pode viver.

#### `Recinto`

Representa um recinto no zoológico.

**Atributos:**
- `nome` (String): Nome do recinto.
- `bioma` (String): Bioma do recinto.
- `espacoLivre` (int): Espaço livre disponível no recinto (em unidades arbitrárias).
- `capacidadeTotal` (int): Capacidade total do recinto.

**Métodos:**
- `getNome()`: Retorna o nome do recinto.
- `getBioma()`: Retorna o bioma do recinto.
- `getEspacoLivre()`: Retorna o espaço livre disponível no recinto.
- `getCapacidadeTotal()`: Retorna a capacidade total do recinto.

#### `RecintosZoo`

Classe principal que gerencia os recintos e animais e realiza análises para encontrar recintos viáveis para determinados animais.

**Métodos:**
- `analisaRecintos(String tpanimal, int quantidade)`: Analisa quais recintos são viáveis para alocar a quantidade especificada de um animal com a espécie fornecida. Retorna um objeto `ResultadoAnalise`.

#### `ResultadoAnalise`

Representa o resultado da análise dos recintos.

**Atributos:**
- `erro` (String): Mensagem de erro, se houver.
- `recintosViaveis` (List<String>): Lista de strings representando os recintos viáveis.

**Métodos:**
- `getErro()`: Retorna a mensagem de erro, se houver.
- `getRecintosViaveis()`: Retorna a lista de recintos viáveis.

## Testes

Os testes estão implementados usando JUnit 5 e garantem o correto funcionamento das funcionalidades principais da classe `RecintosZoo`.

### Testes Implementados

- **`deveRejeitarAnimalInvalido`**: Verifica se o sistema rejeita um animal que não está na lista.
- **`deveRejeitarQuantidadeInvalida`**: Verifica se o sistema rejeita uma quantidade inválida de animais.
- **`naoDeveEncontrarRecintosPara10Macacos`**: Verifica se o sistema não encontra recintos viáveis para uma quantidade excessiva de macacos.
- **`deveEncontrarRecintoPara1Crocodilo`**: Verifica se o sistema encontra um recinto adequado para um crocodilo.
- **`deveEncontrarRecintosPara2Macacos`**: Verifica se o sistema encontra recintos adequados para dois macacos.

