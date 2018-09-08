package com.atguigu.demo;

public class Resource {

	private String name;
	private int count=1;
	
	private boolean flag = false;	//false代表没有面包,要生产
	
	//生产 t1  t2
	public synchronized void set(String name) throws InterruptedException{
		if(flag==false){
			this.name = name+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...生产.."+this.name);
			flag=true;//生产完了
			notifyAll();//唤醒消费者,让消费者来消费
		}else{
			//flag为true,不生产,让消费者消费
			wait();
		}
	}
	
	//消费 t3  t4
	public synchronized void con() throws InterruptedException{
		if(flag==true){
			System.out.println(Thread.currentThread().getName()+"消费...."+name);
			flag=false;//消费完了
			notifyAll();//唤醒生产者,让生产者生产
		}else{
			wait();
			
		}
	}
}
