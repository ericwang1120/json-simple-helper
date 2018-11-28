package org.jsonsimplehelper;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

public class JSONHelperTest {

	@Test
	public void testFindJSONArray() throws Exception {
		JSONArrayWrapper jsonWrapper = JSONHelper.findJSONArray("[\"eric\",\"jack\"]");
		assertEquals(jsonWrapper.toString(), "[\"eric\",\"jack\"]");
	}

	@Test
	public void testFindJSONObject() throws Exception {
		JSONWrapper<JSONObject> jsonWrapper = JSONHelper.findJSONObject("{\"name\":\"eric\"}");
		assertEquals(jsonWrapper.toString(), "{\"name\":\"eric\"}");
	}
}
