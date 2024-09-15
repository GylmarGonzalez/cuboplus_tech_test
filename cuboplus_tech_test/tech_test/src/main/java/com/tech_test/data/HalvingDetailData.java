package com.tech_test.data;

import java.math.BigDecimal;

public class HalvingDetailData {
	
	private Integer block;
	private BigDecimal suply;
	private BigDecimal reward;
	
	public BigDecimal getSuply() {
		return suply;
	}
	public void setSuply(BigDecimal suply) {
		this.suply = suply;
	}
	public BigDecimal getReward() {
		return reward;
	}
	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}
	public Integer getBlock() {
		return block;
	}
	public void setBlock(Integer block) {
		this.block = block;
	}

}
