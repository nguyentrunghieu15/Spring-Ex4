package ex4.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Geo implements Serializable {
	private static final long serialVersionUID = 5202242287563996730L;
	@Column(columnDefinition = "float")
	private float lat;
	@Column(columnDefinition = "float")
	private float lng;
}
