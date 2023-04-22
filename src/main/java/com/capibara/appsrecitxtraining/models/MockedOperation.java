package com.capibara.appsrecitxtraining.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * <br/> Clase que configura el mock de respuesta de una operacion.<br/>
 * <b>Class</b>: MockedOperation<br/>
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
 * <li>Abr 04, 2022 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
public class MockedOperation {
    private String operationType;
    private String description;
    private int httpStatus;
    private List<String> customerIds;
    private List<String> fulfillFields;
    private List<String> fulHeaders;
    private String response;
    private Long delayInMilliseconds;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MockedOperation that = (MockedOperation) o;

        return new EqualsBuilder().append(httpStatus, that.httpStatus)
                .append(operationType, that.operationType).append(description, that.description)
                .append(customerIds, that.customerIds).append(fulfillFields, that.fulfillFields)
                .append(response, that.response).append(fulHeaders, that.fulHeaders).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(operationType).append(description).append(httpStatus)
                .append(customerIds).append(fulfillFields).append(fulHeaders).append(response).toHashCode();
    }
}
