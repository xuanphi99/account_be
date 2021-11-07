package com.dogoo.employee.rest.application.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {
                "items",
                "page",
                "pageSize",
                "totalCount",
                "totalPage"


        }
)
@XmlRootElement(
        name = "PageRest"
)
public class PageRest {
        private List<AccountRest> items;
        private int page;
        private int pageSize;
        private int totalCount;
        private int totalPage;

        public PageRest(List<AccountRest> items, int page, int pageSize, int totalCount, int totalPage) {
                this.items = items;
                this.page = page;
                this.pageSize = pageSize;
                this.totalCount = totalCount;
                this.totalPage = totalPage;
        }

        public PageRest() {
        }

        public List<AccountRest> getItems() {
                return items;
        }

        public void setItems(List<AccountRest> items) {
                this.items = items;
        }

        public int getPage() {
                return page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return pageSize;
        }

        public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
        }

        public int getTotalCount() {
                return totalCount;
        }

        public void setTotalCount(int totalCount) {
                this.totalCount = totalCount;
        }

        public int getTotalPage() {
                return totalPage;
        }

        public void setTotalPage(int totalPage) {
                this.totalPage = totalPage;
        }

        public static PageRest getPagingInfo(Integer totalCount, Integer pageSize, Integer page, List<AccountRest> items) {
                PageRest paging = new PageRest();
                if (totalCount != null && pageSize != null && pageSize != 0) {
                        Integer totalPage;
                        if (totalCount % pageSize == 0) {
                                totalPage = totalCount / pageSize;
                        } else {
                                totalPage = totalCount / pageSize + 1;
                        }
                        paging.setTotalPage(totalPage);
                }
                paging.setPageSize(pageSize);
                paging.setPage(page);
                paging.setItems(items);
                paging.setTotalCount(totalCount);

                return paging;
        }
}
