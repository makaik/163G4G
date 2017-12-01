package com.perfact.sbm.common.bean;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	private int pagesize;
	private int pagetotal;
	private int p;//
	private int count;
	private List data;
	
	public PageBean() {
		pagesize = 5;
		data = new ArrayList();
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagetotal() {
		return pagetotal;
	}
	public void setPagetotal(int pagetotal) {
		this.pagetotal = pagetotal;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		if(p < 1){//2
			this.p = 1;
		}else if(p > pagetotal){//pagetotal=0
			this.p = pagetotal;
		}else{
			this.p = p;
		}
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		pagetotal = (int)(Math.ceil(count*1.0/pagesize));
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}

	public void addData(Object obj){
		data.add(obj);
	}
	
}
