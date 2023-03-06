package com.carrot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carrot.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class ReplyRepositoryTest {

	@Autowired ReplyRepository replyRepository;
	
	@Test
	public void 댓글등록Test() {
		ReplyVO reply = new ReplyVO();
		
		reply.setBookId("119815960X 9791198159601");
		reply.setContent("test");
		reply.setMemberId(22);
		reply.setRating(3);
		
		replyRepository.enrollReply(reply);
	}
}
