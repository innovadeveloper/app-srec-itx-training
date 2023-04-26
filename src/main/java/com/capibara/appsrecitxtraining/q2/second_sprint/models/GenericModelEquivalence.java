package com.capibara.appsrecitxtraining.q2.second_sprint.models;

import com.capibara.appsrecitxtraining.models.RestCodesOperation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * <b>Class</b>: GenericEquivalence<br/>
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
public class GenericModelEquivalence<T extends ModelEquivalence>  {
    private String companyIds;
    private String description;
    private List<T> equivalences;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GenericModelEquivalence that = (GenericModelEquivalence) o;

        return new EqualsBuilder()
                .append(companyIds, that.companyIds).append(description, that.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(companyIds).append(description)
                .toHashCode();
    }
}
