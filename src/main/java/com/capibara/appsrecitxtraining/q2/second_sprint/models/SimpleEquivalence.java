package com.capibara.appsrecitxtraining.q2.second_sprint.models;

import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * <b>Class</b>: SimpleEquivalence<br/>
 * Copyright: &copy; 2020 Banco de Cr&eacute;dito del Per&uacute;.<br/>
 * Company: Banco de Cr&eacute;dito del Per&uacute;.<br/>
 *
 * @author Banco de Cr&eacute;dito del Per&uacute; (BCP) <br/>
 * <u>Service Provider</u>: everis <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Kane Baltazar</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Abr 22, 2023 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
public class SimpleEquivalence implements ModelEquivalence{
    private String type;
    private InEquivalence in;
    private HashMap<String, OutEquivalence> out;

    @Override
    public String getType() {
        return type;
    }

}
