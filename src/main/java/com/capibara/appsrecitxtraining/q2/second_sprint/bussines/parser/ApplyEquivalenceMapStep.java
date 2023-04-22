package com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser;

import com.capibara.appsrecitxtraining.models.RestMappingOperation;
import com.capibara.appsrecitxtraining.models.ResultValueEquivalenceOperation;
import com.capibara.appsrecitxtraining.models.ResultValueOperation;

import lombok.SneakyThrows;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Optional;
import java.util.function.BiFunction;

/**
 * <b>Class</b>: ApplyEquivalenceMapStep<br>
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
 *       <li>Apr 22, 2023 Creaci&oacute;n de Clase.
 *     </ul>
 *
 * @version 1.0 *
 */
public class ApplyEquivalenceMapStep implements Step<Triple<String, String, RestMappingOperation>, Pair<String, String>> {

  /**
   * Apply equivalences.
   *
   * @param input {@link Triple}
   * @return Pair
   * @throws StepException this exception will catch all errors.
   */
  @SneakyThrows
  @Override
  public Pair<String, String> process(Triple<String, String, RestMappingOperation> input) throws StepException {
    String resultCode = input.getLeft();
    String resultDescription = input.getMiddle();
    RestMappingOperation restMappingOperation = input.getRight();

    BiFunction<ResultValueOperation, String, Optional<ResultValueEquivalenceOperation>> findResultCodeEquivalence = (resultValueOperation, in) -> resultValueOperation.getEquivalence().stream().filter(eq ->
            eq.getIn().equals(in)
    ).findFirst();

    Optional<ResultValueEquivalenceOperation> resultCodeEquivalenceOperation  = findResultCodeEquivalence.apply(restMappingOperation.getCodes().getResultCode(), resultCode);
    Optional<ResultValueEquivalenceOperation> resultDescriptionEquivalenceOperation  = findResultCodeEquivalence.apply(restMappingOperation.getCodes().getResultDescription(), resultDescription);
    if(resultCodeEquivalenceOperation.isPresent()){
      resultCode = resultCodeEquivalenceOperation.get().getOut();
    }
    if(resultDescriptionEquivalenceOperation.isPresent()){
      resultDescription = resultDescriptionEquivalenceOperation.get().getOut();
    }
    return Pair.of(resultCode, resultDescription);
  }
}
