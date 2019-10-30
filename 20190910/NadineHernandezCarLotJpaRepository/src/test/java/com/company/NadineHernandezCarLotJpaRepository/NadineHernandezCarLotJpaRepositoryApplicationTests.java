package com.company.NadineHernandezCarLotJpaRepository;

import com.company.NadineHernandezCarLotJpaRepository.dao.CarRepository;
import com.company.NadineHernandezCarLotJpaRepository.dto.Car;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NadineHernandezCarLotJpaRepositoryApplicationTests {

	@Autowired
	CarRepository carRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createCar(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Carolla");
		car.setYear("2010");
		car.setColor("blue");
		carRepo.save(car);

		Assert.assertEquals(1, carRepo.findAll().size());
	}

	@Test
	public void readCarById(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Carolla");
		car.setYear("2010");
		car.setColor("blue");
		car = carRepo.save(car);

		Car car2 = new Car();
		car2.setMake("Toyota");
		car2.setModel("Camry");
		car2.setYear("2018");
		car2.setColor("black");
		carRepo.save(car2);

		Assert.assertEquals(car, carRepo.findOne(car.getId()));
	}

	@Test
	public void readAllCars(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Carolla");
		car.setYear("2010");
		car.setColor("blue");
		carRepo.save(car);

		Car car2 = new Car();
		car2.setMake("Toyota");
		car2.setModel("Camry");
		car2.setYear("2018");
		car2.setColor("black");
		carRepo.save(car2);

		Assert.assertEquals(2, carRepo.findAll().size());
	}

	@Test
	public void updateCar(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Carolla");
		car.setYear("2010");
		car.setColor("blue");
		carRepo.save(car);

		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear("2018");
		car.setColor("black");
		carRepo.save(car);

		Assert.assertEquals(car, carRepo.findOne(car.getId()));
	}

	@Test
	public void deleteCar(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Carolla");
		car.setYear("2010");
		car.setColor("blue");
		carRepo.save(car);

		carRepo.delete(car.getId());

		Assert.assertNull(carRepo.findOne(car.getId()));
	}

	@Test
	public void findCarByMake(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Carolla");
		car.setYear("2010");
		car.setColor("blue");
		carRepo.save(car);

		Car car2 = new Car();
		car2.setMake("Toyota");
		car2.setModel("Camry");
		car2.setYear("2018");
		car2.setColor("black");
		carRepo.save(car2);

		Assert.assertEquals(2,carRepo.findByMake(car.getMake()).size());
	}

	@Test
	public void findCarByColor(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Carolla");
		car.setYear("2010");
		car.setColor("blue");
		carRepo.save(car);

		Car car2 = new Car();
		car2.setMake("Honda");
		car2.setModel("Civic");
		car2.setYear("2018");
		car2.setColor("blue");
		carRepo.save(car2);

		Assert.assertEquals(2, carRepo.findByColor(car.getColor()).size());
	}

	@Test
	public void findCarByMakeAndColor(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Carolla");
		car.setYear("2010");
		car.setColor("blue");
		carRepo.save(car);

		Car car2 = new Car();
		car2.setMake("Toyota");
		car2.setModel("Camry");
		car2.setYear("2018");
		car2.setColor("blue");
		carRepo.save(car2);

		Assert.assertEquals(2, carRepo.findByMakeAndColor(car.getMake(), car.getColor()).size());
	}

}
