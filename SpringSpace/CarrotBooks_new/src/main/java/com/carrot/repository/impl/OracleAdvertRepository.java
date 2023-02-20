package com.carrot.repository.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrot.domain.AdvertVO;
import com.carrot.domain.AttachImageVO;
import com.carrot.domain.Criteria;
import com.carrot.repository.AdvertRepository;

@Repository("advertRepository")
public class OracleAdvertRepository implements AdvertRepository{

	private final SqlSessionTemplate mybatis;
	
	@Autowired
	public OracleAdvertRepository(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	@Override
	public void saveAdvert(AdvertVO advert) {
		mybatis.insert("AdvertMapper.insertAdvert", advert);
	}

	@Override
	public void saveAdvertImage(AttachImageVO image) {
		mybatis.insert("AdvertMapper.insertImage", image);
	}

	@Override
	public List<AdvertVO> getAdvertList(Criteria cri) {
		return mybatis.selectList("AdvertMapper.getAdvertList", cri);
	}

	@Override
	public int getTotal() {
		return mybatis.selectOne("AdvertMapper.getTotal");
	}
	
}
