package com.simple.basic.uti.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // AOP 클래스
@Component // 이 클래스는 component-scan 에 읽혀서 bean 으로 생성됨
public class LogAdvice {
	
	// advice - 공통기능
	// point cut - 내가 적용할 메서드에 advice 부착하는 행위
	// 맨 앞 * 는 모든 접근제어자에
	// 중간의 * 는 어떤 이름(컨트롤러 명)도 상관없이 모두
	// 맨마지막 *(..) 는 모든 메서드에 적용
	//@Before("execution(*com.simple.basic.controller.*Controller.*(..))")
	//@Before("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public void beforeLog() {
		System.out.println("---메서드 실행전 동작---");
	}
	
	//@After("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public void afterLog() {
		System.out.println("---메서드 실행후 동작---");
	}
	
//	@AfterThrowing(pointcut = "execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))", 
//					throwing = "e" // 에러를 처리할 변수명
//					)
	public void exceptionLog(Exception e) {
		System.out.println("advice 에러로그:" + e);
	}
	
	
	// Log 확인
	// 해당 클래스에서 로그를 사용함 (base 패키지 밑에 존재해야 사용가능)
	public static final Logger log = LoggerFactory.getLogger(LogAdvice.class);
	
	
	//@Around - after, before, afterThrowing 세가지를 결합해서, 처리할 수 있게 해주는 어노테이션
	// 규칙
	// 반환 : Object 타입
	// 매개변수 : ProceedingJoinPoint 객체 (실행 지점을 결정지어줄 수 있는 객체)
	@Around("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		
		/*
		 * 메서드로 넘어오는 매개변수 확인 가능
		 * 메서드 실행되는 target 확인 가능
		 * 이러한 결과들을 수집해서, 전체 log 로 찍어주거나 FileOutput을 이용해서 실행로그 출력을 해줄 수 있음.
		 */
//		System.out.println("실행할 클래스(target):" + jp.getTarget());
//		System.out.println("실행할 메서드:" + jp.getSignature().toString());
//		System.out.println("실행할 메서드의 매개변수:" + Arrays.toString(jp.getArgs()));
		
		long start = System.currentTimeMillis();
		
		log.info("실행할 클래스(target):" + jp.getTarget());
		log.info("실행할 메서드:" + jp.getSignature().toString());
		log.info("실행할 메서드의 매개변수:" + Arrays.toString(jp.getArgs()));
		
		Object result = null;
		
		try {
			
			// jp.proceed() 실행 이전은 @Before
			
			result = jp.proceed(); // 해당 메서드 실행(Joint Point 실행)
			
			// jp.proceed() 실행 이후는 @After
			
			long end = System.currentTimeMillis();
			log.info("실행시간:" + (end - start) * 0.001);
			
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
			String formatedNow = now.format(formatter);
			
			String path = "C:\\Users\\bsm\\Desktop\\course\\spring\\spring_log\\" + formatedNow + "_log.txt";
			BufferedWriter bos = new BufferedWriter(new FileWriter(path, true));
			bos.write("실행할 클래스(target):" + jp.getTarget() + "\n"); // 파일을 작성
			bos.write("실행할 메서드:" + jp.getSignature().toString() + "\n"); 
			bos.write("실행할 메서드의 매개변수:" + Arrays.toString(jp.getArgs()) + "\n");
			bos.write("실행시간:" + (end - start) * 0.001);
			bos.flush();
			bos.close();
			
		} catch (Throwable e) {
			e.printStackTrace(); // 해당 메서드에서 에러가 발생하면, 여기서 로그를 같이 찍음
		}
		
		return result;
	}

}
