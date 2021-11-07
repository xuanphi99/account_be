package com.dogoo.poc.account.resource.v1_0.test;

import com.dogoo.poc.account.client.dto.v1_0.Account;
import com.dogoo.poc.account.client.http.HttpInvoker;
import com.dogoo.poc.account.client.pagination.Page;
import com.dogoo.poc.account.client.pagination.Pagination;
import com.dogoo.poc.account.client.resource.v1_0.AccountResource;
import com.dogoo.poc.account.client.serdes.v1_0.AccountSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author phidx
 * @generated
 */
@Generated("")
public abstract class BaseAccountResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_accountResource.setContextCompany(testCompany);

		AccountResource.Builder builder = AccountResource.builder();

		accountResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Account account1 = randomAccount();

		String json = objectMapper.writeValueAsString(account1);

		Account account2 = AccountSerDes.toDTO(json);

		Assert.assertTrue(equals(account1, account2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Account account = randomAccount();

		String json1 = objectMapper.writeValueAsString(account);
		String json2 = AccountSerDes.toJSON(account);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Account account = randomAccount();

		account.setEmail(regex);
		account.setFullName(regex);
		account.setNewUser(regex);
		account.setPassword(regex);
		account.setPhone(regex);

		String json = AccountSerDes.toJSON(account);

		Assert.assertFalse(json.contains(regex));

		account = AccountSerDes.toDTO(json);

		Assert.assertEquals(regex, account.getEmail());
		Assert.assertEquals(regex, account.getFullName());
		Assert.assertEquals(regex, account.getNewUser());
		Assert.assertEquals(regex, account.getPassword());
		Assert.assertEquals(regex, account.getPhone());
	}

	@Test
	public void testDeleteAccount() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteAccount() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetDetail() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetDetail() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetDetailNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutAccount() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetAllAccount() throws Exception {
		Page<Account> page = accountResource.getAllAccount(
			RandomTestUtil.randomString(), null, Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		Account account1 = testGetAllAccount_addAccount(randomAccount());

		Account account2 = testGetAllAccount_addAccount(randomAccount());

		page = accountResource.getAllAccount(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(account1, account2), (List<Account>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAllAccountWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Account account1 = randomAccount();

		account1 = testGetAllAccount_addAccount(account1);

		for (EntityField entityField : entityFields) {
			Page<Account> page = accountResource.getAllAccount(
				null, getFilterString(entityField, "between", account1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(account1),
				(List<Account>)page.getItems());
		}
	}

	@Test
	public void testGetAllAccountWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Account account1 = testGetAllAccount_addAccount(randomAccount());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Account account2 = testGetAllAccount_addAccount(randomAccount());

		for (EntityField entityField : entityFields) {
			Page<Account> page = accountResource.getAllAccount(
				null, getFilterString(entityField, "eq", account1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(account1),
				(List<Account>)page.getItems());
		}
	}

	@Test
	public void testGetAllAccountWithPagination() throws Exception {
		Account account1 = testGetAllAccount_addAccount(randomAccount());

		Account account2 = testGetAllAccount_addAccount(randomAccount());

		Account account3 = testGetAllAccount_addAccount(randomAccount());

		Page<Account> page1 = accountResource.getAllAccount(
			null, null, Pagination.of(1, 2), null);

		List<Account> accounts1 = (List<Account>)page1.getItems();

		Assert.assertEquals(accounts1.toString(), 2, accounts1.size());

		Page<Account> page2 = accountResource.getAllAccount(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Account> accounts2 = (List<Account>)page2.getItems();

		Assert.assertEquals(accounts2.toString(), 1, accounts2.size());

		Page<Account> page3 = accountResource.getAllAccount(
			null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(account1, account2, account3),
			(List<Account>)page3.getItems());
	}

	@Test
	public void testGetAllAccountWithSortDateTime() throws Exception {
		testGetAllAccountWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, account1, account2) -> {
				BeanUtils.setProperty(
					account1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetAllAccountWithSortInteger() throws Exception {
		testGetAllAccountWithSort(
			EntityField.Type.INTEGER,
			(entityField, account1, account2) -> {
				BeanUtils.setProperty(account1, entityField.getName(), 0);
				BeanUtils.setProperty(account2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetAllAccountWithSortString() throws Exception {
		testGetAllAccountWithSort(
			EntityField.Type.STRING,
			(entityField, account1, account2) -> {
				Class<?> clazz = account1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						account1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						account2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						account1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						account2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						account1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						account2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetAllAccountWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Account, Account, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Account account1 = randomAccount();
		Account account2 = randomAccount();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, account1, account2);
		}

		account1 = testGetAllAccount_addAccount(account1);

		account2 = testGetAllAccount_addAccount(account2);

		for (EntityField entityField : entityFields) {
			Page<Account> ascPage = accountResource.getAllAccount(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(account1, account2),
				(List<Account>)ascPage.getItems());

			Page<Account> descPage = accountResource.getAllAccount(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(account2, account1),
				(List<Account>)descPage.getItems());
		}
	}

	protected Account testGetAllAccount_addAccount(Account account)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testAddAccount() throws Exception {
		Account randomAccount = randomAccount();

		Account postAccount = testAddAccount_addAccount(randomAccount);

		assertEquals(randomAccount, postAccount);
		assertValid(postAccount);
	}

	protected Account testAddAccount_addAccount(Account account)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Account account1, Account account2) {
		Assert.assertTrue(
			account1 + " does not equal " + account2,
			equals(account1, account2));
	}

	protected void assertEquals(
		List<Account> accounts1, List<Account> accounts2) {

		Assert.assertEquals(accounts1.size(), accounts2.size());

		for (int i = 0; i < accounts1.size(); i++) {
			Account account1 = accounts1.get(i);
			Account account2 = accounts2.get(i);

			assertEquals(account1, account2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Account> accounts1, List<Account> accounts2) {

		Assert.assertEquals(accounts1.size(), accounts2.size());

		for (Account account1 : accounts1) {
			boolean contains = false;

			for (Account account2 : accounts2) {
				if (equals(account1, account2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				accounts2 + " does not contain " + account1, contains);
		}
	}

	protected void assertValid(Account account) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (account.getAccountId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("categories", additionalAssertFieldName)) {
				if (account.getCategories() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"categoryDepartment", additionalAssertFieldName)) {

				if (account.getCategoryDepartment() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("categoryPosition", additionalAssertFieldName)) {
				if (account.getCategoryPosition() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("departmentId", additionalAssertFieldName)) {
				if (account.getDepartmentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (account.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fullName", additionalAssertFieldName)) {
				if (account.getFullName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("newUser", additionalAssertFieldName)) {
				if (account.getNewUser() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("password", additionalAssertFieldName)) {
				if (account.getPassword() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phone", additionalAssertFieldName)) {
				if (account.getPhone() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("positionId", additionalAssertFieldName)) {
				if (account.getPositionId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("roles", additionalAssertFieldName)) {
				if (account.getRoles() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userIdMapping", additionalAssertFieldName)) {
				if (account.getUserIdMapping() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Account> page) {
		boolean valid = false;

		java.util.Collection<Account> accounts = page.getItems();

		int size = accounts.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				getDeclaredFields(
					com.dogoo.poc.account.dto.v1_0.Account.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Account account1, Account account2) {
		if (account1 == account2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getAccountId(), account2.getAccountId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("categories", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getCategories(), account2.getCategories())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"categoryDepartment", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						account1.getCategoryDepartment(),
						account2.getCategoryDepartment())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("categoryPosition", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getCategoryPosition(),
						account2.getCategoryPosition())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("departmentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getDepartmentId(),
						account2.getDepartmentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getEmail(), account2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fullName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getFullName(), account2.getFullName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("newUser", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getNewUser(), account2.getNewUser())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("password", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getPassword(), account2.getPassword())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phone", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getPhone(), account2.getPhone())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("positionId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getPositionId(), account2.getPositionId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("roles", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getRoles(), account2.getRoles())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userIdMapping", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getUserIdMapping(),
						account2.getUserIdMapping())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected Field[] getDeclaredFields(Class clazz) throws Exception {
		Stream<Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_accountResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_accountResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Account account) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("accountId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("categories")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("categoryDepartment")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("categoryPosition")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("departmentId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(account.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fullName")) {
			sb.append("'");
			sb.append(String.valueOf(account.getFullName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("newUser")) {
			sb.append("'");
			sb.append(String.valueOf(account.getNewUser()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("password")) {
			sb.append("'");
			sb.append(String.valueOf(account.getPassword()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("phone")) {
			sb.append("'");
			sb.append(String.valueOf(account.getPhone()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("positionId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("roles")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("userIdMapping")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Account randomAccount() throws Exception {
		return new Account() {
			{
				accountId = RandomTestUtil.randomLong();
				departmentId = RandomTestUtil.randomLong();
				email =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				fullName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				newUser = StringUtil.toLowerCase(RandomTestUtil.randomString());
				password = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				phone = StringUtil.toLowerCase(RandomTestUtil.randomString());
				positionId = RandomTestUtil.randomLong();
				userIdMapping = RandomTestUtil.randomInt();
			}
		};
	}

	protected Account randomIrrelevantAccount() throws Exception {
		Account randomIrrelevantAccount = randomAccount();

		return randomIrrelevantAccount;
	}

	protected Account randomPatchAccount() throws Exception {
		return randomAccount();
	}

	protected AccountResource accountResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseAccountResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.dogoo.poc.account.resource.v1_0.AccountResource
		_accountResource;

}