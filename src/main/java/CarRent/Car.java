package CarRent;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	private int carId;
	private String carName;
	private String carModel;
	private int carNumber;
	private String carOwnerName;
	private String status="Available";
	
	 // Instead of byte[] use String
    private String image;  // store image path like "images/car1.jpg"

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", carModel=" + carModel + ", carNumber=" + carNumber
				+ ", carOwnerName=" + carOwnerName + ", status=" + status + ", image=" + image + "]";
	}

	public Car() {
		super();
	}

	public Car(int carId, String carName, String carModel, int carNumber, String carOwnerName,String image) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carModel = carModel;
		this.carNumber = carNumber;
		this.carOwnerName = carOwnerName;
		this.image = image;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarOwnerName() {
		return carOwnerName;
	}

	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

}
