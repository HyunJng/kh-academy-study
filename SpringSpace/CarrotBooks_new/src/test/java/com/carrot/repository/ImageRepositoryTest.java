package com.carrot.repository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.carrot.domain.AdvertVO;
import com.carrot.domain.AttachImageVO;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class ImageRepositoryTest {
	
	@Autowired ImageRepository imageRepository;
	
	@Test
	public void 이미지리스트가져오기() {
		int refId = 33;
		System.out.println(imageRepository.getAttachList(refId));
	}

}
