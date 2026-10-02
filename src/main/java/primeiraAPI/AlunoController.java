// ============================================================
//  ATENCAO: troque a linha "package" abaixo pela MESMA linha
//  que esta no topo do arquivo PrimeiraApiApplication.java
//  (ex.: package com.example.primeiraAPI;)
// ============================================================
package com.example.primeiraAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CONTROLLER (o "C" do MVC).
 * Recebe as requisicoes HTTP do cliente (Postman), executa a logica
 * e devolve a resposta em JSON.
 *
 * @RestController  -> avisa ao Spring que esta classe responde requisicoes web
 * @RequestMapping  -> define a rota base: tudo aqui comeca em /alunos
 */
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    // "Banco de dados" em memoria. Ao parar a aplicacao, os dados se perdem.
    private List<Aluno> alunos = new ArrayList<>();

    // Controla o proximo ID a ser gerado
    private int proximoId = 1;

    // Dados iniciais, para o primeiro GET ja retornar alguma coisa
    public AlunoController() {
        alunos.add(new Aluno(proximoId++, "Ana Silva", 20));
        alunos.add(new Aluno(proximoId++, "Pedro Souza", 22));
    }

    // ---------- ATIVIDADE 5 - ENDPOINT GET ----------
    // GET http://localhost:8080/alunos
    // Retorna a lista completa de alunos em JSON.
    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunos;
    }

    // ---------- ATIVIDADE 5 - ENDPOINT POST ----------
    // POST http://localhost:8080/alunos
    // Recebe um JSON no corpo (body) e cria um novo aluno.
    // @RequestBody converte o JSON recebido em um objeto Aluno.
    @PostMapping
    public Aluno adicionarAluno(@RequestBody Aluno aluno) {
        aluno.setId(proximoId++);
        alunos.add(aluno);
        return aluno;
    }

    // ---------- ATIVIDADE 6 - ENDPOINT DELETE ----------
    // DELETE http://localhost:8080/alunos/1
    // @PathVariable pega o numero que vem na URL e joga na variavel id.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerAluno(@PathVariable int id) {

        boolean removido = alunos.removeIf(aluno -> aluno.getId() == id);

        if (removido) {
            // Status 200 OK
            return ResponseEntity.ok("Aluno com id " + id + " removido com sucesso.");
        }

        // Status 404 Not Found
        return ResponseEntity.status(404).body("Aluno com id " + id + " nao encontrado.");
    }
}
