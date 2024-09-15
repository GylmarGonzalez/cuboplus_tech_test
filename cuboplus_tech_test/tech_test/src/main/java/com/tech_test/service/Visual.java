package com.tech_test.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import com.tech_test.data.HalvingDetailData;
import com.tech_test.data.ResponseData;
import com.tech_test.util.Parameters;

public class Visual {
	
	
	private List<ResponseData> runProcess;
	
	private Scanner scaner = new Scanner(System.in);
	
	// to print format number 
	private  DecimalFormatSymbols located = DecimalFormatSymbols.getInstance(Locale.US);
	private  DecimalFormat formatBigNumber = new DecimalFormat("###,###,###,###,###.00", located);
	private  DecimalFormat formatBigDecimal = new DecimalFormat("###,###,###,###,###.00000000", located);
	
	

	public Visual(List<ResponseData> runProcess) {
		super();
		formatBigDecimal.setRoundingMode(RoundingMode.DOWN);
		this.runProcess = runProcess;
	}
	
	// principal menu
	public void consoleInterfaceUser() {
		String option = null;
		do {
			header();
		    option = scaner.nextLine();
		    switch(option) {
		      case "1":
		    	  optcion1();
		        break;
		      case "2":
		        System.out.println("Write the especific Number Block.");
		        Integer block = Integer.parseInt(scaner.nextLine());
		        option2(block);
		        break;
		      case "3":
			        System.out.println("See you !!!");
			        break;
		      default:
		    	  header();
		    }
		} while (! option.equalsIgnoreCase("3"));
	}
	
	
	private void header() {
		System.out.println("|----------------------------------------------------------------|");
		System.out.println("|------------------      Wellcome         -----------------------|");
		System.out.println("|------------------ Please select one option number -------------|");
		System.out.println("|------------------     Menu  -----------------------------------|");
		System.out.println("|-1)Result for each halving   -----------------------------------|");
		System.out.println("|-2)Search block               -----------------------------------|");
		System.out.println("|-3)Exit                      -----------------------------------|");
		System.out.println("|----------------------------------------------------------------|");
	}
	
	// I see when the block change the suply and rewar value for example block 210000
	private void option2(Integer block) {
		runProcess.forEach(data -> {
			HalvingDetailData blockfinder = data.getDetail().stream()
					  .filter(detail -> block.toString().equalsIgnoreCase(detail.getBlock().toString()) )
					  .findAny()
					  .orElse(null);
			if(blockfinder != null) {
				System.out.println("|----------------------------------------------------------------|");
				System.out.println("|Block : "+block);
				System.out.println("|Suply :  BTC  "+formatBigNumber.format(blockfinder.getSuply()));
				System.out.println("|Reward : BTC "+formatBigDecimal.format(blockfinder.getReward()));
			}
		});
		System.out.println("|----------------------------------------------------------------|");
	}
	
	// print all the informacion for test
	private void optcion1() {
		System.out.println("|----------------------------------------------------------------|");
		for (ResponseData responseData : runProcess) {
			System.out.println("|Halving : "+responseData.getHalving());
			System.out.println("|The total Bitcoin supply after each halving.");
			System.out.println("|BTC: "+formatBigNumber.format(responseData.getSuplyStage()));
			System.out.println("|The block reward at each stage.");
			System.out.println("|BTC:"+formatBigDecimal.format(responseData.getRewardStage()) +
							    " SATS:"+formatBigNumber.format(convertToSatoschi(responseData.getRewardStage())));
			System.out.println("|The percentage of the total 21 million bitcoins. ");
			System.out.println("|"+formatBigDecimal.format(responseData.getPercentajeOfTotal())+"%");
			System.out.println("|----------------------------------------------------------------|");
			System.out.println("");
		}

	}
	
	private BigDecimal convertToSatoschi(BigDecimal btc){
		return btc.multiply(new BigDecimal(Parameters.CONVERT_TO_SATS));
	}
	
	


}
