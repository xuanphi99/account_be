package com.dogoo.poc.account.client.serdes.v1_0;

import com.dogoo.poc.account.client.dto.v1_0.Account;
import com.dogoo.poc.account.client.dto.v1_0.Category;
import com.dogoo.poc.account.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author phidx
 * @generated
 */
@Generated("")
public class AccountSerDes {

	public static Account toDTO(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToDTO(json);
	}

	public static Account[] toDTOs(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Account account) {
		if (account == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (account.getAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountId\": ");

			sb.append(account.getAccountId());
		}

		if (account.getCategories() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categories\": ");

			sb.append("[");

			for (int i = 0; i < account.getCategories().length; i++) {
				sb.append(String.valueOf(account.getCategories()[i]));

				if ((i + 1) < account.getCategories().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (account.getCategoryDepartment() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categoryDepartment\": ");

			sb.append("\"");

			sb.append(_escape(account.getCategoryDepartment()));

			sb.append("\"");
		}

		if (account.getCategoryPosition() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categoryPosition\": ");

			sb.append("\"");

			sb.append(_escape(account.getCategoryPosition()));

			sb.append("\"");
		}

		if (account.getDepartmentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departmentId\": ");

			sb.append(account.getDepartmentId());
		}

		if (account.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(account.getEmail()));

			sb.append("\"");
		}

		if (account.getFullName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fullName\": ");

			sb.append("\"");

			sb.append(_escape(account.getFullName()));

			sb.append("\"");
		}

		if (account.getNewUser() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"newUser\": ");

			sb.append("\"");

			sb.append(_escape(account.getNewUser()));

			sb.append("\"");
		}

		if (account.getPassword() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"password\": ");

			sb.append("\"");

			sb.append(_escape(account.getPassword()));

			sb.append("\"");
		}

		if (account.getPhone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phone\": ");

			sb.append("\"");

			sb.append(_escape(account.getPhone()));

			sb.append("\"");
		}

		if (account.getPositionId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"positionId\": ");

			sb.append(account.getPositionId());
		}

		if (account.getRoles() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"roles\": ");

			sb.append("\"");

			sb.append(account.getRoles());

			sb.append("\"");
		}

		if (account.getUserIdMapping() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userIdMapping\": ");

			sb.append(account.getUserIdMapping());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Account account) {
		if (account == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (account.getAccountId() == null) {
			map.put("accountId", null);
		}
		else {
			map.put("accountId", String.valueOf(account.getAccountId()));
		}

		if (account.getCategories() == null) {
			map.put("categories", null);
		}
		else {
			map.put("categories", String.valueOf(account.getCategories()));
		}

		if (account.getCategoryDepartment() == null) {
			map.put("categoryDepartment", null);
		}
		else {
			map.put(
				"categoryDepartment",
				String.valueOf(account.getCategoryDepartment()));
		}

		if (account.getCategoryPosition() == null) {
			map.put("categoryPosition", null);
		}
		else {
			map.put(
				"categoryPosition",
				String.valueOf(account.getCategoryPosition()));
		}

		if (account.getDepartmentId() == null) {
			map.put("departmentId", null);
		}
		else {
			map.put("departmentId", String.valueOf(account.getDepartmentId()));
		}

		if (account.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(account.getEmail()));
		}

		if (account.getFullName() == null) {
			map.put("fullName", null);
		}
		else {
			map.put("fullName", String.valueOf(account.getFullName()));
		}

		if (account.getNewUser() == null) {
			map.put("newUser", null);
		}
		else {
			map.put("newUser", String.valueOf(account.getNewUser()));
		}

		if (account.getPassword() == null) {
			map.put("password", null);
		}
		else {
			map.put("password", String.valueOf(account.getPassword()));
		}

		if (account.getPhone() == null) {
			map.put("phone", null);
		}
		else {
			map.put("phone", String.valueOf(account.getPhone()));
		}

		if (account.getPositionId() == null) {
			map.put("positionId", null);
		}
		else {
			map.put("positionId", String.valueOf(account.getPositionId()));
		}

		if (account.getRoles() == null) {
			map.put("roles", null);
		}
		else {
			map.put("roles", String.valueOf(account.getRoles()));
		}

		if (account.getUserIdMapping() == null) {
			map.put("userIdMapping", null);
		}
		else {
			map.put(
				"userIdMapping", String.valueOf(account.getUserIdMapping()));
		}

		return map;
	}

	public static class AccountJSONParser extends BaseJSONParser<Account> {

		@Override
		protected Account createDTO() {
			return new Account();
		}

		@Override
		protected Account[] createDTOArray(int size) {
			return new Account[size];
		}

		@Override
		protected void setField(
			Account account, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accountId")) {
				if (jsonParserFieldValue != null) {
					account.setAccountId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "categories")) {
				if (jsonParserFieldValue != null) {
					account.setCategories(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> CategorySerDes.toDTO((String)object)
						).toArray(
							size -> new Category[size]
						));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "categoryDepartment")) {

				if (jsonParserFieldValue != null) {
					account.setCategoryDepartment((Object)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "categoryPosition")) {
				if (jsonParserFieldValue != null) {
					account.setCategoryPosition((Object)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "departmentId")) {
				if (jsonParserFieldValue != null) {
					account.setDepartmentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					account.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fullName")) {
				if (jsonParserFieldValue != null) {
					account.setFullName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "newUser")) {
				if (jsonParserFieldValue != null) {
					account.setNewUser((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "password")) {
				if (jsonParserFieldValue != null) {
					account.setPassword((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phone")) {
				if (jsonParserFieldValue != null) {
					account.setPhone((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "positionId")) {
				if (jsonParserFieldValue != null) {
					account.setPositionId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "roles")) {
				if (jsonParserFieldValue != null) {
					account.setRoles(
						Account.Roles.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userIdMapping")) {
				if (jsonParserFieldValue != null) {
					account.setUserIdMapping(
						Integer.valueOf((String)jsonParserFieldValue));
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