package com.exercise.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.http.client.methods.HttpGet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exercise.constants.Constants;
import com.exercise.util.JsonUtil;

/**
 * This class is used to hit the third party over http get the response and send
 * it in json format,
 * 
 * @author rshiv2
 *
 */
@Component(immediate = true, name = "http Service")
@Service(HttpClient.class)
public class HttpClient {

	public static final Logger LOG = LoggerFactory.getLogger(HttpClient.class);

	/**
	 * This http get method,
	 * 
	 * @param url
	 *            url
	 * @return JSON object
	 */
	public static JSONObject executeGet(String url) {
		String responseBody = null;
		JSONObject jsonResponseObject = null;
		HttpURLConnection conn = null;
		try {
			URL endPointUrl = new URL(url);
			conn = (HttpURLConnection) endPointUrl.openConnection();
			conn.setRequestMethod(HttpGet.METHOD_NAME);
			InputStream inputStream = conn.getInputStream();

			// convert the input stream to json format
			if (null != inputStream) {
				StringWriter writer = new StringWriter();
				IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8);
				responseBody = writer.toString();
				jsonResponseObject = getJsonResponse(responseBody);
			}

		} catch (MalformedURLException e) {
			LOG.error("MalformedURLException {}", e);
		} catch (IOException e) {
			LOG.error("IOException {}", e);
		} finally {
			if (null != conn) {
				// Close the http connection
				conn.disconnect();
			}

		}

		return jsonResponseObject;
	}

	/**
	 * Convert the response string to json format
	 * 
	 * @param responseBody
	 * @return
	 */
	private static JSONObject getJsonResponse(String responseBody) {
		JSONArray jsonArrayResponse = null;
		JSONObject jsonResponseObject = null;
		if (StringUtils.isNotBlank(responseBody)) {
			Object obj;
			try {
				obj = new JSONParser().parse(responseBody);
				if (obj instanceof JSONObject) {
					jsonResponseObject = (JSONObject) obj;

				} else {
					jsonArrayResponse = (JSONArray) obj;
					Map<String, JSONArray> items = new HashMap<>();
					items.put(Constants.ITEMS, jsonArrayResponse);
					jsonResponseObject = JsonUtil.convertJavaObjectToJsonObject(items);
				}

			} catch (ParseException e) {
				LOG.error("JSON parse exception {}", e);
			}

		}
		return jsonResponseObject;
	}
}
