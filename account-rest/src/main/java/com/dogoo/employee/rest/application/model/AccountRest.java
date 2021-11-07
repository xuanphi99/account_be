package com.dogoo.employee.rest.application.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {
                "accountId",
                "fullName",
                "email",
                "newUser",
                "password",
                "phone",
                "departmentId",
                "positionId",
                "userIdMapping",
                "avatarName",
                "avatarPath",
                "status",
                "roles",
                "accountRole",
                "categoryDepartment",
                "categoryPosition"
        }

)
@XmlRootElement(name = "AccountRest")
public class AccountRest {
    private long accountId;
    private String fullName;
    private String email;
    private String newUser;
    private String password;
    private String phone;
    private long departmentId;
    private long positionId;
    private int userIdMapping;
    private String avatarName;
    private String avatarPath;
    private String status;
    private long [] roles;
    private List<AccountRoleRest> accountRole;
    private DepartmentRest categoryDepartment;
    private DataItemRest categoryPosition;

    public AccountRest() {
    }

    public AccountRest(long accountId, String fullName, String email, String newUser, String password, String phone, long departmentId, long positionId, int userIdMapping, String avatarName, String avatarPath, String status, long[] roles, List<AccountRoleRest> accountRole, DepartmentRest categoryDepartment, DataItemRest categoryPosition) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.email = email;
        this.newUser = newUser;
        this.password = password;
        this.phone = phone;
        this.departmentId = departmentId;
        this.positionId = positionId;
        this.userIdMapping = userIdMapping;
        this.avatarName = avatarName;
        this.avatarPath = avatarPath;
        this.status = status;
        this.roles = roles;
        this.accountRole = accountRole;
        this.categoryDepartment = categoryDepartment;
        this.categoryPosition = categoryPosition;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewUser() {
        return newUser;
    }

    public void setNewUser(String newUser) {
        this.newUser = newUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }

    public int getUserIdMapping() {
        return userIdMapping;
    }

    public void setUserIdMapping(int userIdMapping) {
        this.userIdMapping = userIdMapping;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long[] getRoles() {
        return roles;
    }

    public void setRoles(long[] roles) {
        this.roles = roles;
    }

    public List<AccountRoleRest> getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(List<AccountRoleRest> accountRole) {
        this.accountRole = accountRole;
    }

    public DepartmentRest getCategoryDepartment() {
        return categoryDepartment;
    }

    public void setCategoryDepartment(DepartmentRest categoryDepartment) {
        this.categoryDepartment = categoryDepartment;
    }

    public DataItemRest getCategoryPosition() {
        return categoryPosition;
    }

    public void setCategoryPosition(DataItemRest categoryPosition) {
        this.categoryPosition = categoryPosition;
    }
}
