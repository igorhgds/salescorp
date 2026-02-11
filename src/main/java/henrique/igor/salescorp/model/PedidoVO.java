package henrique.igor.salescorp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoVO {
	private Integer nuNota;
    private Integer numNota;
    private LocalDate dtNeg;
    private Integer codParc;
    private BigDecimal vlrNota;
    private String status;
    
    public PedidoVO() {}
    
    public PedidoVO(Integer numNota, LocalDate dtNeg, Integer codParc, BigDecimal vlrNota, String status) {
		this.numNota = numNota;
		this.dtNeg = dtNeg;
		this.codParc = codParc;
		this.vlrNota = vlrNota;
		this.status = status;
	}

	public Integer getNuNota() { return nuNota; }
    public void setNuNota(Integer nuNota) { this.nuNota = nuNota; }
    
    public Integer getNumNota() { return numNota; }
    public void setNumNota(Integer numNota) { this.numNota = numNota; }
    
    public LocalDate getDtNeg() { return dtNeg; }
    public void setDtNeg(LocalDate dtNeg) { 
    	this.dtNeg = (dtNeg != null) ? dtNeg : LocalDate.now(); 
    	}
    
    public Integer getCodParc() { return codParc; }
    public void setCodParc(Integer codParc) { this.codParc = codParc; }
    
    public BigDecimal getVlrNota() { return vlrNota; }
    public void setVlrNota(BigDecimal vlrNota) { this.vlrNota = vlrNota; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
}
