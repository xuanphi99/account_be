package com.dogoo.employee.rest.application.mapper;

import com.dogoo.dataitem.model.DataItemEntry;
import com.dogoo.employee.rest.application.model.DataItemRest;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true,service = DataItemRestMapper.class)
public class DataItemRestMapper {

    public DataItemRest mapFromCategoryEntryToCategory(DataItemEntry from){
        DataItemRest to = new DataItemRest();

        to.setDataItemId(from.getDataItemId());
        to.setType(from.getType());
        to.setName(from.getName());
        to.setCode(from.getCode());
        to.setParentId(from.getParentId());

        return to;
    }

    public List<DataItemRest> mapFromCategoryRestToList(List<DataItemEntry> from){
        List<DataItemRest> categoryRests = new ArrayList<>();
        for (DataItemEntry item: from) {
            categoryRests.add(mapFromCategoryEntryToCategory(item));
        }
        return  categoryRests;
    }

}
