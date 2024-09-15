package com.tech_test.data;

import java.math.BigDecimal;
import java.util.List;

public class ResponseData {
	
	private Integer halving;
	private BigDecimal suplyStage;
	private BigDecimal rewardStage;
	private BigDecimal percentajeOfTotal;
	private List<HalvingDetailData> detail;
	
	public Integer getHalving() {
		return halving;
	}
	public void setHalving(Integer halving) {
		this.halving = halving;
	}
	public BigDecimal getRewardStage() {
		return rewardStage;
	}
	public void setRewardStage(BigDecimal rewardStage) {
		this.rewardStage = rewardStage;
	}
	public BigDecimal getPercentajeOfTotal() {
		return percentajeOfTotal;
	}
	public void setPercentajeOfTotal(BigDecimal percentajeOfTotal) {
		this.percentajeOfTotal = percentajeOfTotal;
	}
	public List<HalvingDetailData> getDetail() {
		return detail;
	}
	public void setDetail(List<HalvingDetailData> detail) {
		this.detail = detail;
	}
	public BigDecimal getSuplyStage() {
		return suplyStage;
	}
	public void setSuplyStage(BigDecimal suplyStage) {
		this.suplyStage = suplyStage;
	}

}
