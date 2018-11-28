package org.jsonsimplehelper;

import java.util.Iterator;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

@SuppressWarnings("rawtypes")
public class JSONArrayWrapper implements Iterable<JSONWrapper> {
	private JSONArray jsonArray;
	JSONParser jParser = new JSONParser();

	public JSONArrayWrapper(JSONWrapper jsonWrapper) {
		this.jsonArray = (JSONArray) jsonWrapper.getJsonObject();
	}

	@Override
	public String toString() {
		return jsonArray.toString();
	}

	public Stream<JSONWrapper> stream() {
		return Stream.generate(iterator()::next).limit(jsonArray.size());
	}

	@Override
	public Iterator<JSONWrapper> iterator() {
		return new jsonArrayIterator();
	}

	private class jsonArrayIterator implements Iterator<JSONWrapper> {

		int current = 0;

		@Override
		public boolean hasNext() {
			return current < jsonArray.size();
		}

		@SuppressWarnings({ "unchecked" })
		@Override
		public JSONWrapper<JSONArray> next() {
			try {
				return new JSONWrapper(jsonArray.get(current++).toString());
			} catch (Exception e) {
				return null;
			}
		}
	}

}
