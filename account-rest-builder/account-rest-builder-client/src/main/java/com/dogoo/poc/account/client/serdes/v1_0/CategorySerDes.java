package com.dogoo.poc.account.client.serdes.v1_0;

import com.dogoo.poc.account.client.dto.v1_0.Category;
import com.dogoo.poc.account.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author phidx
 * @generated
 */
@Generated("")
public class CategorySerDes {

	public static Category toDTO(String json) {
		CategoryJSONParser categoryJSONParser = new CategoryJSONParser();

		return categoryJSONParser.parseToDTO(json);
	}

	public static Category[] toDTOs(String json) {
		CategoryJSONParser categoryJSONParser = new CategoryJSONParser();

		return categoryJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Category category) {
		if (category == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (category.getCategoryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categoryId\": ");

			sb.append(category.getCategoryId());
		}

		if (category.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append(category.getCode());
		}

		if (category.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(category.getName()));

			sb.append("\"");
		}

		if (category.getParentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append("\"");

			sb.append(_escape(category.getParentId()));

			sb.append("\"");
		}

		if (category.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(_escape(category.getType()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CategoryJSONParser categoryJSONParser = new CategoryJSONParser();

		return categoryJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Category category) {
		if (category == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (category.getCategoryId() == null) {
			map.put("categoryId", null);
		}
		else {
			map.put("categoryId", String.valueOf(category.getCategoryId()));
		}

		if (category.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(category.getCode()));
		}

		if (category.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(category.getName()));
		}

		if (category.getParentId() == null) {
			map.put("parentId", null);
		}
		else {
			map.put("parentId", String.valueOf(category.getParentId()));
		}

		if (category.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(category.getType()));
		}

		return map;
	}

	public static class CategoryJSONParser extends BaseJSONParser<Category> {

		@Override
		protected Category createDTO() {
			return new Category();
		}

		@Override
		protected Category[] createDTOArray(int size) {
			return new Category[size];
		}

		@Override
		protected void setField(
			Category category, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "categoryId")) {
				if (jsonParserFieldValue != null) {
					category.setCategoryId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					category.setCode(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					category.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentId")) {
				if (jsonParserFieldValue != null) {
					category.setParentId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					category.setType((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}