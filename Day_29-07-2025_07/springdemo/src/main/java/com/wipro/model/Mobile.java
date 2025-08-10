package com.wipro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
	public  Display display;
	@Autowired
    public Mobile(Display display) {
        this.display = display;
    }

    public void showSpecs() {
        System.out.println("Mobile has display: " + display);
    }

}
