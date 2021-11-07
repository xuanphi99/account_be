package com.dogoo.employee.rest.application.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {
                "departmentId",
                "name",
                "address",
                "branch"

        }

)
@XmlRootElement(name = "DepartmentRest")
public class DepartmentRest {
        private long departmentId;
        private String name;
        private String address;
        private String branch;

        public DepartmentRest() {
        }

        public DepartmentRest(long departmentId, String name, String address, String branch) {
                this.departmentId = departmentId;
                this.name = name;
                this.address = address;
                this.branch = branch;
        }

        public long getDepartmentId() {
                return departmentId;
        }

        public void setDepartmentId(long departmentId) {
                this.departmentId = departmentId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getBranch() {
                return branch;
        }

        public void setBranch(String branch) {
                this.branch = branch;
        }
}
