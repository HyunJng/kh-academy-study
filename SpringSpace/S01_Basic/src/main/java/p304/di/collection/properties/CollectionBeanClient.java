package p304.di.collection.properties;


import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext304.xml");
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Properties addresslist = bean.getAddressList();

		Set<String> keys = addresslist.stringPropertyNames();
		
		for(String key : keys) {
			System.out.println("key = " + key + ", value = " + addresslist.getProperty(key));
		}
		factory.close();
	}
}
