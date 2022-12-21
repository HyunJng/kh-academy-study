package p301.di.collection.list;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext301.xml");
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		List<String> addresslist = bean.getAddressList();
		
		for(String address : addresslist) {
			System.out.println(address);
		}
		factory.close();
	}
}
