package training.javaweb.exam.JavaWebExam_lhgbao.dto.response;

public class StatisticResponse {
	private Integer numberOfOwners;
	private Integer numberOfPets;
	private Integer numberOfBoardingStatus;
	private Double sumOfRevenue;
	private Integer numberOfNotes;
	public StatisticResponse() {
		super();
	}
	public StatisticResponse(Integer numberOfOwners, Integer numberOfPets, Integer numberOfBoardingStatus,
			Double sumOfRevenue, Integer numberOfNotes) {
		super();
		this.numberOfOwners = numberOfOwners;
		this.numberOfPets = numberOfPets;
		this.numberOfBoardingStatus = numberOfBoardingStatus;
		this.sumOfRevenue = sumOfRevenue;
		this.numberOfNotes = numberOfNotes;
	}

	public Integer getNumberOfOwners() {
		return numberOfOwners;
	}
	public void setNumberOfOwners(Integer numberOfOwners) {
		this.numberOfOwners = numberOfOwners;
	}
	public Integer getNumberOfPets() {
		return numberOfPets;
	}
	public void setNumberOfPets(Integer numberOfPets) {
		this.numberOfPets = numberOfPets;
	}
	public Integer getNumberOfBoardingStatus() {
		return numberOfBoardingStatus;
	}
	public void setNumberOfBoardingStatus(Integer numberOfBoardingStatus) {
		this.numberOfBoardingStatus = numberOfBoardingStatus;
	}
	public Double getSumOfRevenue() {
		return sumOfRevenue;
	}
	public void setSumOfRevenue(Double sumOfRevenue) {
		this.sumOfRevenue = sumOfRevenue;
	}
	public Integer getNumberOfNotes() {
		return numberOfNotes;
	}
	public void setNumberOfNotes(Integer numberOfNotes) {
		this.numberOfNotes = numberOfNotes;
	}
	
	
}
