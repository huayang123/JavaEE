import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {

	@Autowired
	private UserService userService;

	@Test
	public void test1() {
		userService.insert();
	}

	@Test
	public void test2() {
		userService.delete();
	}

	@Test
	public void test3() {
		userService.update();
	}

	@Test
	public void test4() {
		userService.find();
	}
}
