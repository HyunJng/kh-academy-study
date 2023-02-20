package com.carrot.repository;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carrot.domain.AdvertVO;
import com.carrot.domain.AttachImageVO;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class AdvertRepositoryTest {
	
	@Autowired AdvertRepository advertRepository;
	
	@Test
	public void 광고저장() {
		AdvertVO advert = new AdvertVO();
		Date date = new Date(2023, 03, 01);
		
		advert.setAdvertName("test6");
		advert.setBookId("111");
		advert.setCompany("회사");
		advert.setEndDate(date);
		advert.setRegDate(date);
		advert.setUploader(1);
		
		advertRepository.saveAdvert(advert);
		System.out.println("advertVO확인: " + advert.getAdvertId());
		AttachImageVO vo = new AttachImageVO();
		
		vo.setAdvertId(advert.getAdvertId());
		vo.setFileName("test");
		vo.setUploadPath("aaaaa");
		vo.setUuid("11111");
		
		advertRepository.saveAdvertImage(vo);
	}
}
