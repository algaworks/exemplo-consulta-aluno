package com.algaworks.model;

import java.io.Serializable;

public class ProdutoPrecoClienteId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigoCliente;
	private Long codigoProduto;

	public ProdutoPrecoClienteId() {
	}

	public ProdutoPrecoClienteId(Long codigoCliente, Long codigoProduto) {
		this.codigoCliente = codigoCliente;
		this.codigoProduto = codigoProduto;
	}

	public Long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCliente == null) ? 0 : codigoCliente.hashCode());
		result = prime * result + ((codigoProduto == null) ? 0 : codigoProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoPrecoClienteId other = (ProdutoPrecoClienteId) obj;
		if (codigoCliente == null) {
			if (other.codigoCliente != null)
				return false;
		} else if (!codigoCliente.equals(other.codigoCliente))
			return false;
		if (codigoProduto == null) {
			if (other.codigoProduto != null)
				return false;
		} else if (!codigoProduto.equals(other.codigoProduto))
			return false;
		return true;
	}

}
