package br.com.mapper.appIonic.dto;

import org.springframework.data.domain.Page;

import br.com.mapper.appIonic.model.Categoria;

public class CategoriaDto {

	private Integer id;
	private String nome;

	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}

	public static Page<CategoriaDto> converter(Page<Categoria> categoria) {
		return categoria.map(CategoriaDto::new);
	}
}
