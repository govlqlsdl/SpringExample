package com.kobi.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobi.spring.ex.database.domain.UsedGoods;
import com.kobi.spring.ex.database.repository.UsedGoodsRepository;

// 로직(business) 담당
// 데이터 가공
// 그외 복잡한 기능 수행
// Controller에서 필요한 기능 수행
@Service
public class UsedGoodsService {
	
	// 해당 멤버변수에 String이 자동으로 객체를 생성해서 <주입> 해준다!(new 객체생성 하지 않아도 알아서 해준다)
	@Autowired
	private UsedGoodsRepository usedGoodsRepository;
	
	// 중고물품 게시글 정보 얻어오기
	public List<UsedGoods> getUsedGoodsList() {
		// used_goods 테이블 모든 행 조회
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		// 필요에 따라 데이터 가공하기도 한다
		return usedGoodsList;
		
		
	}

}
