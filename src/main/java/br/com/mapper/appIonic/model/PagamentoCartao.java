package br.com.mapper.appIonic.model;

import javax.persistence.Entity;

import br.com.mapper.appIonic.model.enums.StatusPagamento;

@Entity
public class PagamentoCartao extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Integer numeroParcelas;

	public PagamentoCartao() {
		super();
	}

	public PagamentoCartao(StatusPagamento status, Pedido pedido, Integer numeroParcelas) {
		super(status, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

}
