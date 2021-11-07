package com.dogoo.poc.account.internal.search.query.contributor;

import com.dogoo.poc.account.constant.SearchField;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.dogoo.poc.account.model.AccountEntry",
        service = KeywordQueryContributor.class
)
public class AccountEntryKeywordQueryContributor implements KeywordQueryContributor {


    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.FULL_NAME, false);
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.EMAIL, false);
    }

    @Reference
    protected QueryHelper queryHelper;


}
