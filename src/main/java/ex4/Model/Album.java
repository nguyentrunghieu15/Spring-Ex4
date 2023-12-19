package ex4.Model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.HashCodeExclude;
import org.apache.commons.lang3.builder.ToStringExclude;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "album")
public class Album implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	@ToStringExclude
	@HashCodeExclude
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	@ToStringExclude
	@HashCodeExclude
	private List<Photo> photos;
}
