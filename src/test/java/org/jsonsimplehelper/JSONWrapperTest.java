package org.jsonsimplehelper;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Test;

public class JSONWrapperTest {

	@Test
	public void testEmptyJSON() {
		JSONWrapper<JSONObject> jsonWrapper = new JSONWrapper<JSONObject>("{}");
		assertEquals("{}", jsonWrapper.toString());
	}

	@Test
	public void testNull() {
		JSONWrapper<JSONObject> jsonWrapper = new JSONWrapper<JSONObject>(null);
		assertEquals("", jsonWrapper.toString());
	}

	@Test
	public void testGetJSONObject() {
		JSONWrapper<JSONObject> jsonWrapper = new JSONWrapper<JSONObject>("{\"name\":\"eric\"}");
		assertEquals("eric", jsonWrapper.get("name").toString());
	}

	@Test
	public void testPropertyNotFound() {
		JSONWrapper<JSONObject> jsonWrapper = new JSONWrapper<JSONObject>("{\"name\":\"eric\"}");
		assertEquals("", jsonWrapper.get("notExisted").toString());
	}

	@Test
	public void testJSONArray() {
		JSONWrapper<JSONObject> jsonWrapper = new JSONWrapper<JSONObject>("[\"eric\",\"jack\"]");
		assertEquals("eric", jsonWrapper.get(0).toString());
	}

	@Test
	public void testNestedGet() {
		JSONWrapper<JSONObject> jsonWrapper = new JSONWrapper<JSONObject>(
				"{\"name\":\"eric\",\"technical stacks\": [\"java\",\"react\",\"angular\"]}");
		assertEquals("react", jsonWrapper.get("technical stacks").get(1).toString());
	}

	@Test
	public void testGetNumber() {
		JSONWrapper<JSONObject> jsonWrapper = new JSONWrapper<JSONObject>(
				"{\"num\":\"1.20000\",\"technical stacks\": [\"java\",\"react\",\"angular\"]}");
		assertEquals("1.20000", jsonWrapper.get("num").toString());
	}
	
	@Test
	public void testContainsSpecialChars() {
		JSONWrapper<JSONObject> jsonWrapper = new JSONWrapper<JSONObject>(
				"{\"special\":\"1.{20000\",\"technical stacks\": [\"java\",\"react\",\"angular\"]}");
		assertEquals("1.{20000", jsonWrapper.get("special").toString());
	}

}
