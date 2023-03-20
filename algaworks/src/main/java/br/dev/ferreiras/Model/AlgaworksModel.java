package br.dev.ferreiras.Model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
// comparar 2 objetos em Java 
@Getter
@Setter
@Entity
@Table(name = "users")
// padrão é o nome da classe
public class AlgaworksModel {

	protected AlgaworksModel() {

	}

	protected AlgaworksModel(Long id, String nome, String endereco, String cpf, int idade, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.idade = idade;
		this.email = email;
	}

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// @Override
	// public int hashCode() {
	// return Objects.hash(id);
	// }

	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// AlgaworksModel other = (AlgaworksModel) obj;
	// return Objects.equals(id, other.id);
	// }

	@Column(name = "nome")
	@NotBlank
	@Size(max = 60)
	private String nome;
	
	@NotBlank
	@Size(max=255)
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "cpf")
	@NotBlank
	@Size(max=20)
	private String cpf;
	
	@Column(name = "idade")
	private int idade;
	
	@Column(name = "email")
	@NotBlank
	@Email
	@Size(max=255)
	private String email;

	@Column(name = "fone")
	@NotBlank
	@Size(max=50)
	private String fone;

	// public Long getId() {
	// return id;
	// }
	// public void setId(Long id) {
	// this.id = id;
	// }
	// public String getNome() {
	// return nome;
	// }
	// public void setNome(String nome) {
	// this.nome = nome;
	// }
	// public String getEndereco() {
	// return endereco;
	// }
	// public void setEndereco(String endereco) {
	// this.endereco = endereco;
	// }
	// public String getCpf() {
	// return cpf;
	// }
	// public void setCpf(String cpf) {
	// this.cpf = cpf;
	// }
	// public int getIdade() {
	// return idade;
	// }
	// public void setIdade(int idade) {
	// this.idade = idade;
	// }
	// public String getEmail() {
	// return email;
	// }
	// public void setEmail(String email) {
	// this.email = email;
	// }

}
