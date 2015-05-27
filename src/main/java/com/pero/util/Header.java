package com.pero.util;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class Header extends HttpHeaders {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

	public Header(){
		
		this.set("Access-Control-Allow-Origin", "*");
		this.set("Access-Control-Allow-Credentials", "true");
		this.set("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		this.set("Access-Control-Max-Age", "3600");
		this.set("Access-Control-Allow-Headers",  "Content-Type, Accept, X-Requested-With");
	}
		

}