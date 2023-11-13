Estoque API
Este projeto é uma API para gerenciamento de estoque de produtos, proporcionando funcionalidades como cadastro de produtos, registro de entrada de produtos no estoque e registro de saída de produtos do estoque.

Endpoints
1. Cadastrar Produto
Endpoint: POST /produtos
Descrição: Cadastra um novo produto no estoque.
Parâmetros de Entrada: Objeto JSON representando os detalhes do produto.
Exemplo de Uso:
json
Copy code
{
  "nome": "Produto A",
  "descricao": "Descrição do Produto A",
  "quantidadeEstoque": 100
}
Resposta de Sucesso: Retorna o produto cadastrado com o status HTTP 201 - Created.
2. Realizar Entrada de Produto
Endpoint: POST /produtos/{id}/entradas
Descrição: Registra a entrada de produtos no estoque.
Parâmetros de Entrada:
id: Identificador único do produto.
Objeto JSON representando os detalhes da entrada de produtos.
Exemplo de Uso:
json
Copy code
{
  "quantidadeEntrada": 50,
  "dataEntrada": "2023-11-13T12:00:00"
}
Resposta de Sucesso: Retorna os detalhes da entrada de produtos registrada com o status HTTP 201 - Created.
3. Realizar Saída de Produto
Endpoint: POST /produtos/{id}/saidas
Descrição: Registra a saída de produtos do estoque.
Parâmetros de Entrada:
id: Identificador único do produto.
Objeto JSON representando os detalhes da saída de produtos.
Exemplo de Uso:
json
Copy code
{
  "quantidadeSaida": 20,
  "motivoSaida": "Venda"
}
Resposta de Sucesso: Retorna os detalhes da saída de produtos registrada com o status HTTP 201 - Created.
4. Deletar Entrada de Produto
Endpoint: DELETE /produtos/{id}/entradas/{idEntradaProduto}
Descrição: Exclui um registro de entrada de produto do estoque.
Parâmetros de Entrada:
id: Identificador único do produto.
idEntradaProduto: Identificador único da entrada de produto a ser deletada.
Resposta de Sucesso: Retorna uma mensagem indicando que a entrada foi deletada e o estoque foi atualizado.
5. Deletar Saída de Produto
Endpoint: DELETE /produtos/{id}/saidas/{idSaidaProduto}
Descrição: Exclui um registro de saída de produto do estoque.
Parâmetros de Entrada:
id: Identificador único do produto.
idSaidaProduto: Identificador único da saída de produto a ser deletada.
Resposta de Sucesso: Retorna uma mensagem indicando que a saída foi deletada e o estoque foi atualizado.
Tecnologias Utilizadas
Java
Spring Boot
Banco de Dados (não especificado no código fornecido)
Configuração
O projeto utiliza as anotações do Spring Boot para injeção de dependências e mapeamento de endpoints. Certifique-se de ter as dependências do Spring Boot configuradas corretamente no seu ambiente de desenvolvimento. O banco de dados utilizado não foi especificado, portanto, certifique-se de configurar corretamente o banco de dados de acordo com as necessidades do projeto.
