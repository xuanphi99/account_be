package com.dogoo.poc.account.application.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"companyId" , "accountId","categoryId"}
)
@XmlRootElement(
        name = "CategoryAccountRest"
)
public class CategoryAccountRest {
    private long companyId;
    private long accountId;
    private long categoryId;

}
