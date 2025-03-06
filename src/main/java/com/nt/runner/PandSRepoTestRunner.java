package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorService;

@Component
public class PandSRepoTestRunner implements CommandLineRunner {

	
	@Autowired
	private IDoctorService service;
	
	/**
	 *
	 */
	@Override
	public void run(String... args) throws Exception {
	
		// TODO Auto-generated method stub
		/*
	service.showDoctorBySorting(true,"docName").forEach(System.out::println);
	System.out.println("--------");
	service.showDoctorBySorting(false, "income","docName").forEach(System.out::println);
	
	*/
		service.showDataThroughPagination(3);
		
	}

	

}
