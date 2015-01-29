package mw.p11.main;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        System.out.println(System.getenv());
        //System.out.println(System.getProperties());
        Properties props = System.getProperties();
        
        for (Entry<Object, Object> prop : props.entrySet()) {
            System.out.println(prop.getKey().toString() + "=" + prop.getValue().toString());
        }
    }

}
