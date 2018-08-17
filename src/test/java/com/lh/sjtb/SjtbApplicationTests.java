package com.lh.sjtb;

import com.lh.sjtb.mqsend.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SjtbApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private TopicSender sender;

	/*@Test
	public void topic() throws Exception {
		int i=2;
		for(int y=0;y<i;y++){
			sender.send(y);
		}
	}

	@Test
	public void topic1() throws Exception {
		sender.send1();
	}

	@Test
	public void topic2() throws Exception {
		sender.send2();
	}*/

}
