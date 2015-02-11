package mw.p11.main;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
//        System.out.println(System.getenv());
        //System.out.println(System.getProperties());
        System.out.println("--------------ENVIRONMENT--------------");
        Map<String,String> envP = System.getenv();
        
        for (Entry<String, String> entry : envP.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        
        System.out.println("--------------PROPERTIES--------------");
        Properties props = System.getProperties();
        
        for (Entry<Object, Object> prop : props.entrySet()) {
            System.out.println(prop.getKey().toString() + "=" + prop.getValue().toString());
        }
        
//        Map<Object,Object> attrbs = Attributes.
    }

}
