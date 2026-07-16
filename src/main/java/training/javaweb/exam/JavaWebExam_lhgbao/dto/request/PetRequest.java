package training.javaweb.exam.JavaWebExam_lhgbao.dto.request;

import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.types.Types;

public class PetRequest {
	@NotEmpty(message="Name's pet can not empty")
	private String name;
//	@NotEmpty(message="Age's pet can not empty")
	private Double age;
	private Integer ownerId;
	@NotEmpty(message="Type can not empty")
	private Types type;
	private Double weight;
	private String breed;
	private String image;
	public PetRequest() {
		super();
	}
	public PetRequest(@NotEmpty(message = "Name's pet can not empty") String name,
			@NotEmpty(message = "Age's pet can not empty") Double age, Integer ownerId,	String image) {
		super();
		this.name = name;
		this.age = age;
		this.ownerId = ownerId;
		this.type = type;
		this.weight = weight;
		this.breed = breed;
		this.image = image;
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
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "PetRequest [name=" + name + ", age=" + age + ", ownerId=" + ownerId + ", type=" + type + ", weight="
				+ weight + ", species=" + breed + ", status=" + ", image=" + image + "]";
	}
	
	
}
