package learn.demo.starter.service;

import learn.demo.starter.properties.DemoProperties;

/**
 * 描述：
 *
 **/
public class DemoService {
	
    public String name;
    
    public DemoService(DemoProperties prop){
        this.name = prop.getName();
    }
    public String say(){
        return "hello " + name;
    }
    
}