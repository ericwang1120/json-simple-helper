package org.jsonsimplehelper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONHelper {

	/**
	 * @param in
	 *            String which can be parsed into JSONObject
	 * @return
	 * @throws Exception
	 */
	public static JSONWrapper<JSONObject> findJSONObject(String in) throws Exception {
		return new JSONWrapper<JSONObject>(in);
	}

	/**
	 * @param in
	 *            String which can be parsed into JSONArray
	 * @return
	 * @throws Exception
	 */
	public static JSONArrayWrapper findJSONArray(String in) throws Exception {

		return new JSONArrayWrapper(new JSONWrapper<JSONArray>(in));

	}

}
