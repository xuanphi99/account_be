package com.dogoo.employee.rest.application.mapper;

import com.dogoo.dataitem.model.DataItemEntry;
import com.dogoo.department.model.DepartmentEntry;
import com.dogoo.employee.rest.application.model.DataItemRest;
import com.dogoo.employee.rest.application.model.DepartmentRest;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true,service = DepartmentRestMapper.class)
public class DepartmentRestMapper {

    public DepartmentRest mapFromDepartmentEntryToDepartment(DepartmentEntry from){
        DepartmentRest to = new DepartmentRest();

        to.setDepartmentId(from.getDepartmentId());
        to.setName(from.getName());
        to.setAddress(from.getAddress());
        to.setBranch(from.getBranch());

        return to;
    }

    public List<DepartmentRest> mapFromDepartmentRestToList(List<DepartmentEntry> from){
        List<DepartmentRest> departmentRests = new ArrayList<>();
        for (DepartmentEntry item: from) {
            departmentRests.add(mapFromDepartmentEntryToDepartment(item));
        }
        return  departmentRests;
    }

}
