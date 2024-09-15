package com.tech_test.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.tech_test.data.HalvingData;
import com.tech_test.util.Parameters;

public class Init {
	
	Logger logger = Logger.getLogger(Init.class.getName());
	
	private List<HalvingData> listOfHalving;
	
	private Integer blockGeneral = Parameters.BLOCK_GENERAL;

	public Init() {
		super();
		listOfHalving = new ArrayList<>();
		Integer blockAnt = 0;
		BigDecimal reward = new BigDecimal(Parameters.HALVING_INITIAL);
		BigDecimal rewardAnt = BigDecimal.ZERO;
		logger.log(Level.INFO, "start halving processing");
		for(int i=1;i <= 32;i++) { // iterate 32 halving
			HalvingData halving = new HalvingData();
			halving.setHalving(i);
			
			// this process aply the minimun and maximus block per halving
			if(i == 1) { //only the first iterate
				rewardAnt = reward;
				halving.setMinimo(0);
				blockAnt = blockGeneral -1;
				halving.setMaximo(blockAnt);
			}else { // before the first iterate this process aply
				rewardAnt = rewardAnt.divide(new BigDecimal(Parameters.HALVING_DIVIDE));
				halving.setMinimo(blockAnt + 1);
				blockAnt = blockAnt +blockGeneral;
				halving.setMaximo(blockAnt);
			}

			halving.setReward(rewardAnt); // only the first iterate set 50, later set de value / 2
			listOfHalving.add(halving);
		}
		logger.log(Level.INFO, "finish halving processing");
	}

	public List<HalvingData> getListOfHalving() {
		return listOfHalving;
	}

	public void setListOfHalving(List<HalvingData> listOfHalving) {
		this.listOfHalving = listOfHalving;
	}

}
