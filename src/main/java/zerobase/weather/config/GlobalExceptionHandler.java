package zerobase.weather.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 전역 예외처리
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500번대
	@ExceptionHandler(Exception.class) // 그 컨트롤러 안에 있는 예외처리만 함.
	public Exception handleAllException() {
		System.out.println("error from GlobalExceptionHandler");
		return new Exception();
	}
}
