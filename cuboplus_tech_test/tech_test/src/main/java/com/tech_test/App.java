package com.tech_test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tech_test.data.ResponseData;
import com.tech_test.service.Init;
import com.tech_test.service.ServiceImpl;
import com.tech_test.service.Visual;

/**
 * Hello world!
 */
public class App {
	
	static Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		try {
			Init init = new Init();
			ServiceImpl serviceImpl = new ServiceImpl(init.getListOfHalving());
			List<ResponseData> runProcess = serviceImpl.runProcess();
			logger.log(Level.INFO, "Finish configurator Wellcome to Monetary policy of bitcoin");
			Visual visual = new Visual(runProcess);
			visual.consoleInterfaceUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
