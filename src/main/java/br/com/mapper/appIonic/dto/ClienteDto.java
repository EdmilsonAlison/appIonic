package br.com.mapper.appIonic.dto;

import java.util.Set;

import org.springframework.data.domain.Page;

import br.com.mapper.appIonic.model.Cliente;

public class ClienteDto {

	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private String tipoCliente;
	private Set<String> telefones;

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cpfOuCnpj = cliente.getCpfOuCnpj();
		this.tipoCliente = cliente.getTipoCliente().toString();
		this.telefones = cliente.getTelefones();
	}

	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public static Page<ClienteDto> converter(Page<Cliente> cliente) {
		return cliente.map(ClienteDto::new);
	}
}
