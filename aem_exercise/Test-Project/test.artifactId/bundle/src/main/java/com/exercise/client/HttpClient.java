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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.exercise.util.JsonUtil;

/*This is the client class 
 * 
 */
@Component(immediate = true, name = "http Service")
@Service(HttpClient.class)
public class HttpClient {

	public static JSONObject executeGet(String url) {
		String responseBody = null;
		JSONObject jsonResponseObject = null;
		try {
			URL endPointUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) endPointUrl.openConnection();

			conn.setRequestMethod("GET");

			InputStream is = conn.getInputStream();

			StringWriter writer = new StringWriter();
			IOUtils.copy(is, writer, StandardCharsets.UTF_8);
			responseBody = writer.toString();
			jsonResponseObject = getJsonResponse(responseBody);
			conn.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonResponseObject;
	}

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
					Map<String, JSONArray> items = new HashMap<String, JSONArray>();
					items.put("items", jsonArrayResponse);
					jsonResponseObject = JsonUtil.convertJavaObjectToJsonObject(items);
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// TODO Auto-generated method stub
		return jsonResponseObject;
	}
}
