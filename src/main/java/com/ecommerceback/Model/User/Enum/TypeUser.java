package com.ecommerceback.Model.User.Enum;

public enum TypeUser {

    ADMIN(1,"ADMIN"),
    USER(2,"USER"),
    SELLER_USER(3,"SELLER_ADMIN");

    private int code;
    private String description;

    TypeUser() {
    }

    TypeUser(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
    public static  TypeUser toEnum(Integer code){
        if(code == null){
            return null;
        }
        for(TypeUser x:TypeUser.values()){
            if(code.equals(x.getCode())){
                return x;
            }
        }
        throw new IllegalArgumentException("Código invalido");
    }


}
