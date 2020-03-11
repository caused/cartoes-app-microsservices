package br.com.mastertech.fatura.dto;

import java.math.BigDecimal;

public class FaturaDTO {
	private Long id;
	private BigDecimal valorPago;
	private String pagoEm;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValorPago() {
		return valorPago;
	}
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	public String getPagoEm() {
		return pagoEm;
	}
	public void setPagoEm(String pagoEm) {
		this.pagoEm = pagoEm;
	}
	
	
}
