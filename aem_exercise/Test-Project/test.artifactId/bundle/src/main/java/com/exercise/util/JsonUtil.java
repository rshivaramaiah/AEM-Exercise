package com.exercise.util;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exercise.sightly.BlogSightly;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * This class file is used for defining the JSON utility functions. 
 * 
 * @author rshiv2
 * 
 */
public final class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();
    public static final Logger LOG = LoggerFactory.getLogger(BlogSightly.class);
    
    static {
        mapper = mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper = mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
        mapper = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper = mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    private JsonUtil() {
        super();
    }

    /**
     * converts java object to json object
     * 
     * @param obj
     *            java object
     * @return JSONObject
     */
    public static JSONObject convertJavaObjectToJsonObject(Object obj) {
        JSONObject jsonObj = null;
        if (null != obj) {
            try {
                String jsonString = mapper.writeValueAsString(obj);
                if (StringUtils.isNotEmpty(jsonString)) {
                    jsonObj = convertStringToJsonObject(jsonString);
                }
            } catch (IOException e) {
            	LOG.error("IOException {}", e);
            }
        }
        return jsonObj;
    }
    
    /** This converts string to json object.
     * @param input
     * @return
     */
    public static JSONObject convertStringToJsonObject(String input) {
        JSONObject jsonObj = null;
        try {
            JSONParser parser = new JSONParser();
            // parse the input string
            jsonObj = (JSONObject) parser.parse(input);

        } catch (ParseException e) {
        	LOG.error("ParseException {}", e);
        }
        return jsonObj;
    }

    public static Object convertJsonToJavaObject(String json, Class clazz) {
        Object obj = null;
        if (StringUtils.isNotEmpty(json)) {
            try {
                obj = mapper.readValue(json, clazz);
            } catch (IOException e) {
            	LOG.error("IOException {}", e);
            }
        }

        return obj;
    }
}
