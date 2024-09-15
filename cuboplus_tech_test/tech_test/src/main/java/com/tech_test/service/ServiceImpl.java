package com.tech_test.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tech_test.data.HalvingData;
import com.tech_test.data.HalvingDetailData;
import com.tech_test.data.ResponseData;
import com.tech_test.util.Parameters;

public class ServiceImpl {
	
	Logger logger = Logger.getLogger(ServiceImpl.class.getName());
	
	List<HalvingData> data;

	public ServiceImpl() {
		super();
	}
	
	public ServiceImpl(List<HalvingData> data) {
		super();
		this.data = data;
	}
	
	
	public List<ResponseData> runProcess(){
		List<ResponseData> responseDataList = new ArrayList<>();
		for (HalvingData halving : data) { // iterate 32 halvin
			ResponseData responseData = new ResponseData();
			List<HalvingDetailData> detailList = new ArrayList<>();
			int count = 1;
			// start process the minimum to maximus for each halving
			logger.log(Level.INFO, "start halving number "+halving.getHalving()+" processing");
			for(Integer i = halving.getMinimo() ;i <= halving.getMaximo();i++) {
				HalvingDetailData detail = new HalvingDetailData();
				detail.setBlock(i);
				if(i == 0) {// only the first iterate the reward is equal to suply
					detail.setSuply(halving.getReward());
					detail.setReward(halving.getReward());
				}else {
					if(count == 1) { // when  search in the last list of last halving 
						HalvingDetailData lastDetailAfterToFirstHalving = getLastDetailAfterToFirstHalving(responseDataList);
						detail.setSuply(halving.getReward().add(lastDetailAfterToFirstHalving.getSuply()));
						detail.setReward(halving.getReward());
					}else {
						HalvingDetailData halvingDetailDataAnt = detailList.get(count -2);
						detail.setSuply(halving.getReward().add(halvingDetailDataAnt.getSuply()));
						detail.setReward(halving.getReward());
					}

				}
				count++;
				detailList.add(detail);
			}

			responseData.setDetail(detailList); // detail the all block of each halving
			responseData.setHalving(halving.getHalving());
			responseData.setRewardStage(halving.getReward()); // get last reward of block the halving
			responseData.setSuplyStage(detailList.get(detailList.size()-1).getSuply()); //maximum value of after the nex halving
			responseData.setPercentajeOfTotal(getPercentajeHalve(responseData.getSuplyStage())); // calculate percentage
			responseDataList.add(responseData);
			logger.log(Level.INFO, "finish halving number "+halving.getHalving()+" processing");
		}

		return responseDataList;
	}
	
	private HalvingDetailData getLastDetailAfterToFirstHalving(List<ResponseData> responseDataList) {
		 Integer location = responseDataList.size() - 1 ; //get the last halve
		 ResponseData responseData = responseDataList.get(location);
		 Integer locationDetail = responseData.getDetail().size() -1 ; // get the last detail
		 return responseData.getDetail().get(locationDetail); // return the last detail
	}
	
	// for calculate percentaje
	private BigDecimal getPercentajeHalve(BigDecimal suplyStage) {
		BigDecimal total = new BigDecimal(Parameters.MAX_BITCOIN);
		BigDecimal divide = suplyStage.divide(total);
		BigDecimal percentage = divide.multiply(new BigDecimal(Parameters.PERCENTAGE));
		return percentage;
	}
	
	

}
