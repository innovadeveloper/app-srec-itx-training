package com.capibara.appsrecitxtraining.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * <br/> Clase que configura los mocks para un tipo de operacion.
 * <b>Class</b>: MockConfiguration<br/>
 * Copyright: &copy; 2020 Banco de Cr&eacute;dito del Per&uacute;.<br/>
 * Company: Banco de Cr&eacute;dito del Per&uacute;.<br/>
 *
 * @author Banco de Cr&eacute;dito del Per&uacute; (BCP) <br/>
 * <u>Service Provider</u>: everis <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Jose Alvino</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Abr 06, 2022 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
public class MockConfiguration {
    private String serviceType;
    private String description;
    private List<MockedOperation> mocks;
}
