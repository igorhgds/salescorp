package henrique.igor.salescorp.model;

public class ParceiroVO {
	private Integer codParc;
	private String nomeParc;
	private String tipPessoa;
	
	public ParceiroVO() {}
	
	public ParceiroVO(Integer codParc, String nomeParc, String tipPessoa) {
		this.codParc = codParc;
		this.nomeParc = nomeParc;
		this.tipPessoa = tipPessoa;
	}
	
	public Integer getCodParc() {return codParc;}
	public void setCodParc(Integer codParc) {this.codParc = codParc;}
	
	public String getnomeParc() {return nomeParc;}
	public void setNomeParc(String nomeParc) {this.nomeParc = nomeParc;}
	
	public String gettipPessoa() {return tipPessoa;}
	public void setTipPessoa(String tipPessoa) {this.tipPessoa = tipPessoa;}

	@Override
	public String toString() {
		return "ParceiroVO [Código=" + codParc + ", Nome=" + nomeParc + ", Tipo=" + tipPessoa + "]";
	}
}
