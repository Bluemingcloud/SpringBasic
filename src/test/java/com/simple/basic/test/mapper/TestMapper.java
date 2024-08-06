package com.simple.basic.test.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper // Mapper 라는 뜻의 어노테이션 작성해 두는 것이 좋다.
public interface TestMapper {

	public String getTime();
}
