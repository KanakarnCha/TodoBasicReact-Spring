package com.example.TodoListBackendSpring.exception;

public class TodoException extends BaseException  {
    public TodoException(String code){
        super(code);
    }
    public static BaseException titleIsNull(){
        return new TodoException("Tittle Is Null");
    }
    public static BaseException contentIsNull(){
        return new TodoException("Content Is Null");
    }
    public static BaseException idIsNull(){
        return new TodoException("Id Is Null");
    }
    public static BaseException notFound(){
        return new TodoException("Not Found");
    }
}

