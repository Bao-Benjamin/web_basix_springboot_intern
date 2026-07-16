package training.javaweb.exam.JavaWebExam_lhgbao.dto.response;

import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.types.Types;

public class PetResponse {
	private int id;
	private String name;
	private double age;
	private String ownerName;
	private Types type;
	private double weight;
	private String breed;
	private String image;
	public PetResponse() {
		super();
	}
	public PetResponse(String name, double age, String ownerName, Types type, double weight, String species, String image) {
		super();
		this.name = name;
		this.age = age;
		this.ownerName = ownerName;
		this.type = type;
		this.weight = weight;
		this.breed = species;
		this.image = image;
	}
	
	public PetResponse(int id, String name, double age, String ownerName, Types type, double weight, String species, String image) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.ownerName = ownerName;
		this.type = type;
		this.weight = weight;
		this.breed = species;
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
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setAge(double age) {
		this.age = age;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
