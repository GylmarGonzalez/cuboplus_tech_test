package com.tech_test.data;

import java.math.BigDecimal;

public class HalvingData {
	
	private Integer halving;
	private Integer minimo;
	private Integer maximo;
	private BigDecimal reward;
	

	public HalvingData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getHalving() {
		return halving;
	}
	public void setHalving(Integer halving) {
		this.halving = halving;
	}
	public Integer getMinimo() {
		return minimo;
	}
	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}
	public Integer getMaximo() {
		return maximo;
	}
	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}
	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}
	
}
