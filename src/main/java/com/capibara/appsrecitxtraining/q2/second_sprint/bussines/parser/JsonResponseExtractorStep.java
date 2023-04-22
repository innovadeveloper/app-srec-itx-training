package com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;

/**
 * <b>Class</b>: JsonResponseExtractorStep<br>
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
public class JsonResponseExtractorStep implements Step<String, Pair<String, String>> {

  /**
   * Process dispatcher plot extraction.
   *
   * @param input {@link String}
   * @return Pair
   * @throws StepException this exception will catch all errors.
   */
  @SneakyThrows
  @Override
  public Pair<String, String> process(String input) throws StepException {
    JsonNode jsonNode = new ObjectMapper().readTree(input);
    return Pair.of(
        jsonNode.path("resultCode").asText(), jsonNode.path("resultDescription").asText());
  }
}
