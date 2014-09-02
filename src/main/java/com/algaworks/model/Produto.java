package com.algaworks.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private BigDecimal preco1;
	private BigDecimal preco2;
	private BigDecimal preco3;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getPreco1() {
		return preco1;
	}

	public void setPreco1(BigDecimal preco1) {
		this.preco1 = preco1;
	}

	public BigDecimal getPreco2() {
		return preco2;
	}

	public void setPreco2(BigDecimal preco2) {
		this.preco2 = preco2;
	}

	public BigDecimal getPreco3() {
		return preco3;
	}

	public void setPreco3(BigDecimal preco3) {
		this.preco3 = preco3;
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
