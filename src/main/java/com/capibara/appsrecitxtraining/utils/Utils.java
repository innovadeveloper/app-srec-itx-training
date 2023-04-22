package com.capibara.appsrecitxtraining.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


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
}
