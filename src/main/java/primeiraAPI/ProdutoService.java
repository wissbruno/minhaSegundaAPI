// ATENCAO: a linha "package" deve ser IGUAL a de Produto.java e AlunoController.java.
package primeiraAPI;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * SERVICE: guarda a logica e os dados.
 * A lista em memoria (RAM) faz o papel de banco de dados enquanto a API roda.
 */
@Service
public class ProdutoService {

    // Lista estatica na memoria: simula o banco de dados
    private static final List<Produto> produtos = new ArrayList<>();

    // Gera os IDs automaticamente (1, 2, 3...)
    private static final AtomicLong counter = new AtomicLong();

    // GET (todos): devolve a lista completa
    public List<Produto> findAll() {
        return produtos;
    }

    // GET (por id): procura um produto pelo id. Optional = "caixa" que pode estar vazia
    public Optional<Produto> findById(Long id) {
        return produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    // POST: gera um id novo e guarda o produto na lista
    public Produto save(Produto produto) {
        produto.setId(counter.incrementAndGet());
        produtos.add(produto);
        return produto;
    }

    // PUT: troca nome e preco de um produto que ja existe
    public Optional<Produto> update(Long id, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = findById(id);
        if (produtoExistente.isPresent()) {
            Produto p = produtoExistente.get();
            p.setNome(produtoAtualizado.getNome());
            p.setPreco(produtoAtualizado.getPreco());
            return Optional.of(p);
        }
        return Optional.empty();
    }

    // DELETE: remove o produto se o id existir (true) ou devolve false
    public boolean deleteById(Long id) {
        return produtos.removeIf(p -> p.getId().equals(id));
    }
}
