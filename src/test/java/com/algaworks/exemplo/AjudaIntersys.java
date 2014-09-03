package com.algaworks.exemplo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.model.Cliente;
import com.algaworks.model.Produto;
import com.algaworks.model.ProdutoPrecoCliente;
import com.algaworks.model.vo.PrecoProduto;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class AjudaIntersys {

private JIntegrity helper;
	
	private EntityManager manager;
	
	@Before
	public void init() {
		helper = new JIntegrity();
		helper.useMySQL();
		
		helper.cleanAndInsert();
		
		this.manager = JPAHelper.currentEntityManager();
	}
	
	@Test
	public void consulta() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<PrecoProduto> criteria = builder.createQuery(PrecoProduto.class);
		
		Root<Produto> produto = criteria.from(Produto.class);
		Root<Cliente> cliente = criteria.from(Cliente.class);
		Root<ProdutoPrecoCliente> produtoPrecoClienteRoot = criteria.from(ProdutoPrecoCliente.class);
		
		Subquery<BigDecimal> subquery = criteria.subquery(BigDecimal.class);
		Root<ProdutoPrecoCliente> produtoPrecoClienteSub = subquery.from(ProdutoPrecoCliente.class);
		subquery.select(produtoPrecoClienteSub.<BigDecimal>get("preco"));
		Predicate codigoClientePredicate = builder.equal(produtoPrecoClienteSub.get("codigoCliente"), 1L);
		Predicate codigoProdutoPredicate = builder.equal(produtoPrecoClienteSub.get("codigoProduto"), produto.get("codigo"));
		subquery.where(codigoClientePredicate, codigoProdutoPredicate);
		Expression<Boolean> condicaoWhen = builder.isNotNull(subquery);
			
		criteria.select(builder.construct(PrecoProduto.class
											, produto.<Long>get("codigo")
											, builder.selectCase()
												.when(condicaoWhen, produtoPrecoClienteRoot.get("preco"))
												.when(builder.equal(cliente.get("tabelaPrecoPadrao"), 3), produto.get("preco3"))
												.when(builder.equal(cliente.get("tabelaPrecoPadrao"), 2), produto.get("preco2"))
												.otherwise(produto.get("preco1"))
										)
						);
		
		criteria.groupBy(produto.get("codigo"));
		
		TypedQuery<PrecoProduto> query = manager.createQuery(criteria);
		List<PrecoProduto> precosProdutos = query.getResultList();
		
		for (PrecoProduto pp : precosProdutos) {
			System.out.printf("Código: %d. Preço: R$%.2f\n", pp.getCodigo(), pp.getPreco().doubleValue());
		}
	}
	
}
