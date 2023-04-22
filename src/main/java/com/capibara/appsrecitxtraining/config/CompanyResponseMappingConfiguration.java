package com.capibara.appsrecitxtraining.config;


import com.capibara.appsrecitxtraining.models.RestMappingOperation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "company-response-mapping", ignoreInvalidFields = true)
@ToString
public class CompanyResponseMappingConfiguration {
    private ArrayList<RestMappingOperation> rest;
}