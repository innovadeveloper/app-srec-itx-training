package com.capibara.appsrecitxtraining.config;


import com.capibara.appsrecitxtraining.models.RestMappingOperation;
import com.capibara.appsrecitxtraining.q2.second_sprint.models.ComplexEquivalence;
import com.capibara.appsrecitxtraining.q2.second_sprint.models.GenericModelEquivalence;
import com.capibara.appsrecitxtraining.q2.second_sprint.models.SimpleEquivalence;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "response-equivalence-mapping", ignoreInvalidFields = true)
@ToString
public class ResponseEquivalenceMappingConfiguration {
    private ArrayList<GenericModelEquivalence<SimpleEquivalence>> generic;
    private ArrayList<GenericModelEquivalence<ComplexEquivalence>> parametric;
}