package br.com.mapper.appIonic.model.enums;

public enum StatusPagamento {

	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

	private Integer id;
	private String descricao;



	private StatusPagamento(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusPagamento toEnum(Integer id) {
		if(id == null) {
			return null;
		}
		
		for(StatusPagamento x : StatusPagamento.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido "+id);
	}

}
