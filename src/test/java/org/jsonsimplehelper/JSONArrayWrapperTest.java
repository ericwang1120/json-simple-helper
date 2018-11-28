package org.jsonsimplehelper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.junit.Test;

public class JSONArrayWrapperTest {

	@Test
	public void testOutOfBound() {
		JSONWrapper<JSONArray> jsonWrapper = new JSONWrapper<JSONArray>("[\"eric\",\"jack\"]");
		assertEquals("", jsonWrapper.get(3).toString());
	}

	@Test
	public void testToJSONArrayWrapper() {
		JSONWrapper<JSONArray> jsonWrapper = new JSONWrapper<JSONArray>("[\"eric\",\"jack\"]");
		long size = jsonWrapper.toJSONArrayWrapper().stream().count();
		assertEquals(2, size);
	}

	@Test
	public void testJSONArrayWrapperToString() {
		JSONWrapper<JSONArray> jsonWrapper = new JSONWrapper<JSONArray>("[\"eric\",\"jack\"]");
		JSONArrayWrapper jsonArrayWrapper = jsonWrapper.toJSONArrayWrapper();
		assertEquals("[\"eric\",\"jack\"]", jsonArrayWrapper.toString());
	}

	@Test
	public void testJSONArrayWrapperIteration() {
		JSONWrapper<JSONArray> jsonWrapper = new JSONWrapper<JSONArray>("[\"eric\",\"jack\"]");
		JSONArrayWrapper jsonArrayWrapper = jsonWrapper.toJSONArrayWrapper();
		List<String> names = new ArrayList<String>();
		jsonArrayWrapper.forEach(p -> {
			names.add(p.toString());
		});
		assertEquals("jack", names.get(1));
	}

}
