package br.com.mapper.appIonic.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import br.com.mapper.appIonic.model.enums.StatusPagamento;

@Entity
public class PagamentoBoleto extends Pagamento  {

	private static final long serialVersionUID = 1L;

	private LocalDate dataVencimento;
	private LocalDate dataPagamento;

	public PagamentoBoleto() {
	}

	public PagamentoBoleto(StatusPagamento status, Pedido pedido, LocalDate dataVencimento, LocalDate dataPagamento) {
		super(status, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
