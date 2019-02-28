package org.jsonsimplehelper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONWrapper<T> {
	private T jsonObject;
	JSONParser jParser = new JSONParser();

	@SuppressWarnings("unchecked")
	public JSONWrapper(String in) {
		if (in != null && (in.startsWith("[") || in.startsWith("{"))) {
			try {
				this.jsonObject = (T) jParser.parse(in);
			} catch (ParseException e) {
				e.printStackTrace();
				this.jsonObject = (T) in;
			}
		} else {
			this.jsonObject = (T) in;
		}
	}

	@SuppressWarnings("rawtypes")
	public JSONWrapper get(Object obj) {
		try {
			if (getJsonObject() instanceof JSONObject) {
				if (((JSONObject) getJsonObject()).get(obj) != null) {
					return new JSONWrapper(((JSONObject) getJsonObject()).get(obj).toString());
				}
			}

			if (getJsonObject() instanceof JSONArray) {
				if (((JSONArray) getJsonObject()).get((int) obj) != null) {
					return new JSONWrapper(((JSONArray) getJsonObject()).get((Integer) obj).toString());
				}
			}

		} catch (Exception e) {
			System.err.println("parse error: " + obj.toString());
		}
		return new JSONWrapper("");
	}

	@Override
	public String toString() {
		return getJsonObject() == null ? "" : getJsonObject().toString();
	}

	public T getJsonObject() {
		return jsonObject;
	}

	public JSONArrayWrapper toJSONArrayWrapper() {
		return new JSONArrayWrapper(this);
	}
}