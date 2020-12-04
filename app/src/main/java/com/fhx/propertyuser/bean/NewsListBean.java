package com.fhx.propertyuser.bean;

import java.util.List;

public class NewsListBean {

    /**
     * success : true
     * data : {"records":[{"newsId":"94a7275cb9c0bebe16f7b043e9f9d979","newsType":"通知","target":"userNews","title":"添加图片测试","content":"<p>这里是添加图片测试<\/p><p><img src=\"/img/20201110174704893small.44b8d6b5.jpg\"><\/p>","creator":"张鑫","createTime":"2020-11-10 17:47:20","notes":"这里是备注","modifier":null,"modifyTime":"2020-12-02 17:42:39"},{"newsId":"5500ad2f010ebe7c7fbe9e0e18a08b63","newsType":"通知","target":"userNews","title":"添加快乐","content":"<p>田螺坑<\/p>","creator":"昆德拉","createTime":"2020-11-04 18:01:42","notes":"发来的","modifier":null,"modifyTime":"2020-12-02 17:42:32"},{"newsId":"581422ce7b5ab56353a5368c482568ce","newsType":"通知","target":"userNews","title":"添加测试2","content":"<p>炼丹炉炼丹炉来说<\/p>","creator":"四棵树","createTime":"2020-11-04 18:00:08","notes":"开心快乐","modifier":null,"modifyTime":"2020-12-02 17:42:36"}],"total":3,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
     */

    private boolean success;
    private DataBean data;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * records : [{"newsId":"94a7275cb9c0bebe16f7b043e9f9d979","newsType":"通知","target":"userNews","title":"添加图片测试","content":"<p>这里是添加图片测试<\/p><p><img src=\"/img/20201110174704893small.44b8d6b5.jpg\"><\/p>","creator":"张鑫","createTime":"2020-11-10 17:47:20","notes":"这里是备注","modifier":null,"modifyTime":"2020-12-02 17:42:39"},{"newsId":"5500ad2f010ebe7c7fbe9e0e18a08b63","newsType":"通知","target":"userNews","title":"添加快乐","content":"<p>田螺坑<\/p>","creator":"昆德拉","createTime":"2020-11-04 18:01:42","notes":"发来的","modifier":null,"modifyTime":"2020-12-02 17:42:32"},{"newsId":"581422ce7b5ab56353a5368c482568ce","newsType":"通知","target":"userNews","title":"添加测试2","content":"<p>炼丹炉炼丹炉来说<\/p>","creator":"四棵树","createTime":"2020-11-04 18:00:08","notes":"开心快乐","modifier":null,"modifyTime":"2020-12-02 17:42:36"}]
         * total : 3
         * size : 10
         * current : 1
         * orders : []
         * optimizeCountSql : true
         * hitCount : false
         * countId : null
         * maxLimit : null
         * searchCount : true
         * pages : 1
         */

        private int total;
        private int size;
        private int current;
        private boolean optimizeCountSql;
        private boolean hitCount;
        private Object countId;
        private Object maxLimit;
        private boolean searchCount;
        private int pages;
        private List<RecordsBean> records;
        private List<?> orders;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public boolean isOptimizeCountSql() {
            return optimizeCountSql;
        }

        public void setOptimizeCountSql(boolean optimizeCountSql) {
            this.optimizeCountSql = optimizeCountSql;
        }

        public boolean isHitCount() {
            return hitCount;
        }

        public void setHitCount(boolean hitCount) {
            this.hitCount = hitCount;
        }

        public Object getCountId() {
            return countId;
        }

        public void setCountId(Object countId) {
            this.countId = countId;
        }

        public Object getMaxLimit() {
            return maxLimit;
        }

        public void setMaxLimit(Object maxLimit) {
            this.maxLimit = maxLimit;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public List<?> getOrders() {
            return orders;
        }

        public void setOrders(List<?> orders) {
            this.orders = orders;
        }

        public static class RecordsBean {
            /**
             * newsId : 94a7275cb9c0bebe16f7b043e9f9d979
             * newsType : 通知
             * target : userNews
             * title : 添加图片测试
             * content : <p>这里是添加图片测试</p><p><img src="/img/20201110174704893small.44b8d6b5.jpg"></p>
             * creator : 张鑫
             * createTime : 2020-11-10 17:47:20
             * notes : 这里是备注
             * modifier : null
             * modifyTime : 2020-12-02 17:42:39
             */

            private String newsId;
            private String newsType;
            private String target;
            private String title;
            private String content;
            private String creator;
            private String createTime;
            private String notes;
            private Object modifier;
            private String modifyTime;


            public String getNewsId() {
                return newsId;
            }

            public void setNewsId(String newsId) {
                this.newsId = newsId;
            }

            public String getNewsType() {
                return newsType;
            }

            public void setNewsType(String newsType) {
                this.newsType = newsType;
            }

            public String getTarget() {
                return target;
            }

            public void setTarget(String target) {
                this.target = target;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreator() {
                return creator;
            }

            public void setCreator(String creator) {
                this.creator = creator;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public Object getModifier() {
                return modifier;
            }

            public void setModifier(Object modifier) {
                this.modifier = modifier;
            }

            public String getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(String modifyTime) {
                this.modifyTime = modifyTime;
            }

        }
    }
}
