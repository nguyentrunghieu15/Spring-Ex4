package ex4.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

@Embeddable
@Data
public class Address implements Serializable {
	private String street;
	private String suite;
	private String city;
	@Column(length = 20)
	private String zipcode;
	@Embedded
	private Geo geo;
}
