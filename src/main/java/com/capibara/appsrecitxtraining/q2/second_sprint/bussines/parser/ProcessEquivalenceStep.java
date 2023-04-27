package com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser;

import com.capibara.appsrecitxtraining.AppSrecItxTrainingApplication;
import com.capibara.appsrecitxtraining.config.ResponseEquivalenceMappingConfiguration;
import com.capibara.appsrecitxtraining.q2.second_sprint.constants.Constants;
import com.capibara.appsrecitxtraining.q2.second_sprint.models.ComplexEquivalence;
import com.capibara.appsrecitxtraining.q2.second_sprint.models.GenericModelEquivalence;
import com.capibara.appsrecitxtraining.q2.second_sprint.models.InternalProperty;
import com.capibara.appsrecitxtraining.q2.second_sprint.models.ResponseDTO;
import com.capibara.appsrecitxtraining.q2.second_sprint.models.SimpleEquivalence;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * <b>Class</b>: ProcessEquivalenceStep<br>
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
public class ProcessEquivalenceStep implements Step<String, String> {

  private final String DEFAULT = "default";
  ResponseDTO responseDTO;
  ResponseEquivalenceMappingConfiguration responseEquivalenceMappingConfiguration;

  private static Logger LOG = LoggerFactory
          .getLogger(ProcessEquivalenceStep.class);



  public ProcessEquivalenceStep(ResponseDTO responseDTO, ResponseEquivalenceMappingConfiguration responseEquivalenceMappingConfiguration) {
    this.responseDTO = responseDTO;
    this.responseEquivalenceMappingConfiguration = responseEquivalenceMappingConfiguration;
  }

//   * Process mapping operation.
//   *
//   * @param input {@link String}
//   * @return Pair
//   * @throws StepException this exception will catch all errors.
//   */
//  @SneakyThrows
//  @Override
//  public Triple<String, String, RestMappingOperation> process(String input) throws StepException {
//    JsonNode jsonNode = new ObjectMapper().readTree(input);
//    Function<String, Optional<RestMappingOperation>> findRestMapping =
//            interfaceCode -> this.restMappingOperations.stream()
//                    .filter(r -> r.getId().stream().anyMatch(id -> id.equals(interfaceCode))).findFirst();
//    Function<String, String> findValueByKeyProperty =
//            keyProperty -> {
//              try{
//                return jsonNode.path(keyProperty).asText();
//              }catch (Exception e){
//                e.printStackTrace();
//              }
//             return StringUtils.EMPTY;
//            };
//
//    Optional<RestMappingOperation> restMappingOperation = findRestMapping.apply(this.interfaceCode);
//    if(restMappingOperation.isEmpty()){
//      restMappingOperation = findRestMapping.apply(DEFAULT);
//    }
//    if(restMappingOperation.isPresent()){
//      String resultCode = findValueByKeyProperty.apply(restMappingOperation.get().getCodes().getResultCode().getKeyProperty());
//      String resultDescription = findValueByKeyProperty.apply(restMappingOperation.get().getCodes().getResultDescription().getKeyProperty());
//      return Triple.of(resultCode, resultDescription, restMappingOperation.get());
//    }
//    throw new StepException(new Exception("¡Response properties not found!"));
//  }

  /**
   * return true if the company is parametric.
   * @param interfaceCode int
   * @return boolean
   */
  boolean isParametricCompany(int interfaceCode){ // fixme : modificar el nombre del atributo correspondiente..
    return interfaceCode == Constants.PARAMETRIC_COMPANY_CODE;
  }

  void processParametricEquivalences(List<ComplexEquivalence> complexEquivalenceList, ResponseDTO responseDTO){
    complexEquivalenceList.forEach( ce -> processIn(ce.getIn().getInternal(), responseDTO));
  }

  boolean processIn(HashMap<String, InternalProperty> map, ResponseDTO responseDTO){
    LOG.info("__");
    return true;
  }

  @Override
  public String process(String input) throws StepException {
    try {
      JsonNode jsonNode = new ObjectMapper().readTree(input);
      if(isParametricCompany(Integer.parseInt(responseDTO.getInterfaceConnectivityCode()))){
        Optional<GenericModelEquivalence<ComplexEquivalence>> genericModelEquivalence = responseEquivalenceMappingConfiguration.getParametric().stream().filter(parametricCompany ->
                parametricCompany.getCompaniesList().stream().anyMatch(companyId -> companyId.equals(responseDTO.getInterfaceCode()))
        ).findFirst();
        if(genericModelEquivalence.isPresent()){
          processParametricEquivalences(genericModelEquivalence.get().getEquivalences(), responseDTO);
          LOG.info("generic model equivalence..");
        }
      }else{
        Optional<GenericModelEquivalence<SimpleEquivalence>> genericModelEquivalence = responseEquivalenceMappingConfiguration.getGeneric().stream().findFirst();
        if(genericModelEquivalence.isPresent()){
          LOG.info("generic model equivalence..");
        }
      }
    } catch (JsonProcessingException e) {
      throw new StepException(e);
    }
    return null;
  }
}
