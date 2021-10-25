package com.dogoo.poc.account.application.model;

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
                "roles"

        }
)
@XmlRootElement(
        name = "AccountRest"
)
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
        private List<CategoryAccountRest> roles;

        public AccountRest() {
        }

        public AccountRest(long accountId, String fullName, String email, String newUser, String password, String phone, long departmentId, long positionId, int userIdMapping, List<CategoryAccountRest> roles) {
                this.accountId = accountId;
                this.fullName = fullName;
                this.email = email;
                this.newUser = newUser;
                this.password = password;
                this.phone = phone;
                this.departmentId = departmentId;
                this.positionId = positionId;
                this.userIdMapping = userIdMapping;
                this.roles = roles;
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

        public List<CategoryAccountRest> getRoles() {
                return roles;
        }

        public void setRoles(List<CategoryAccountRest> roles) {
                this.roles = roles;
        }
}
