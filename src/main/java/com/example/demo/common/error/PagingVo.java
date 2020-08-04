package com.example.demo.common.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PagingVo{
		private List<?> content;
		private int  totalPages;
		private long  totalElements;
		private int  pageNumber;
		private int  pageSize;
		private boolean lastPage;
		
		@Builder
		public PagingVo(List<?> content, int totalPages, long totalElements, int pageNumber, int pageSize, boolean isLast) {
			this.totalPages = totalPages;
			this.totalElements = totalElements;
			this.pageNumber = pageNumber;
			this.pageSize = pageSize;
			this.lastPage = isLast;
			this.content =  content;
		}
		
}
