package com.kuchipudi.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("TPT Script Execution start ");
		int exitValue = 0;
		try {
			String tptFileName = "C://TPTScripts//export_script.tpt";
			String tptArgs = "tbuild" + " " + "-f" + " " + tptFileName;
			exitValue = Runtime.getRuntime().exec(tptArgs).waitFor();
			if (exitValue > 0) {
				System.out.println("TPT Script Executed sucessfull");
			}
			System.out.println("TPT Script Execution end ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(1);
		}
	}

}
