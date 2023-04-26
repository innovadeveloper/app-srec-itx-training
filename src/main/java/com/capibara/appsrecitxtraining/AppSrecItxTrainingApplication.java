package com.capibara.appsrecitxtraining;

import com.capibara.appsrecitxtraining.config.CompanyResponseMappingConfiguration;
import com.capibara.appsrecitxtraining.config.MockConfiguration;
import com.capibara.appsrecitxtraining.config.ResponseEquivalenceMappingConfiguration;
import com.capibara.appsrecitxtraining.models.RestMappingOperation;
import com.capibara.appsrecitxtraining.q2.second_sprint.app.App;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class AppSrecItxTrainingApplication implements CommandLineRunner {

	@Autowired
	private MockConfiguration mockConfiguration;

	@Autowired
	private CompanyResponseMappingConfiguration companyResponseMappingConfiguration;

	@Autowired
	private ResponseEquivalenceMappingConfiguration responseEquivalenceMappingConfiguration;

	@Autowired
	private App app;

	private static Logger LOG = LoggerFactory
			.getLogger(AppSrecItxTrainingApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(AppSrecItxTrainingApplication.class, args);
	}

	@Override
	public void run(String... args) {
		app.startParse(companyResponseMappingConfiguration.getRest());
		ResponseEquivalenceMappingConfiguration responseEquivalenceMappingConfiguration2222 = responseEquivalenceMappingConfiguration;
		LOG.info("EXECUTING : command line runner");
//		for (int i = 0; i < args.length; ++i) {
//			LOG.info("args[{}]: {}", i, args[i]);
//		}
	}

}
