package com.capibara.appsrecitxtraining.q2.second_sprint.app;

import com.capibara.appsrecitxtraining.models.RestMappingOperation;
import com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser.ApplyEquivalenceMapStep;
import com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser.FindResponseMapStep;
import com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser.JsonResponseExtractorStep;
import com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser.Pipeline;
import com.capibara.appsrecitxtraining.utils.Utils;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class App {

    private static final String PATH_BASE = "json/";
    private static final String JSON_OK = PATH_BASE.concat("ok.json");
    private static final String CLARO_JSON_OK = PATH_BASE.concat("claro_ok.json");

    public void main(String[] args){
        String body = Utils.getTextPlain(JSON_OK);
        Optional<Pair<String, String>> response =
                Optional.of(new Pipeline<>(new JsonResponseExtractorStep()).execute(body));
        System.out.println("__");
    }

    public void startParse(ArrayList<RestMappingOperation> restMappingOperations){
        String body = Utils.getTextPlain(CLARO_JSON_OK);
        Optional<Pair<String, String>> response =
                Optional.of(new Pipeline<>(
                        new FindResponseMapStep("CLAROSM", restMappingOperations))
                        .pipe(new ApplyEquivalenceMapStep()).execute(body))
                ;
        System.out.println("__");
    }
}
