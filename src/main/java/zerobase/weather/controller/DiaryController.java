package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

@RequiredArgsConstructor
@RestController
public class DiaryController {

	private final DiaryService diaryService;

	@ApiOperation(value = "일기 텍스트와 날씨를 이용해서 DB에 일기 저장", notes = "노트 예시")
	@PostMapping("/create/diary")
	void createDiary(
		@RequestParam(required = false) @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식 : yyyy-MM-dd", example = "2020-02-02") LocalDate date
		, @RequestBody @ApiParam(value = "일기 내용을 입력하세요.") String text) {
		diaryService.createDiary(date, text);
	}

	@ApiOperation("선택한 날짜의 모든 일기 데이터를 가져옵니다.")
	@GetMapping("/read/diary")
	List<Diary> readDiary(
		@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식 : yyyy-MM-dd", example = "2020-02-02") LocalDate date) {
		return diaryService.readDiary(date);
	}

	@ApiOperation("선택한 기간의 모든 일기 데이터를 가져옵니다.")
	@GetMapping("/read/diaries")
	List<Diary> readDiaries(
		@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "조회할 기간의 첫번째 날", example = "2020-02-02") LocalDate startDate
		, @RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식 : yyyy-MM-dd", example = "2020-02-02") LocalDate endDate
	) {
		return diaryService.readDiaries(startDate, endDate);
	}

	@ApiOperation("해당 날짜의 텍스트를 바꿀 수 있습니다.")
	@PutMapping("/update/diary")
	void updateDiary(
		@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식 : yyyy-MM-dd", example = "2020-02-02") LocalDate date
		, @RequestBody @ApiParam(value = "일기 내용을 입력하세요.") String text
	) {
		diaryService.updateDiary(date, text);
	}

	@ApiOperation("선택한 날짜의 일기를 삭제할 수 있습니다.")
	@DeleteMapping("/delete/diary")
	void deleteDiary(
		@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식 : yyyy-MM-dd", example = "2020-02-02") LocalDate date) {
		diaryService.deleteDiary(date);
	}
}
