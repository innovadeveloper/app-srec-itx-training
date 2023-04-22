package com.capibara.appsrecitxtraining.q2.second_sprint.bussines.parser;

/**
 * <b>Class</b>: Step<br>
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
public interface Step<I, O> {
  O process(I input) throws StepException;

  /**
   * <b>Class</b>: StepException<br>
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
  class StepException extends RuntimeException {
    public StepException(Throwable t) {
      super(t);
    }
  }
}
