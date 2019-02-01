package com.lw.bootdemo;

import java.util.Date;

import com.lw.bootdemo.mapper.AnswerMapper;
import com.lw.bootdemo.pojo.db.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    AnswerMapper answerDao;
    private static final Logger log = LoggerFactory.getLogger(ApplicationTests.class);

    @Test
    public void insert() {
        Answer answer = new Answer();
        answer.setId(2);
        answer.setAccount("12");
        answer.setPassword("123456");
        answer.setName("");
        answer.setPhoneNumber("");
        answer.setStatus("1");
        answer.setOwnerType("");
        answer.setOwnerDepId(0);
        answer.setCreateTime(new Date());
        answer.setLastUpdate(new Date());
        answer.setAnswerType("");
        answerDao.insert(answer);
    }

    @Test
    public void insertS() {
        Answer answer = new Answer();
        answer.setId(1);
        answer.setAccount("12");
        answer.setPassword("123456");
        answer.setName("");
        answer.setPhoneNumber("");
        answer.setStatus("1");
        answer.setOwnerType("");
        answer.setOwnerDepId(0);
        answer.setCreateTime(new Date());
        answer.setLastUpdate(new Date());
        answer.setAnswerType("");
        answerDao.insertSelective(answer);
    }

    @Test
    public void selectById() {
            log.info(answerDao.selectById(1269).toString());
    }

    @Test
    public void select() {
        Answer answer = new Answer();
        answer.setAccount("12");
        answer.setPassword("123456");
        answer.setName("");
        answer.setPhoneNumber("");
        answer.setStatus("1");
        log.info(answerDao.select(answer).toString());
    }

    @Test
    public void deleteById() {
        answerDao.deleteById(1);
    }

    @Test
    public void delete() {
        Answer answer = new Answer();
        answer.setId(2);
        answer.setAccount("12");
        answer.setPassword("123456");
        answer.setName("");
        answer.setPhoneNumber("");
        answer.setStatus("1");
        answer.setOwnerType("");
        answer.setOwnerDepId(0);
        answerDao.delete(answer);
    }

    @Test
    public void update() {
        Answer answer = new Answer();
        answer.setId(1269);
        answer.setAccount("12");
        answer.setPassword("eeeeeeeeee");
        answer.setName("");
        answer.setPhoneNumber("");
        answer.setStatus("1");
        answer.setOwnerType("");
        answer.setOwnerDepId(0);
        answerDao.update(answer);
    }

    @Test
    public void updateSelective() {
        Answer answer = new Answer();
        answer.setId(1262);
        answer.setAccount("12");
        answer.setPassword("eeeeeeeeee");
        answer.setName("");
        answer.setPhoneNumber("");
        answer.setStatus("1");
        answer.setOwnerType("");
        answer.setOwnerDepId(0);
        answerDao.updateSelective(answer);
    }
}
