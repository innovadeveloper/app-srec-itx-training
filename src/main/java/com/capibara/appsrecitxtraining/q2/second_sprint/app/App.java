package com.capibara.appsrecitxtraining.q2.second_sprint.app;

import com.capibara.appsrecitxtraining.config.ResponseEquivalenceMappingConfiguration;
import com.capibara.appsrecitxtraining.models.RestMappingOperation;
import com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser.ApplyEquivalenceMapStep;
import com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser.FindResponseMapStep;
import com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser.Pipeline;
import com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser.ProcessEquivalenceStep;
import com.capibara.appsrecitxtraining.q2.second_sprint.models.ResponseDTO;
import com.capibara.appsrecitxtraining.utils.Utils;
import com.google.gson.Gson;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class App {

    private static final String PATH_BASE = "json/cases/response_claro/";
//    private static final String JSON_OK = PATH_BASE.concat("ok.json");
//    private static final String CLARO_JSON_OK = PATH_BASE.concat("claro_ok.json");
    private static final String CLARO_JSON_CASO_1 = PATH_BASE.concat("caso_1_cp0000.json");
    private static final String CLARO_JSON_CASO_2 = PATH_BASE.concat("caso_2_cp0006.json");
    private static final String CLARO_JSON_CASO_3 = PATH_BASE.concat("caso_3_cp0010.json");
    private static final String CLARO_JSON_CASO_4 = PATH_BASE.concat("caso_4_cp0141.json");
    private static final String CLARO_JSON_CASO_5 = PATH_BASE.concat("caso_5_cp0140.json");
    private static final String CLARO_JSON_CASO_6 = PATH_BASE.concat("caso_6_cp0140.json");
    private static final String CLARO_JSON_CASO_7 = PATH_BASE.concat("caso_7_cp0140.json");
    private static final String CLARO_JSON_CASO_8 = PATH_BASE.concat("caso_8_cp0140.json");
    private static final String CLARO_JSON_CASO_9 = PATH_BASE.concat("caso_9_cp0138.json");
    private static final String CLARO_JSON_CASO_10 = PATH_BASE.concat("caso_10_cp0006.json");
    private static final String CLARO_JSON_CASO_11 = PATH_BASE.concat("caso_11_cp0010.json");
    private static final String CLARO_JSON_CASO_12 = PATH_BASE.concat("caso_12_cp0138.json");
    private static final String GENERIC_JSON_CASO = PATH_BASE.concat("caso_generic_cp0133.json");

    public void main(String[] args){
//        String body = Utils.getTextPlain(JSON_OK);
//        Optional<Pair<String, String>> response =
//                Optional.of(new Pipeline<>(new JsonResponseExtractorStep()).execute(body));
//        System.out.println("__");
    }

    public void startParse(ArrayList<RestMappingOperation> restMappingOperations){
        String body = Utils.getTextPlain(CLARO_JSON_CASO_1);
        Optional<Pair<String, String>> response =
                Optional.of(new Pipeline<>(
                        new FindResponseMapStep("CLAROSM", restMappingOperations))
                        .pipe(new ApplyEquivalenceMapStep()).execute(body));
        System.out.println("__");
    }

    public void startParsev2(ResponseEquivalenceMappingConfiguration responseEquivalenceMappingConfiguration){
        String body = Utils.getTextPlain(CLARO_JSON_CASO_1);
        ResponseDTO responseDTO = new Gson().fromJson(body, ResponseDTO.class);

//        HashMap<String, String> responseMap = new HashMap<>();
//        responseMap.put(Constants.INTERFACE_CODE_PROPERTY, responseDTO.getInterfaceCode());
//        responseMap.put(Constants.PLOT_PROPERTY, new Gson().toJson());

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Pipeline<>(
                        new ProcessEquivalenceStep(responseDTO, responseEquivalenceMappingConfiguration)).execute(body);
            }
        }).start();
//        System.out.println("__");
        while (true){

        }
    }


}
