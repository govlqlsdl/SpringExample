package com.kobi.spring.ex.database.domain;

import java.time.LocalDateTime;

// Domain, Entity class
public class UsedGoods {

	// uesd_goods 테이블의 컬럼 이름과 정확히 일치하는 멤버 변수를 가진 클래스
	// uesd_goods 테이블의 한 행의 정보를 저장하기 위한 목적
	
	private int id;
	private int sellerId;
	private String title;
	private int price;
	private String description;
	private String image;
	private LocalDateTime createdAt;
	private LocalDateTime uodatedAt;
	
	// get/set	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUodatedAt() {
		return uodatedAt;
	}
	public void setUodatedAt(LocalDateTime uodatedAt) {
		this.uodatedAt = uodatedAt;
	}
	
	
}
