// ============================================================
//  ATENCAO: troque a linha "package" abaixo pela MESMA linha
//  que esta no topo do arquivo PrimeiraApiApplication.java
//  (ex.: package com.example.primeiraAPI;)
// ============================================================
package com.example.primeiraAPI;

/**
 * MODEL (o "M" do MVC).
 * Representa a entidade Aluno. Nao trata requisicoes HTTP,
 * apenas define a estrutura do dado. O Spring usa esta classe
 * como "molde" para converter JSON <-> objeto Java.
 */
public class Aluno {

    private int id;
    private String nome;
    private int idade;

    // Construtor vazio: obrigatorio para o Spring converter o JSON do POST em objeto
    public Aluno() {
    }

    public Aluno(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    // Getters e Setters: o Spring usa estes metodos para ler e escrever os dados

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
