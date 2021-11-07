package com.dogoo.poc.account.internal.search.result.contributor;

import com.dogoo.poc.account.constant.SearchField;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = "indexer.class.name=com.dogoo.poc.account.model.AccountEntry",
        service = ModelSummaryContributor.class
)
public class AccountModelSummaryContributor implements ModelSummaryContributor {
    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        Summary summary = new Summary(
                document.get(SearchField.FULL_NAME),
                document.get(SearchField.EMAIL));

        summary.setMaxContentLength(200);

        return summary;
    }
}

