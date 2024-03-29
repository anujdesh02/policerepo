package com.example.demo.type;

import org.springframework.data.domain.Sort;

public class SortFilter {

	private String sortType;

	public SortFilter(String type) {
		this.sortType = type;
	}

	public Sort getSortType() {
		if (this.sortType == null) {
			return Sort.by("id").descending();
		}
		switch (this.sortType) {
		case "priceasc":
			return Sort.by("aadhar").ascending();
		case "pricedesc":
			return Sort.by("aadhar").descending();
		case "alphasc":
			return Sort.by("name").ascending();
		case "alphdesc":
			return Sort.by("name").descending();
		default:
			return Sort.by("id").descending();

		}
	}

}
