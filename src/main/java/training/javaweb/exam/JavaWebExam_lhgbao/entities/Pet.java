package training.javaweb.exam.JavaWebExam_lhgbao.entities;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.types.Types;

public class Pet {
	private Integer id;
	private String name;
	private Types type;
	private String breed;
	private Double age;
	private Double weight;
	private String image;
	private LocalDateTime createdAt;
	private Integer ownerId;
	public Pet() {
		super();
	}
	public Pet(Integer id, String name, Types type, String breed, Double age, double weight, 
			String image, LocalDateTime createdAt, Integer ownerId) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
		this.image = image;
		this.createdAt = createdAt;
		this.ownerId = ownerId;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Types getType() {
		return type;
	}
	public void setType(Types type) {
		this.type = type;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", breed=" + breed + ", age=" + age + ", weight="
				+ weight + ", status=" + ", image=" + image + ", createdAt=" + createdAt + ", ownerId="
				+ ownerId + "]";
	}


	
	
}
