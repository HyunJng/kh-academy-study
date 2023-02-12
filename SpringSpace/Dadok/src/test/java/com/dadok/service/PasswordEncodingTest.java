package com.dadok.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class PasswordEncodingTest {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Test
    public void 비밀번호인코딩() {
        String rawPassword = "vam123";                //인코딩 전 메서드
        String encodePassword1;                        // 인코딩된 메서드
        String encodePassword2;                        // 똑같은 비밀번호 데이터를 encdoe()메서드를 사용했을 때 동일한 인코딩된 값이 나오는지 확인하기 위해 추가
        
        encodePassword1 = passwordEncoder.encode(rawPassword);
        encodePassword2 = passwordEncoder.encode(rawPassword);

        assertThat(encodePassword1, is((not(encodePassword2))));

        String truePassowrd = "vam123";
        String falsePassword = "asdfjlasf";
        
        assertThat(true, is(passwordEncoder.matches(truePassowrd, encodePassword1)));
        assertThat(true, is(not(passwordEncoder.matches(falsePassword, encodePassword1))));
        
    }
}
