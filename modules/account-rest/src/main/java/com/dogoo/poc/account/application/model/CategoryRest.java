package com.dogoo.poc.account.application.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {
                "categoryId",
                "type",
                "name",
                "code",
                "parentId"

        }
)
@XmlRootElement(
        name = "CategoryRest"
)
public class CategoryRest {
        private long categoryId;
        private String type;
        private String name;
        private int code;
        private String parentId;

        public CategoryRest() {
        }

        public CategoryRest(long categoryId, String type, String name, int code, String parentId) {
                this.categoryId = categoryId;
                this.type = type;
                this.name = name;
                this.code = code;
                this.parentId = parentId;
        }

        public long getCategoryId() {
                return categoryId;
        }

        public void setCategoryId(long categoryId) {
                this.categoryId = categoryId;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getCode() {
                return code;
        }

        public void setCode(int code) {
                this.code = code;
        }

        public String getParentId() {
                return parentId;
        }

        public void setParentId(String parentId) {
                this.parentId = parentId;
        }
}
