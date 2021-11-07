package com.dogoo.poc.account.internal.validator;

import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import javax.ws.rs.BadRequestException;

@Component(immediate = true, service = com.dogoo.poc.account.internal.validator.AccountValidator.class)
public class AccountValidator {
    private static final String PAGE_SIZE_MAX = "page-size-is-greater-than-x";
    public void validatorForSearch(Pagination pagination) {
        if (pagination.getPageSize() > 250) {
            throw new BadRequestException(String.format(PAGE_SIZE_MAX, 250));
        }

    }
}