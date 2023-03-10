package zerobase.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JpaMemoRepository;

@SpringBootTest
@Transactional // test code에서는 commit을 안시킴. 다 rollback시킴.
public class JpaMemoRepositoryTest {

	@Autowired
	JpaMemoRepository jpaMemoRepository;

	@Test
	void insertMomoTest() {
		//given
		Memo newMemo = new Memo(10, "this is jpa memo");
		//when
		jpaMemoRepository.save(newMemo);
		//then
		List<Memo> memoList = jpaMemoRepository.findAll();
		assertTrue(memoList.size() > 0);
	}

	@Test
	void findByIdTest() {
	    // given
		Memo newMemo = new Memo(11, "jpa"); // id 어떤 것을 넣어도 상관없음.
	    // when
		Memo memo = jpaMemoRepository.save(newMemo);
		// then
		Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
		assertEquals(result.get().getText(), "jpa");
	}


}
