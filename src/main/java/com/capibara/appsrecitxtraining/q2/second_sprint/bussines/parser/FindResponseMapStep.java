package com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser;

import com.capibara.appsrecitxtraining.models.RestMappingOperation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

/**
 * <b>Class</b>: FindResponseMapStep<br>
 * Copyright: &copy; 2023 Banco de Cr&eacute;dito del Per&uacute;.<br>
 * Company: Banco de Cr&eacute;dito del Per&uacute;.<br>
 *
 * @author Banco de Cr&eacute;dito del Per&uacute; (BCP) <br>
 *     <u>Service Provider</u>: bcp <br>
 *     <u>Developed by</u>: <br>
 *     <ul>
 *       <li>Kane Baltazar Alanoca
 *     </ul>
 *     <u>Changes</u>:<br>
 *     <ul>
 *       <li>Mar 07, 2023 Creaci&oacute;n de Clase.
 *     </ul>
 *
 * @version 1.0 *
 */
public class FindResponseMapStep implements Step<String, Triple<String, String, RestMappingOperation>> {

  private final String DEFAULT = "default";
  String interfaceCode;
  ArrayList<RestMappingOperation> restMappingOperations;

  public FindResponseMapStep(String interfaceCode, ArrayList<RestMappingOperation> restMappingOperations) {
    this.interfaceCode = interfaceCode;
    this.restMappingOperations = restMappingOperations;
  }

  /**
   * Process mapping operation.
   *
   * @param input {@link String}
   * @return Pair
   * @throws StepException this exception will catch all errors.
   */
  @SneakyThrows
  @Override
  public Triple<String, String, RestMappingOperation> process(String input) throws StepException {
    JsonNode jsonNode = new ObjectMapper().readTree(input);
    Function<String, Optional<RestMappingOperation>> findRestMapping =
            interfaceCode -> this.restMappingOperations.stream()
                    .filter(r -> r.getId().stream().anyMatch(id -> id.equals(interfaceCode))).findFirst();
    Function<String, String> findValueByKeyProperty =
            keyProperty -> {
              try{
                return jsonNode.path(keyProperty).asText();
              }catch (Exception e){
                e.printStackTrace();
              }
             return StringUtils.EMPTY;
            };

    Optional<RestMappingOperation> restMappingOperation = findRestMapping.apply(this.interfaceCode);
    if(restMappingOperation.isEmpty()){
      restMappingOperation = findRestMapping.apply(DEFAULT);
    }
    if(restMappingOperation.isPresent()){
      String resultCode = findValueByKeyProperty.apply(restMappingOperation.get().getCodes().getResultCode().getKeyProperty());
      String resultDescription = findValueByKeyProperty.apply(restMappingOperation.get().getCodes().getResultDescription().getKeyProperty());
      return Triple.of(resultCode, resultDescription, restMappingOperation.get());
    }
    throw new StepException(new Exception("¡Response properties not found!"));
  }
}
