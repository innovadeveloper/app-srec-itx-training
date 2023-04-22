package com.capibara.appsrecitxtraining.q2.second_sprint.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ConnectionResponse {
    String resultDescription;
    int statusCode;
}
