package com.wcy.adminapi.common;

public interface Dict {
     enum ResourceTyep{
        MENU(1,"菜单"),
        METHOD(2,"方法");
        private Integer code;
        private String message;

        ResourceTyep(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
