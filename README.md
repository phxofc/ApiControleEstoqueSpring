# README - ApiControleEstoqueSpring
O `ApiControleEstoqueSpring` é responsável por gerenciar as operações relacionadas aos produtos, entradas e saídas de estoque . Abaixo estão descritos os principais métodos e funcionalidades disponíveis neste API.

## Cadastrar Produto

### Endpoint
- `POST /produtos`

### Descrição
- Este endpoint permite cadastrar um novo produto no estoque.

### Parâmetros de Entrada
- `ProdutoModel`: Objeto contendo as informações do produto a ser cadastrado.

### Exemplo de Requisição
```json
POST /produtos
{
  "nome": "Nome do Produto",
  "descricao": "Descrição do Produto",
  "quantidadeEstoque": 100
}
