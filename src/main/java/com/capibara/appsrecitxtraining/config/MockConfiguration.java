package com.capibara.appsrecitxtraining.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "dynamic-mocks", ignoreInvalidFields = true)
@ToString
public class MockConfiguration {
    private String fullName;
    private List<com.capibara.appsrecitxtraining.models.MockConfiguration> mockConfigurations;
}