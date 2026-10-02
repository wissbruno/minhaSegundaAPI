// ATENCAO: a linha "package" deve ser IGUAL a de Produto.java e AlunoController.java.
package primeiraAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * CONTROLLER: recebe as requisicoes HTTP e devolve as respostas em JSON.
 * Rota base: http://localhost:8080/produtos
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    // O Spring entrega o ProdutoService pronto para uso
    @Autowired
    private ProdutoService produtoService;

    // GET /produtos -> lista todos
    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.findAll();
    }

    // GET /produtos/{id} -> busca um (200 se achar, 404 se nao achar)
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /produtos -> cria um novo (o JSON do corpo vira um objeto Produto)
    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    // PUT /produtos/{id} -> atualiza (200 se achar, 404 se nao achar)
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Optional<Produto> produto = produtoService.update(id, produtoAtualizado);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE /produtos/{id} -> remove (200 se removeu, 404 se nao achou)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        if (produtoService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
