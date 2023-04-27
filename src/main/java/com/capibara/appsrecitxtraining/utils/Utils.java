package com.capibara.appsrecitxtraining.utils;

import com.fasterxml.jackson.databind.JsonNode;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;


public class Utils {
    /**
     * Generate textPlain.
     *
     * @param path path
     * @return object
     */
    public static String getTextPlain(String path) {
        try {
            return new String(new ClassPathResource(path).getInputStream()
                    .readAllBytes(), StandardCharsets.UTF_8).replaceAll("[\r\n\t]", StringUtils.EMPTY);
        } catch (IOException e) {
//            log.error("ERROR {}", e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * capture response field (JSON) by path.
     *
     * @param node {@link JsonNode}
     * @param path {@link List}
     * @return String
     */
    public static String getResponseField(JsonNode node, List<String> path) {
        Iterator<String> pathIterator = path.iterator();
        JsonNode jsonNode = node;
        while (pathIterator.hasNext()) {
            jsonNode = jsonNode.get(pathIterator.next());
        }
        return jsonNode.asText();
    }
}
