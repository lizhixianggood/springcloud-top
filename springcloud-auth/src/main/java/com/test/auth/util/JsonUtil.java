package com.test.auth.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

	/**
	 * @Description: is_desc-false升序列 is_desc-true降序 (排序字段为字符串)
	 */
	public static String jsonArraySortString(JSONArray jsonArr, String sortKey, boolean is_desc) {
		JSONArray sortedJsonArray = new JSONArray();
		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		for (int i = 0; i < jsonArr.size(); i++) {
			jsonValues.add(jsonArr.getJSONObject(i));
		}
		Collections.sort(jsonValues, new Comparator<JSONObject>() {
			private final String KEY_NAME = sortKey;

			@Override
			public int compare(JSONObject a, JSONObject b) {
				String valA = new String();
				String valB = new String();
				try {
					valA = a.getString(KEY_NAME);
					valB = b.getString(KEY_NAME);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				if (is_desc) {
					return -valA.compareTo(valB);
				} else {
					return -valB.compareTo(valA);
				}

			}
		});
		for (int i = 0; i < jsonArr.size(); i++) {
			sortedJsonArray.add(jsonValues.get(i));
		}
		return sortedJsonArray.toString();
	}

	/**
	 * @Description: is_desc-false升序列 is_desc-true降序 (排序字段为Long类型)
	 */
	public static JSONArray jsonArraySort(JSONArray jsonArr, String sortKey, boolean is_desc, int size) {
		JSONArray sortedJsonArray = new JSONArray();
		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		for (int i = 0; i < jsonArr.size(); i++) {
			jsonValues.add(jsonArr.getJSONObject(i));
		}
		Collections.sort(jsonValues, new Comparator<JSONObject>() {
			private final String KEY_NAME = sortKey;

			@Override
			public int compare(JSONObject a, JSONObject b) {
				long valA = 0;
				long valB = 0;
				try {
					valA = a.getLongValue(KEY_NAME);
					valB = b.getLongValue(KEY_NAME);
				} catch (JSONException e) {
					e.printStackTrace();
				}

				if (is_desc) {
					if (valA < valB) {
						return 1;
					}
					if (valA == valB) {
						return 0;
					}
					return -1;
				} else {
					if (valA > valB) {
						return 1;
					}
					if (valA == valB) {
						return 0;
					}
					return -1;
				}

			}
		});
		for (int i = 0; i < (jsonArr.size() < size ? jsonArr.size() : size); i++) {
			sortedJsonArray.add(jsonValues.get(i));
		}
		return sortedJsonArray;
	}
	
	public static String getString(JSONObject json, String key) {
		if (json.containsKey(key)) {
			return json.getString(key);
		}else {
			return "";
		}
	}
	
	public static int getInt(JSONObject json, String key) {
		if (json.containsKey(key)) {
			return json.getInteger(key);
		}else {
			return 0;
		}
	}
}
