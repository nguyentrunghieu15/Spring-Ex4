package ex4.Model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Company implements Serializable {
	private static final long serialVersionUID = 3113160671139699683L;
	private String company_name;
	private String catch_phrase;
	private String bs;
}
