package com.dogoo.poc.account.client.dto.v1_0;

import com.dogoo.poc.account.client.function.UnsafeSupplier;
import com.dogoo.poc.account.client.serdes.v1_0.AccountSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author phidx
 * @generated
 */
@Generated("")
public class Account implements Cloneable, Serializable {

	public static Account toDTO(String json) {
		return AccountSerDes.toDTO(json);
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setAccountId(
		UnsafeSupplier<Long, Exception> accountIdUnsafeSupplier) {

		try {
			accountId = accountIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long accountId;

	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}

	public void setCategories(
		UnsafeSupplier<Category[], Exception> categoriesUnsafeSupplier) {

		try {
			categories = categoriesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Category[] categories;

	public Object getCategoryDepartment() {
		return categoryDepartment;
	}

	public void setCategoryDepartment(Object categoryDepartment) {
		this.categoryDepartment = categoryDepartment;
	}

	public void setCategoryDepartment(
		UnsafeSupplier<Object, Exception> categoryDepartmentUnsafeSupplier) {

		try {
			categoryDepartment = categoryDepartmentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Object categoryDepartment;

	public Object getCategoryPosition() {
		return categoryPosition;
	}

	public void setCategoryPosition(Object categoryPosition) {
		this.categoryPosition = categoryPosition;
	}

	public void setCategoryPosition(
		UnsafeSupplier<Object, Exception> categoryPositionUnsafeSupplier) {

		try {
			categoryPosition = categoryPositionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Object categoryPosition;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public void setDepartmentId(
		UnsafeSupplier<Long, Exception> departmentIdUnsafeSupplier) {

		try {
			departmentId = departmentIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long departmentId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail(
		UnsafeSupplier<String, Exception> emailUnsafeSupplier) {

		try {
			email = emailUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String email;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setFullName(
		UnsafeSupplier<String, Exception> fullNameUnsafeSupplier) {

		try {
			fullName = fullNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fullName;

	public String getNewUser() {
		return newUser;
	}

	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}

	public void setNewUser(
		UnsafeSupplier<String, Exception> newUserUnsafeSupplier) {

		try {
			newUser = newUserUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String newUser;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPassword(
		UnsafeSupplier<String, Exception> passwordUnsafeSupplier) {

		try {
			password = passwordUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String password;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPhone(
		UnsafeSupplier<String, Exception> phoneUnsafeSupplier) {

		try {
			phone = phoneUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String phone;

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public void setPositionId(
		UnsafeSupplier<Long, Exception> positionIdUnsafeSupplier) {

		try {
			positionId = positionIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long positionId;

	public Roles getRoles() {
		return roles;
	}

	public String getRolesAsString() {
		if (roles == null) {
			return null;
		}

		return roles.toString();
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public void setRoles(UnsafeSupplier<Roles, Exception> rolesUnsafeSupplier) {
		try {
			roles = rolesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Roles roles;

	public Integer getUserIdMapping() {
		return userIdMapping;
	}

	public void setUserIdMapping(Integer userIdMapping) {
		this.userIdMapping = userIdMapping;
	}

	public void setUserIdMapping(
		UnsafeSupplier<Integer, Exception> userIdMappingUnsafeSupplier) {

		try {
			userIdMapping = userIdMappingUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer userIdMapping;

	@Override
	public Account clone() throws CloneNotSupportedException {
		return (Account)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Account)) {
			return false;
		}

		Account account = (Account)object;

		return Objects.equals(toString(), account.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return AccountSerDes.toJSON(this);
	}

	public static enum Roles {

		ADMIN("ADMIN"), USER("USER"), TEAM_O_WNER("Team OWner"),
		DEPT_OWNER("DEPT OWNER");

		public static Roles create(String value) {
			for (Roles roles : values()) {
				if (Objects.equals(roles.getValue(), value)) {
					return roles;
				}
			}

			return null;
		}

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Roles(String value) {
			_value = value;
		}

		private final String _value;

	}

}