package com.carrot.repository.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrot.domain.AttachImageVO;
import com.carrot.repository.ImageRepository;

@Repository("imageRepository")
public class OracleImageRepositoryImpl implements ImageRepository{
	
	private final SqlSessionTemplate mybatis;
	
	@Autowired
	public OracleImageRepositoryImpl(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	@Override
	public List<AttachImageVO> getAttachList(int refId) {
		return mybatis.selectList("ImageMapper.getAttachList", refId);
	}

	
}
