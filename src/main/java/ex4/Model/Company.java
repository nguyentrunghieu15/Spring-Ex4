package ex4.Model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Company implements Serializable {
	private String company_name;
	private String catch_phrase;
	private String bs;
}
