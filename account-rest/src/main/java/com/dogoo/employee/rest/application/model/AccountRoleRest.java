package com.dogoo.employee.rest.application.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {
                "accountRoleId",
                "accountId",
                "name",
                "code",

        }
)
@XmlRootElement(
        name = "AccountRoleRest"
)
public class AccountRoleRest {
        private long accountRoleId;
        private long accountId;
        private String name;
        private String code;

        public AccountRoleRest() {
        }

        public AccountRoleRest(long accountRoleId, long accountId, String name, String code) {
                this.accountRoleId = accountRoleId;
                this.accountId = accountId;
                this.name = name;
                this.code = code;
        }

        public long getAccountRoleId() {
                return accountRoleId;
        }

        public void setAccountRoleId(long accountRoleId) {
                this.accountRoleId = accountRoleId;
        }

        public long getAccountId() {
                return accountId;
        }

        public void setAccountId(long accountId) {
                this.accountId = accountId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }
}
