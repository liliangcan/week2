package com.atguigu.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactory implements FactoryBean<Car>{

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		car.setBrand("奥迪");
		car.setPrice(200000.0);
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
