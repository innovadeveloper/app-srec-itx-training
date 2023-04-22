package com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser;

/**
 * <b>Class</b>: Pipeline<br>
 * Copyright: &copy; 2023 Banco de Cr&eacute;dito del Per&uacute;.<br>
 * Company: Banco de Cr&eacute;dito del Per&uacute;.<br>
 *
 * @author Banco de Cr&eacute;dito del Per&uacute; (BCP) <br>
 *     <u>Service Provider</u>: Everis Company <br>
 *     <u>Developed by</u>: <br>
 *     <ul>
 *       <li>Kane Baltazar Alanoza
 *     </ul>
 *     <u>Changes</u>:<br>
 *     <ul>
 *       <li>Mar 07, 2023 Creaci&oacute;n de Clase.
 *     </ul>
 *
 * @version 1.0
 */
public class Pipeline<I, O> {
  private final Step<I, O> current;

  /**
   * constructor.
   * @param current {@link Step}
   */
  public Pipeline(Step<I, O> current) {
    this.current = current;
  }

  /**
   * Method to add one method more.
   * @param next {@link Step}
   * @param <K> NewO
   * @return Pipeline
   */
  public <K> Pipeline<I, K> pipe(Step<O, K> next) {
    return new Pipeline<>(input -> next.process(current.process(input)));
  }

  /**
   *  method to execute pipeline.
   * @param input I
   * @return O
   * @throws Step.StepException process.
   */
  public O execute(I input) throws Step.StepException {
    return current.process(input);
  }
}
