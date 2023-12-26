package ex4.Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "photo")
public class Photo implements Serializable {
	private static final long serialVersionUID = -7773892776209991655L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	private String url;
	private String thumbnailUrl;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "album_id")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Album album;
}