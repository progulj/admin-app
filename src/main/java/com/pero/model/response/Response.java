package com.pero.model.response;

public class Response<T> extends Status{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public T response;
    
    public Response() {
	
    }
    
    public Response(int code, String message) {
	
	setCode(code);
	this.message = message;;
	
    }
    
    public Response(int code, String message, T t) {
	
	setCode(code);
	this.message = message;
	this.response = t;
	
    }

}
