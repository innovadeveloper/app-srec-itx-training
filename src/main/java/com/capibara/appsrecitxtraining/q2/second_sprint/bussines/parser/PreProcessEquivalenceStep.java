package com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser;

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
 * <b>Class</b>: PreProcessEquivalenceStep<br>
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
public class PreProcessEquivalenceStep implements Step<String, JsonNode> {

  private final String DEFAULT = "default";
  ResponseDTO responseDTO;
  ResponseEquivalenceMappingConfiguration responseEquivalenceMappingConfiguration;

  private static Logger LOG = LoggerFactory
          .getLogger(PreProcessEquivalenceStep.class);

  public PreProcessEquivalenceStep(ResponseDTO responseDTO, ResponseEquivalenceMappingConfiguration responseEquivalenceMappingConfiguration) {
    this.responseDTO = responseDTO;
    this.responseEquivalenceMappingConfiguration = responseEquivalenceMappingConfiguration;
  }

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
    return false;
  }

  @Override
  public JsonNode process(String input) throws StepException {
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
