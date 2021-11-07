package com.dogoo.poc.account.internal.search.indexer.contributor;

import com.dogoo.poc.account.model.AccountEntry;
import com.dogoo.poc.account.service.AccountEntryLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.dogoo.poc.account.model.AccountEntry",
        service = ModelIndexerWriterContributor.class
)
public class AccountEntryModelIndexerWriterContributor implements ModelIndexerWriterContributor<AccountEntry>  {

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod((AccountEntry accountEntry) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(accountEntry);

            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(accountEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(AccountEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Override
    public IndexerWriterMode getIndexerWriterMode(AccountEntry baseModel) {
        return IndexerWriterMode.UPDATE;
    }


    @Reference
    private AccountEntryLocalService accountEntryLocalService;

    @Reference
    private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;

}
