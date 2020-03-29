package com.dx.mybatis.mapper;

import com.dx.mybatis.pojo.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dengx
 * @date 2020/3/26-15:25
 * @for
 */
@Repository
//@Mapper
public interface PersonMapper {

    @Select("select * from person where id=#{id}")
    public Person findOne(int id);

    @Delete("delete from person where id=#{id}")
    public int deleteOne(int id);
    @Select("select * from person")
    public List<Person> findAll();
    @Insert("insert into person (name,age,salary) values (#{name},#{age},#{salary})")
    public int addPerson(Person person);

}
