package org.generation.italy.demo.pojo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Photo title must not be null")
	@Size(min=3, max=32, message="Photo title must be min 3 charachters")
	@Column(length=32)
	private String title;
	
	@NotNull
	@NotEmpty(message = "Photo description must contain something")
	@Column(length = 512)
	private String description;
	
	@NotNull
	@NotEmpty(message = "Photo description must contain something")
	@Column(length = 16)
	private String url;
	
	@NotNull
	private Boolean visible;
	
	@OneToMany(mappedBy = "photo", cascade=CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Comment> commentList;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Category> categoryList;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Tag> tagList;
	

	public Photo() {}

	public Photo(
			@NotNull(message = "Photo title must not be null") @Size(min = 3, max = 32, message = "Photo title must be min 3 charachters") String title,
			@NotNull @NotEmpty(message = "Photo description must contain something") String description,
			@NotNull @NotEmpty(message = "Photo description must contain something") String url,
			@NotNull Boolean visible) {
		super();
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
	}
	
	public Photo(
			String title,
			String description,
			String url,
			Boolean visible,
			List<Category> categoryList) {
		this(title,description,url,visible);
		setCategoryList(categoryList);
	}
	
	public Photo(
			String title,
			String description,
			String url,
			Boolean visible,
			List<Category> categoryList,
			List<Tag> tagList) {
		this(title,description,url,visible,categoryList);
		setTagList(tagList);
	}
	
	

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	@Override
	public String toString() {

		return  "\n\n("+getId()+")-->"
				+getTitle()+" - "
				+getDescription()+" - "
				+getUrl()+" - "
				+getVisible();
	}
	
	

}
