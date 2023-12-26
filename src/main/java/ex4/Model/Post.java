package ex4.Model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.HashCodeExclude;
import org.apache.commons.lang3.builder.ToStringExclude;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "post")
public class Post implements Serializable {
	private static final long serialVersionUID = 7967672376127497979L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	@Column(columnDefinition = "TEXT")
	private String body;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@ToStringExclude
	@HashCodeExclude
	private List<Comment> comments;

}
