package com.algaworks.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class PrecoProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private BigDecimal preco;
	
	public PrecoProduto() {
	}

	public PrecoProduto(Long codigo, BigDecimal preco) {
		this.codigo = codigo;
		this.preco = preco;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		PrecoProduto other = (PrecoProduto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
