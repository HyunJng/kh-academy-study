package p012.coupling.factory_pattern;

/*
 * instance를 만드는 공장(factory)
 * - 새로운 class가 생기면 지속적으로 soure코드를 수정해야함.
 * - application coding design 패턴 중 :: factory pattern
*/
public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		}
		else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
