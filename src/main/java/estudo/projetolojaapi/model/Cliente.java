package estudo.projetolojaapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate nascimento;
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    public Cliente(Long id, LocalDate dataNascimento, String cpf, String nome, String endereco, String telefone, String email) {
        super();
    }

    public Cliente(Long id, LocalDate nascimento, String cpf, String nome, String endereco, String telefone, String email, LocalDate dataCadastro) {
        this.id = id;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public Cliente(LocalDate nascimento, String cpf, String nome, String endereco, String telefone, String email) {
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente() {

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nascimento=" + nascimento +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email'" + email + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
