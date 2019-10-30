package com.company.NadineHernandezCoffeeInventoryJpaRepository;

import com.company.NadineHernandezCoffeeInventoryJpaRepository.dao.CoffeeRepository;
import com.company.NadineHernandezCoffeeInventoryJpaRepository.dao.RoasterRepository;
import com.company.NadineHernandezCoffeeInventoryJpaRepository.dto.Coffee;
import com.company.NadineHernandezCoffeeInventoryJpaRepository.dto.Roaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NadineHernandezCoffeeInventoryJpaRepositoryApplicationTests {

	@Autowired
	CoffeeRepository coffeeRepo;

	@Autowired
	RoasterRepository roasterRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createCoffeeTest(){
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		Coffee coffee = new Coffee();
		coffee.setRoasterId(roaster.getRoasterId());
		coffee.setName("Kenya Decaf");
		coffee.setCount(50);
		coffee.setUnitPrice(8.00);
		coffee.setDescription("Bitter");
		coffee.setType("Decaf");
		coffeeRepo.save(coffee);

		Assert.assertEquals(coffee, coffeeRepo.findOne(coffee.getCoffeeId()));
	}

	@Test
	public void readCoffeeTest(){
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		Coffee coffee = new Coffee();
		coffee.setRoasterId(roaster.getRoasterId());
		coffee.setName("Kenya Decaf");
		coffee.setCount(50);
		coffee.setUnitPrice(8.00);
		coffee.setDescription("Bitter");
		coffee.setType("Decaf");
		coffeeRepo.save(coffee);

		Assert.assertEquals(coffee, coffeeRepo.findOne(coffee.getCoffeeId()));
	}

	@Test
	public void readAllCoffeeTest(){
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		Coffee coffee = new Coffee();
		coffee.setRoasterId(roaster.getRoasterId());
		coffee.setName("Kenya Decaf");
		coffee.setCount(50);
		coffee.setUnitPrice(8.00);
		coffee.setDescription("Bitter");
		coffee.setType("Decaf");
		coffeeRepo.save(coffee);

		Coffee coffee2 = new Coffee();
		coffee2.setRoasterId(roaster.getRoasterId());
		coffee2.setName("Brazil Java");
		coffee2.setCount(75);
		coffee2.setUnitPrice(6.50);
		coffee2.setDescription("Dark Roast");
		coffee2.setType("Caffinated");
		coffeeRepo.save(coffee2);

		Assert.assertEquals(2, coffeeRepo.findAll().size());
	}

	@Test
	public void updateCoffeeTest(){
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		Coffee coffee = new Coffee();
		coffee.setRoasterId(roaster.getRoasterId());
		coffee.setName("Kenya Decaf");
		coffee.setCount(50);
		coffee.setUnitPrice(8.00);
		coffee.setDescription("Bitter");
		coffee.setType("Decaf");
		coffeeRepo.save(coffee);

		coffee.setRoasterId(roaster.getRoasterId());
		coffee.setName("Brazil Java");
		coffee.setCount(75);
		coffee.setUnitPrice(6.50);
		coffee.setDescription("Dark Roast");
		coffee.setType("Caffinated");
		coffeeRepo.save(coffee);

		Assert.assertEquals(coffee, coffeeRepo.findOne(coffee.getCoffeeId()));
	}

	@Test
	public void deleteCoffeeTest(){
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		Coffee coffee = new Coffee();
		coffee.setRoasterId(roaster.getRoasterId());
		coffee.setName("Kenya Decaf");
		coffee.setCount(50);
		coffee.setUnitPrice(8.00);
		coffee.setDescription("Bitter");
		coffee.setType("Decaf");
		coffeeRepo.save(coffee);

		Assert.assertNull(coffeeRepo.findOne(coffee.getCoffeeId()));
	}

	@Test
	public void findCoffeeByRoasterTest(){
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		Coffee coffee = new Coffee();
		coffee.setRoasterId(roaster.getRoasterId());
		coffee.setName("Kenya Decaf");
		coffee.setCount(50);
		coffee.setUnitPrice(8.00);
		coffee.setDescription("Bitter");
		coffee.setType("Decaf");
		coffeeRepo.save(coffee);

		Coffee coffee2 = new Coffee();
		coffee2.setRoasterId(roaster.getRoasterId());
		coffee2.setName("Brazil Java");
		coffee2.setCount(75);
		coffee2.setUnitPrice(6.50);
		coffee2.setDescription("Dark Roast");
		coffee2.setType("Caffinated");
		coffeeRepo.save(coffee2);

		Assert.assertEquals(2, coffeeRepo.findByRoaster(coffee.getRoasterId()));
	}

	@Test
	public void findCoffeeByTypeTest(){
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		Coffee coffee = new Coffee();
		coffee.setRoasterId(roaster.getRoasterId());
		coffee.setName("Kenya Decaf");
		coffee.setCount(50);
		coffee.setUnitPrice(8.00);
		coffee.setDescription("Bitter");
		coffee.setType("Decaf");
		coffeeRepo.save(coffee);

		Coffee coffee2 = new Coffee();
		coffee2.setRoasterId(roaster.getRoasterId());
		coffee2.setName("Brazil Java");
		coffee2.setCount(75);
		coffee2.setUnitPrice(6.50);
		coffee2.setDescription("Dark Roast");
		coffee2.setType("Decaf");
		coffeeRepo.save(coffee2);

		Assert.assertEquals(2, coffeeRepo.findByType(coffee.getType()));
	}

	@Test
	public void createRoasterTest(){
		roasterRepo.deleteAll();
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		Assert.assertEquals(roaster, roasterRepo.findOne(roaster.getRoasterId()));
	}

	@Test
	public void readRoasterTest(){
		roasterRepo.deleteAll();
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		Assert.assertEquals(roaster, roasterRepo.findOne(roaster.getRoasterId()));
	}

	@Test
	public void readAllRoastersTest(){
		roasterRepo.deleteAll();
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("Ohio");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		Roaster roaster2 = new Roaster();
		roaster2.setName("Bean Juice");
		roaster2.setStreet("1508 Garland Rd");
		roaster2.setCity("Grandale");
		roaster2.setState("MN");
		roaster2.setPostalCode("90763");
		roaster2.setPhone("9108557027");
		roaster2.setEmail("info@beanjuice.com");
		roaster2.setNote("50 Units minimum order");
		roasterRepo.save(roaster2);

		Assert.assertEquals(2, roasterRepo.findAll().size());
	}

	@Test
	public void updateRoasterTest(){
		roasterRepo.deleteAll();
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		roaster.setName("Bean Juice");
		roaster.setStreet("1508 Garland Rd");
		roaster.setCity("Grandale");
		roaster.setState("MN");
		roaster.setPostalCode("90763");
		roaster.setPhone("9108557027");
		roaster.setEmail("info@beanjuice.com");
		roaster.setNote("50 Units minimum order");

		Assert.assertEquals(roaster, roasterRepo.findOne(roaster.getRoasterId()));
	}

	@Test
	public void deleteRoasterTest(){
		roasterRepo.deleteAll();
		Roaster roaster = new Roaster();
		roaster.setName("Java Roasters");
		roaster.setStreet("2059 Birchwood Ln");
		roaster.setCity("Greenville");
		roaster.setState("OH");
		roaster.setPostalCode("80132");
		roaster.setPhone("3805668896");
		roaster.setEmail("contact@javaroasters.com");
		roaster.setNote("Holiday Vendor");
		roasterRepo.save(roaster);

		roasterRepo.delete(roaster.getRoasterId());

		Assert.assertNull(roasterRepo.findOne(roaster.getRoasterId()));
	}

}
