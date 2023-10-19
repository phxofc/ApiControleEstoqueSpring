package br.com.estoqueapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estoqueapi.model.EntradaProdutoModel;
import br.com.estoqueapi.model.ProdutoModel;
import br.com.estoqueapi.model.SaidaProdutoModel;
import br.com.estoqueapi.response.EntradaProdutoResponse;
import br.com.estoqueapi.repositories.EntradaProdutoRepository;
import br.com.estoqueapi.repositories.ProdutoRepository;
import br.com.estoqueapi.repositories.SaidaProdutoRepository;
import br.com.estoqueapi.request.EntradaProdutoRequest;
import br.com.estoqueapi.request.SaidaProdutoRequest;
import br.com.estoqueapi.response.SaidaProdutoResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    // cadastrar produto
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity cadastrarProduto(@RequestBody @Valid ProdutoModel produtoModel) {

        var produtoSalvo = this.produtoRepository.save(produtoModel);
        

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    // cadastrar entradaproduto
    @Autowired
    private EntradaProdutoRepository entradaProdutoRepository;

    @PostMapping("/{id}/entradas")
    public ResponseEntity realizarEntrada(@RequestBody @Valid EntradaProdutoRequest entrada, @PathVariable Long id) {

        Optional<ProdutoModel> produtoModel = this.produtoRepository.findById(id);

        if (produtoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NÃO EXISTE CADASTRO DESTE PRODUTO");
        }

        EntradaProdutoModel entradaProdutoModel = entrada.toModelo(produtoModel.get());
        ProdutoModel produto = produtoModel.get();

        // atualizar o estoque
        Integer novaQuantidade = produto.getQuantidadeEstoque() + entradaProdutoModel.getQuantidadeEntrada();
        produto.setQuantidadeEstoque(novaQuantidade);
        var atualizarEstoque = this.produtoRepository.save(produto);
        if (atualizarEstoque == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO ATUALIZAR O ESTOQUE NA ENTRADA");
        }

        // persistindo no banco
        this.entradaProdutoRepository.save(entradaProdutoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(new EntradaProdutoResponse(entradaProdutoModel));
    }

    // cadastrar saida produto
    @Autowired
    private SaidaProdutoRepository saidaProdutoRepository;

    @PostMapping("/{id}/saidas")

    public ResponseEntity realizarSaida(@RequestBody @Valid SaidaProdutoRequest saida, @PathVariable Long id) {

        Optional<ProdutoModel> produtoModel = this.produtoRepository.findById(id);

        if (produtoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NÃO EXISTE CADASTRO DESTE PRODUTO");
        }

        ProdutoModel produto = produtoModel.get();

        Integer quantidadeDisponivel = produto.getQuantidadeEstoque();

        if (saida.getQuantidade() > quantidadeDisponivel) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "QUANTIDADE DA SAIDA DEVE SER MENOR OU IGUAL A QUANTIDADE DISPONIVEL: " + quantidadeDisponivel);
        }

        SaidaProdutoModel saidaProdutoModel = saida.toModelo(produtoModel.get());

        // atualizar estoque
        Integer novaQuantidade = produto.getQuantidadeEstoque() - saidaProdutoModel.getQuantidade_saida();
        produto.setQuantidadeEstoque(novaQuantidade);
        var atualizarEstoque = this.produtoRepository.save(produto);

        if (atualizarEstoque == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO ATUALIZAR O ESTOQUE NA SAIDA");
        }

        this.saidaProdutoRepository.save(saidaProdutoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(new SaidaProdutoResponse(saidaProdutoModel));

    }


    //deletarEntradaProduto
    @DeleteMapping("/{id}/entradas/{idEntradaProduto}")
    public ResponseEntity deletarEntradaProduto(@PathVariable Long id, @PathVariable Long idEntradaProduto){
        
        Optional<ProdutoModel> produtoModel = this.produtoRepository.findById(id);

        if (produtoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NÃO EXISTE CADASTRO DESTE PRODUTO");
        }

        Optional<EntradaProdutoModel> entradaProdutoModelOptional = this.entradaProdutoRepository.findById(idEntradaProduto);

        if (entradaProdutoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NÃO EXISTE ENTRADA DESTE PRODUTO");
        }

        ProdutoModel produto = produtoModel.get();
        EntradaProdutoModel entradaProdutoModel = entradaProdutoModelOptional.get();

        this.entradaProdutoRepository.delete(entradaProdutoModel);

        //atualizar o estoque

        Integer novaQuantidade = produto.getQuantidadeEstoque() - entradaProdutoModel.getQuantidadeEntrada();
       produto.setQuantidadeEstoque(novaQuantidade);
       var atualizarEstoque = this.produtoRepository.save(produto);

        if(atualizarEstoque ==null){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO ATUALIZAR O ESTOQUE");
            }
        

         return ResponseEntity.status(HttpStatus.OK).body("ENTRADA DELETADA E ESTOQUE ATUALIZADO!");
    }



    //deletarSaidaProduto


    @DeleteMapping("/{id}/saidas/{idSaidaProduto}")
    public ResponseEntity deletarSaidaProduto(@PathVariable Long id, @PathVariable Long idSaidaProduto){
        
        Optional<ProdutoModel> produtoModel = this.produtoRepository.findById(id);

        if (produtoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NÃO EXISTE CADASTRO DESTE PRODUTO");
        }

        Optional<SaidaProdutoModel> saidaProdutoModelOptional = this.saidaProdutoRepository.findById(idSaidaProduto);

        if (saidaProdutoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NÃO EXISTE A SAIDA DESTE PRODUTO");
        }

        ProdutoModel produto = produtoModel.get();
        SaidaProdutoModel saidaProdutoModel = saidaProdutoModelOptional.get();

        this.saidaProdutoRepository.delete(saidaProdutoModel);

        //atualizar o estoque

        Integer novaQuantidade = produto.getQuantidadeEstoque() + saidaProdutoModel.getQuantidade_saida();
       produto.setQuantidadeEstoque(novaQuantidade);
       var atualizarEstoque = this.produtoRepository.save(produto);

        if(atualizarEstoque ==null){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO ATUALIZAR O ESTOQUE");
            }
        

         return ResponseEntity.status(HttpStatus.OK).body("SAIDA DELETADA E ESTOQUE ATUALIZADO!");
    }

}
