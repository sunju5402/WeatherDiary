package zerobase.weather.domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Diary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String weather;
	private String icon;
	private Double temperature;
	private String text;
	private LocalDate date;
}