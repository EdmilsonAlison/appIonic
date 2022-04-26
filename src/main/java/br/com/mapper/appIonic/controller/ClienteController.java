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

import br.com.mapper.appIonic.dto.ClienteDto;
import br.com.mapper.appIonic.model.Cliente;
import br.com.mapper.appIonic.repository.ClienteRepository;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository ClienteRepository;

	@GetMapping
	public Page<ClienteDto> listar(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		if (nome == null) {
			Page<Cliente> Cliente = ClienteRepository.findAll(paginacao);
			return ClienteDto.converter(Cliente);
		} else {
			Page<Cliente> Cliente = ClienteRepository.findByNome(nome, paginacao);
			return ClienteDto.converter(Cliente);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> detalhar(@PathVariable Integer id){
		Optional<Cliente> Cliente = ClienteRepository.findById(id);
		if(Cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(Cliente.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
