package training.javaweb.exam.JavaWebExam_lhgbao.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AdminSetting {
	  private Integer id;
	  private Double pricePerDay;
	  private Double lateFeePerHour;
	  private Double penaltyPercentage;
	  private Integer updatedBy;      
	  private LocalDateTime updatedAt;
	  public AdminSetting() {
		super();
	  }  
	  public AdminSetting(Integer id, Double pricePerDay, Double lateFeePerHour, Double penaltyPercentage, Integer updatedBy,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.pricePerDay = pricePerDay;
		this.lateFeePerHour = lateFeePerHour;
		this.penaltyPercentage = penaltyPercentage;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}

	  public double countBaseFee(LocalDate dateStart, LocalDate expectedDate) {
		  long daysBetween = ChronoUnit.DAYS.between(dateStart, expectedDate);
		  return this.pricePerDay * daysBetween;
	  }
	  public double countLateFee(LocalDate dateStart, LocalDate dateEnd) {
		  if (dateEnd == null || dateEnd.isBefore(dateStart)) {
		        return 0.0;
		    }
		  long daysBetween = ChronoUnit.DAYS.between(dateStart, dateEnd);
		  return daysBetween* this.pricePerDay* this.penaltyPercentage;
	  }
	  public Integer getId() {
		  return id;
	  }
	  public void setId(Integer id) {
		  this.id = id;
	  }
	  public Double getPricePerDay() {
		  return pricePerDay;
	  }
	  public void setPricePerDay(Double pricePerDay) {
		  this.pricePerDay = pricePerDay;
	  }
	  public Double getLateFeePerHour() {
		  return lateFeePerHour;
	  }
	  public void setLateFeePerHour(Double lateFeePerHour) {
		  this.lateFeePerHour = lateFeePerHour;
	  }
	  public Integer getUpdatedBy() {
		  return updatedBy;
	  }
	  public void setUpdatedBy(Integer updatedBy) {
		  this.updatedBy = updatedBy;
	  }
	  public LocalDateTime getUpdatedAt() {
		  return updatedAt;
	  }
	  public void setUpdatedAt(LocalDateTime updatedAt) {
		  this.updatedAt = updatedAt;
	  }
	  
	  public Double getPenaltyPercentage() {
		return penaltyPercentage;
	}
	  public void setPenaltyPercentage(Double penaltyPercentage) {
		  this.penaltyPercentage = penaltyPercentage;
	  }
	  @Override
	  public String toString() {
		return "AdminSetting [id=" + id + ", baseFee=" + pricePerDay + ", lateFeePerHour=" + lateFeePerHour + ", updatedBy="
				+ updatedBy + ", updatedAt=" + updatedAt + "]";
	  }
	  
	  
	  
}
