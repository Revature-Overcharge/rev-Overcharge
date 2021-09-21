package com.revature.overcharge.dto;

import java.util.List;
import java.util.Set;

public class DeckTagsDTO {
	
	private List<Integer> tagsId;
	

	public DeckTagsDTO(List<Integer> tagsId) {
		super();
		this.tagsId = tagsId;
	}
	
	public DeckTagsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Integer> getTagsId() {
		return tagsId;
	}

	public void setTagsId(List<Integer> tagsId) {
		this.tagsId = tagsId;
	}
	
	

}
