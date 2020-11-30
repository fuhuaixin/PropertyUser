package com.fhx.propertyuser.bean;

import java.util.List;

public class DeptTreeBean {

    /**
     * success : true
     * data : [{"children":[{"children":[{"name":"电器工程师","id":"129a334b6006e21433b3c30eb2a8f525"},{"name":"文员","id":"8de8d05765269608d6f1989e0ca72010"},{"children":[{"name":"空水技工","id":"23f31ddf735875d51b7987fe34aac187"},{"name":"电梯技工","id":"989c509d3c61a2905fb88f2ddf98affa"},{"name":"电工","id":"a2374b5018e1c5cf96dcdcaa6073f725"},{"name":"综合维修技工","id":"c7d8097235e259e7e900e8a99dc6f177"}],"name":"工程领班","id":"e8042ea78595e60bbba05dba52b55ae9"},{"name":"空水工程师","id":"f0463a1fe4c4cc26a9635e51b685b5cc"}],"name":"工程技术主管","id":"1af2180da6985a822b85b3758f0e1ebc"}],"name":"工程技术部","id":"25800d7c497b89af06e3a0ba9e219697"},{"children":[{"children":[{"children":[{"name":"保洁员","id":"162ca1a91cc76cfd37aed41a0f2e3fe4"}],"name":"保洁领班","id":"5c1390e0d08130c9761644acf8d03795"}],"name":"环境清洁主管","id":"40b7bdc335801ea3621635916f4c8a8a"}],"name":"环境清洁部","id":"318a91142ef16ab6fec390c8a517f551"},{"children":[{"children":[{"children":[{"name":"保安员","id":"353ebf5d25c7041f0b9a09a2d9044b8b"},{"name":"停车管理员","id":"ea0e5b9a3ae0ee110ce7f11ab83ca1e7"}],"name":"保安领班","id":"2a222af0d30fce9b53f62be7fd80a348"},{"name":"消防/监控中心","id":"5b74684e57ed6b08fce461d646a83c15"},{"name":"消防专员","id":"d800bc00cb5c1935116f77c2631e103d"}],"name":"保安部主管","id":"cea92e2690ac5bf385a6e12e7ee49128"}],"name":"保安部","id":"5a0066e1a0a969d810e73a3a4252beec"},{"children":[{"children":[{"children":[{"name":"客服中心值班员","id":"19e204ced14fb0c5a3039d1ea715dec0"},{"name":"商业客服","id":"b4cbe9b331782ddaf89329834d333b14"},{"name":"前台客服","id":"d477f5d729a97c15335782759d5e1965"}],"name":"客服领班","id":"c1a73d8000b13e5db55b854a8aa95e58"}],"name":"客服主管","id":"e0f37a506ee5fbcb65b1520166faa98f"}],"name":"客户服务部","id":"5a99f5fb93cd9f8db4fd84e4c4518fce"},{"children":[{"children":[{"name":"会计","id":"402a8bd3c8a74f152ff2fab1fda14fd1"},{"name":"出纳","id":"7335d92132135df949c2af9834c367c2"}],"name":"财务主管","id":"6a154cdc27c95b80b065862fd6ed86a3"}],"name":"财务部","id":"61d0073f6bf9005ede315eca9a7e3c33"},{"name":"市场部","id":"6ab96dc2dc6a982b34af6d89a98efc26"},{"children":[{"children":[{"name":"行政专员","id":"e2c10de78f2cfa6e9e8de7032b0806c6"}],"name":"行政主管","id":"b0ccc3490b6b6df86873693b86f7c4e3"},{"children":[{"name":"人事专员","id":"f23d819d80049682460d071499126d9f"}],"name":"人事主管","id":"e236c6cd888a07f831e5616b349ce3d6"}],"name":"人事行政部","id":"cef27420b01d7359ef6a093f4c20369b"}]
     */

    private boolean success;
    private List<DataBean> data;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * children : [{"children":[{"name":"电器工程师","id":"129a334b6006e21433b3c30eb2a8f525"},{"name":"文员","id":"8de8d05765269608d6f1989e0ca72010"},{"children":[{"name":"空水技工","id":"23f31ddf735875d51b7987fe34aac187"},{"name":"电梯技工","id":"989c509d3c61a2905fb88f2ddf98affa"},{"name":"电工","id":"a2374b5018e1c5cf96dcdcaa6073f725"},{"name":"综合维修技工","id":"c7d8097235e259e7e900e8a99dc6f177"}],"name":"工程领班","id":"e8042ea78595e60bbba05dba52b55ae9"},{"name":"空水工程师","id":"f0463a1fe4c4cc26a9635e51b685b5cc"}],"name":"工程技术主管","id":"1af2180da6985a822b85b3758f0e1ebc"}]
         * name : 工程技术部
         * id : 25800d7c497b89af06e3a0ba9e219697
         */

        private String name;
        private String id;
        private List<ChildrenBeanXX> children;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<ChildrenBeanXX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanXX> children) {
            this.children = children;
        }

        public static class ChildrenBeanXX {
            /**
             * children : [{"name":"电器工程师","id":"129a334b6006e21433b3c30eb2a8f525"},{"name":"文员","id":"8de8d05765269608d6f1989e0ca72010"},{"children":[{"name":"空水技工","id":"23f31ddf735875d51b7987fe34aac187"},{"name":"电梯技工","id":"989c509d3c61a2905fb88f2ddf98affa"},{"name":"电工","id":"a2374b5018e1c5cf96dcdcaa6073f725"},{"name":"综合维修技工","id":"c7d8097235e259e7e900e8a99dc6f177"}],"name":"工程领班","id":"e8042ea78595e60bbba05dba52b55ae9"},{"name":"空水工程师","id":"f0463a1fe4c4cc26a9635e51b685b5cc"}]
             * name : 工程技术主管
             * id : 1af2180da6985a822b85b3758f0e1ebc
             */

            private String name;
            private String id;
            private List<ChildrenBeanX> children;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<ChildrenBeanX> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBeanX> children) {
                this.children = children;
            }

            public static class ChildrenBeanX {
                /**
                 * name : 电器工程师
                 * id : 129a334b6006e21433b3c30eb2a8f525
                 * children : [{"name":"空水技工","id":"23f31ddf735875d51b7987fe34aac187"},{"name":"电梯技工","id":"989c509d3c61a2905fb88f2ddf98affa"},{"name":"电工","id":"a2374b5018e1c5cf96dcdcaa6073f725"},{"name":"综合维修技工","id":"c7d8097235e259e7e900e8a99dc6f177"}]
                 */

                private String name;
                private String id;
                private List<ChildrenBean> children;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public List<ChildrenBean> getChildren() {
                    return children;
                }

                public void setChildren(List<ChildrenBean> children) {
                    this.children = children;
                }

                public static class ChildrenBean {
                    /**
                     * name : 空水技工
                     * id : 23f31ddf735875d51b7987fe34aac187
                     */

                    private String name;
                    private String id;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }
                }
            }
        }
    }
}
