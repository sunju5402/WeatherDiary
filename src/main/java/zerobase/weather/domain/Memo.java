package zerobase.weather.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "memo")
public class Memo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// identity : springboot는 키생성 하지 않고 db에 데이터 넣어보고, db가 만들어준 키값이 있으면 그걸 갖고 옴.
	private int id;
	private String text;
}
