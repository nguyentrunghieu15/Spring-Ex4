package ex4.Model;

import java.io.Serializable;

import org.hibernate.annotations.Columns;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Geo implements Serializable {
	@Column(columnDefinition = "float")
	private float lat;
	@Column(columnDefinition = "float")
	private float lng;
}
