package com.dogoo.poc.account.internal.odata.v1_0;

import com.dogoo.poc.account.constant.SearchField;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountEntityIndexModel implements EntityModel {

    public AccountEntityIndexModel() {
        entityFieldMap = Stream.of(
                new StringEntityField(
                        SearchField.FULL_NAME, locale -> Field.getSortableFieldName(SearchField.FULL_NAME)),

                new StringEntityField(
                        SearchField.EMAIL, locale -> Field.getSortableFieldName(SearchField.EMAIL)
                )

        ).collect(
                Collectors.toMap(EntityField::getName, Function.identity())
        );
    }


    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return entityFieldMap;
    }

    private final Map<String, EntityField> entityFieldMap;

}