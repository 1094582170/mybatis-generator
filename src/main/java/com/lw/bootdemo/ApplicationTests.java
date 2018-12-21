package com.lw.bootdemo;

import com.github.pagehelper.PageHelper;
import com.lw.bootdemo.mapper.read.MyT1Dao;
import com.lw.bootdemo.mapper.read.MyT2Dao;
import com.lw.bootdemo.mapper.read.T1ReadDao;
import com.lw.bootdemo.mapper.read.T2ReadDao;
import com.lw.bootdemo.mapper.write.T2WriteDao;
import com.lw.bootdemo.pojo.db.T1;
import com.lw.bootdemo.pojo.db.T2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

    @Autowired
	private T2ReadDao t2ReadDao;

	@Autowired
	private T2WriteDao t2WriteDao;

    @Autowired
	private T1ReadDao t1ReadDao;

	@Autowired
	private MyT1Dao myT1Dao;

	@Autowired
	private MyT2Dao myT2Dao;
	@Test
	public void contextLoads() {

	}
	@Test
	public void select(){
		log.info("selectAll:{}",t2ReadDao.selectAll().toString());

		PageHelper.startPage(2, 3);
		List<T2> list = t2ReadDao.selectAll();
		log.info("page selectAll:{}",list);

		T2 t2 = new T2();
		t2.setUserName("lw");
		t2.setUserId(56546);
		log.info("T2 selectOne:{}",t2ReadDao.selectOne(t2));

		T1 t1 = new T1();
		t1.setUserName("lw");
		t1.setUserId(56546);
		log.info("T1 selectOne:{}",t1ReadDao.selectOne(t1));
		log.info("T1 selectName:{}",t1ReadDao.selectName(t1));

		t2 = new T2();
		t2.setUserName("lw");
		log.info("select:{}",t2ReadDao.select(t2));

		Example example = new Example(T1.class);
		example.setOrderByClause("id desc");
		Example.Criteria criteria=example.and();
		criteria.andCondition("user_name = ","lw");
		criteria.andCondition("user_id = ","56546");
		criteria.andEqualTo("user_name","lww");
		criteria.andIn("id", Arrays.asList(1,2,3,4));
		Example.Criteria criteria2=example.or();
		criteria2.andCondition("id = ",1);
		log.info("selectByExample:{}",t1ReadDao.selectByExample(example));


	}
	@Test
	public void update(){
		T2 t2 = new T2();
		t2.setId(1);
		t2.setUserName("好几款");
		t2.setLastUpdateTime(new Date());
		t2WriteDao.updateByPrimaryKeySelective(t2);
		log.info("update:{}",t2);
	}
	@Test
	public void insert(){
		T2 t2 = new T2();
		t2.setUserName("asda的");
		t2.setUserId(126);
		t2.setCreateTime(new Date());
		t2WriteDao.insertSelective(t2);
		log.info("insert:{}",t2);
	}

	@Test
	public void my() {
		log.info("t1 selectOneById:{}", myT1Dao.selectOneById(T1.class, 1));
		T1 t1 = new T1();
		t1.setUserName("lw");
		t1.setId(1);
		log.info("t1 select:{}", myT1Dao.select(t1));
	}

	@Test
	public void myTk() {
		T2 t2 = new T2();
		t2.setId(1);
		t2.setUserName("lw");
		log.info("t2 selectOr:{}", myT2Dao.selectOr(t2));
	}

}
