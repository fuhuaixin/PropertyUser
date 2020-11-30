package com.fhx.propertyuser.bean;

public class LoginBean {


    /**
     * success : true
     * data : {"people":{"peopleId":"5bceac80a92b24db853c4715772863ea","name":"我自己","sex":null,"phone":"15738531698","floor":null,"roomNo":null,"type":null,"notes":null,"createTime":null,"updateTime":null,"password":"e10adc3949ba59abbe56e057f20f883e"},"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1YmNlYWM4MGE5MmIyNGRiODUzYzQ3MTU3NzI4NjNlYSIsImV4cCI6MTYwNTE3NjE0NSwiaWF0IjoxNjA1MTcyNTQ1fQ.LyV0iYgXnQ0jBw0BlhPzD1OAt3510-jhAtP-z96ED4o"}
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
         * people : {"peopleId":"5bceac80a92b24db853c4715772863ea","name":"我自己","sex":null,"phone":"15738531698","floor":null,"roomNo":null,"type":null,"notes":null,"createTime":null,"updateTime":null,"password":"e10adc3949ba59abbe56e057f20f883e"}
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1YmNlYWM4MGE5MmIyNGRiODUzYzQ3MTU3NzI4NjNlYSIsImV4cCI6MTYwNTE3NjE0NSwiaWF0IjoxNjA1MTcyNTQ1fQ.LyV0iYgXnQ0jBw0BlhPzD1OAt3510-jhAtP-z96ED4o
         */

        private PeopleBean people;
        private String token;

        public PeopleBean getPeople() {
            return people;
        }

        public void setPeople(PeopleBean people) {
            this.people = people;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class PeopleBean {
            /**
             * peopleId : 5bceac80a92b24db853c4715772863ea
             * name : 我自己
             * sex : null
             * phone : 15738531698
             * floor : null
             * roomNo : null
             * type : null
             * notes : null
             * createTime : null
             * updateTime : null
             * password : e10adc3949ba59abbe56e057f20f883e
             */

            private String peopleId;
            private String name;
            private Object sex;
            private String phone;
            private Object floor;
            private Object roomNo;
            private Object type;
            private Object notes;
            private Object createTime;
            private Object updateTime;
            private String password;

            public String getPeopleId() {
                return peopleId;
            }

            public void setPeopleId(String peopleId) {
                this.peopleId = peopleId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getSex() {
                return sex;
            }

            public void setSex(Object sex) {
                this.sex = sex;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Object getFloor() {
                return floor;
            }

            public void setFloor(Object floor) {
                this.floor = floor;
            }

            public Object getRoomNo() {
                return roomNo;
            }

            public void setRoomNo(Object roomNo) {
                this.roomNo = roomNo;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public Object getNotes() {
                return notes;
            }

            public void setNotes(Object notes) {
                this.notes = notes;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }
        }
    }
}
