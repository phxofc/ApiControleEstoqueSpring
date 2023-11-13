# README - ProdutoController

O `ProdutoController` é uma classe responsável por gerenciar as operações relacionadas aos produtos, entradas e saídas de estoque em uma API. Abaixo estão descritos os principais métodos e funcionalidades disponíveis neste controlador.

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
Exemplo de Resposta
json
Copy code
HTTP/1.1 201 Created
{
  "id": 1,
  "nome": "Nome do Produto",
  "descricao": "Descrição do Produto",
  "quantidadeEstoque": 100
}
Realizar Entrada de Produto
Endpoint
POST /produtos/{id}/entradas
Descrição
Este endpoint permite registrar uma entrada de produtos no estoque.
Parâmetros de Entrada
EntradaProdutoRequest: Objeto contendo as informações da entrada de produtos.
id: Identificador único do produto no qual a entrada será registrada.
Exemplo de Requisição
json
Copy code
POST /produtos/1/entradas
{
  "quantidadeEntrada": 50,
  "motivoEntrada": "Reposição de Estoque"
}
Exemplo de Resposta
json
Copy code
HTTP/1.1 201 Created
{
  "id": 1,
  "quantidadeEntrada": 50,
  "motivoEntrada": "Reposição de Estoque",
  "dataEntrada": "2023-11-13T00:00:00"
}
Realizar Saída de Produto
Endpoint
POST /produtos/{id}/saidas
Descrição
Este endpoint permite registrar uma saída de produtos do estoque.
Parâmetros de Entrada
SaidaProdutoRequest: Objeto contendo as informações da saída de produtos.
id: Identificador único do produto no qual a saída será registrada.
Exemplo de Requisição
json
Copy code
POST /produtos/1/saidas
{
  "quantidadeSaida": 20,
  "motivoSaida": "Venda"
}
Exemplo de Resposta
json
Copy code
HTTP/1.1 201 Created
{
  "id": 1,
  "quantidadeSaida": 20,
  "motivoSaida": "Venda",
  "dataSaida": "2023-11-13T00:00:00"
}
Deletar Entrada de Produto
Endpoint
DELETE /produtos/{id}/entradas/{idEntradaProduto}
Descrição
Este endpoint permite excluir uma entrada de produtos do histórico e atualizar o estoque.
Parâmetros de Entrada
id: Identificador único do produto.
idEntradaProduto: Identificador único da entrada de produto a ser excluída.
Exemplo de Requisição
json
Copy code
DELETE /produtos/1/entradas/1
Exemplo de Resposta
json
Copy code
HTTP/1.1 200 OK
"ENTRADA DELETADA E ESTOQUE ATUALIZADO!"
Deletar Saída de Produto
Endpoint
DELETE /produtos/{id}/saidas/{idSaidaProduto}
Descrição
Este endpoint permite excluir uma saída de produtos do histórico e atualizar o estoque.
Parâmetros de Entrada
id: Identificador único do produto.
idSaidaProduto: Identificador único da saída de produto a ser excluída.
Exemplo de Requisição
json
Copy code
DELETE /produtos/1/saidas/1
Exemplo de Resposta
json
Copy code
HTTP/1.1 200 OK
"SAIDA DELETADA E ESTOQUE ATUALIZADO!"
