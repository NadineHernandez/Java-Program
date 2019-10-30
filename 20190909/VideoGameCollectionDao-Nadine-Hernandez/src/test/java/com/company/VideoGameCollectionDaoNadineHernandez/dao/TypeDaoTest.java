package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Type;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TypeDaoTest {

    @Autowired
    protected TypeDao dao;

    @Before
    public void setUp() throws Exception {
        List<Type> typeList = dao.readAllType();
        typeList.stream()
                .forEach(type -> dao.deleteType(type.getType_id()));
    }

    @Test
    public void createType() {
        Type type = new Type();
        type.setName("Cartridge");
        type.setDescrption("265vx Cartridge");
        type = dao.createType(type);

        assertEquals(type, dao.readType(type.getType_id()));
    }

    @Test
    public void readType() {
        Type type = new Type();
        type.setName("Cartridge");
        type.setDescrption("265vx Cartridge");
        type = dao.createType(type);

        assertEquals(type, dao.readType(type.getType_id()));
    }

    @Test
    public void readAllType() {
        Type type = new Type();
        type.setName("Cartridge");
        type.setDescrption("265vx Cartridge");
        dao.createType(type);

        Type type2 = new Type();
        type2.setName("Disk");
        type2.setDescrption("500vz5 CD");
        dao.createType(type2);

        assertEquals(2, dao.readAllType().size());
    }

    @Test
    public void updateType() {
        Type type = new Type();
        type.setName("Cartridge");
        type.setDescrption("265vx Cartridge");
        type = dao.createType(type);

        type.setName("Disk");
        type.setDescrption("500vz5 CD");
        dao.updateType(type);

        assertEquals(type, dao.readType(type.getType_id()));
    }

    @Test
    public void deleteType() {
        Type type = new Type();
        type.setName("Cartridge");
        type.setDescrption("265vx Cartridge");
        type = dao.createType(type);

        dao.deleteType(type.getType_id());

        assertNull(dao.readType(type.getType_id()));
    }
}