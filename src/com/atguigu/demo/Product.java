package com.atguigu.demo;

public class Product implements Runnable{

	private Resource resource;
	
	public Product(Resource resource) {
		super();
		this.resource = resource;
	}

	public void run() {
		while(true){
			try {
				resource.set("面包");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
