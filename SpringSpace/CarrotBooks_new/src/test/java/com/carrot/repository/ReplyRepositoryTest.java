package com.carrot.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carrot.domain.Criteria;
import com.carrot.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class ReplyRepositoryTest {

	@Autowired ReplyRepository replyRepository;
	
	/*
	@Test
	public void 댓글등록Test() {
		ReplyVO reply = new ReplyVO();
		
		reply.setBookId("119815960X 9791198159601");
		reply.setContent("test");
		reply.setMemberId(22);
		reply.setRating(3);
		
		replyRepository.enrollReply(reply);
	}
	 */
	
	@Test
	public void 댓글리스트bymemberId() {
		Criteria cri = new Criteria();
		cri.setKeyword("22");
		List<ReplyVO> list = replyRepository.getReplyListbyMemberId(cri);
		list.forEach(x -> System.out.println(x));
	}
}
