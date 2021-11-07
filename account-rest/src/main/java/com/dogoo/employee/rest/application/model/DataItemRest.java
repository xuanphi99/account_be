package com.dogoo.employee.rest.application.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {
                "dataItemId",
                "type",
                "name",
                "code",
                "parentId"

        }
)
@XmlRootElement(
        name = "DataItemRest"
)
public class DataItemRest {
    private long dataItemId;
    private String type;
    private String name;
    private String code;
    private long parentId;

    public DataItemRest(long dataItemId, String type, String name, String code, long parentId) {
        this.dataItemId = dataItemId;
        this.type = type;
        this.name = name;
        this.code = code;
        this.parentId = parentId;
    }

    public DataItemRest() {
    }

    public long getDataItemId() {
        return dataItemId;
    }

    public void setDataItemId(long dataItemId) {
        this.dataItemId = dataItemId;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
