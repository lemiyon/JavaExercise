import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ReflectionTest {

	class ReflectionTeller {
		public void tell(Object obj) {
			Class<?> classObj = obj.getClass();
			System.out.format("class Name : %s\n", classObj.getName());
			
			Method[] ms = classObj.getMethods();
			
			int size = ms.length;
			for(int i = 0; i < size; i++) {
				System.out.println("Method : " + ms[i].getName());
				System.out.print("ParameterType : ");
				for(Class<?> p : ms[i].getParameterTypes()) {
					System.out.print(p.getName() + ",");
				}
				System.out.println("\nreturnType : " +  ms[i].getDeclaringClass().getName());
				System.out.println();
			}
		}
	}
	
	ReflectionTeller rt;
	
	@Before
	public void setUp() {
		rt = new ReflectionTeller();
	}
	@Test
	public void test() {
		 rt.tell(new ArrayList());
	}

}
