package br.com.mapper.appIonic.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mapper.appIonic.dto.CategoriaDto;
import br.com.mapper.appIonic.model.Categoria;
import br.com.mapper.appIonic.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public Page<CategoriaDto> listar(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		if (nome == null) {
			Page<Categoria> categoria = categoriaRepository.findAll(paginacao);
			return CategoriaDto.converter(categoria);
		} else {
			Page<Categoria> categoria = categoriaRepository.findByNome(nome, paginacao);
			return CategoriaDto.converter(categoria);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> detalhar(@PathVariable Integer id){
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			return ResponseEntity.ok(new CategoriaDto(categoria.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
