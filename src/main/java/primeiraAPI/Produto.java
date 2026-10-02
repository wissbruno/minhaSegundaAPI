// ATENCAO: a linha "package" abaixo deve ser IGUAL a primeira linha do
// PrimeiraApiApplication.java. Se for diferente, copie a de la.
package primeiraAPI;

/**
 * MODEL: representa um produto do sistema.
 * Define quais dados o produto tem: id, nome e preco.
 */
public class Produto {

    private Long id;
    private String nome;
    private double preco;

    // Construtor vazio: obrigatorio, o Spring usa para converter o JSON em objeto
    public Produto() {
    }

    public Produto(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
