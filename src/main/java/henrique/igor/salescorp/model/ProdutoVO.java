package henrique.igor.salescorp.model;

import java.math.BigDecimal;

public class ProdutoVO {
	private Integer codProd;
	private String descrProd;
	private BigDecimal vlrVenda;
	private String ativo = "S";
	
	public ProdutoVO() {}
	
	public ProdutoVO(Integer codProd, String descrProd, BigDecimal vlrVenda, String ativo) {
		this.codProd = codProd;
		this.descrProd = descrProd;
		this.vlrVenda = vlrVenda;
		this.ativo = ativo;
	}
	
	public int getCodProd() {return codProd;}
	public void setCodProd(Integer codProd) {this.codProd = codProd;}

	public String getDescrProd() {return descrProd;}
	public void setDescrProd(String descrProd) {this.descrProd = descrProd;}

	public BigDecimal getVlrVenda() {return vlrVenda;}
	public void setVlrVenda(BigDecimal vlrVenda) {
		if(vlrVenda.compareTo(BigDecimal.ZERO) < 0) {
			System.err.println("Valor de venda não pode ser negativo");
		}
		this.vlrVenda = vlrVenda;
	}

	public String getAtivo() {return ativo;}
	public void setAtivo(String ativo) {this.ativo = ativo;}

	@Override
	public String toString() {
		return "ProdutoVO [codProd=" + codProd + ", descrProd=" + descrProd + ", vlrVenda=" + vlrVenda + ", ativo="
				+ ativo + "]";
	}
}
