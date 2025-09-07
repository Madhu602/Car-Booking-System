package CarRent;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private int carId;
    private String userName;
    private String fromDate;
    private String toDate;
    private String carImage;   // <---- NEW field for image path

    public Booking() {}

    public Booking(int carId, String userName, String fromDate, String toDate, String carImage) {
        this.carId = carId;
        this.userName = userName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.carImage = carImage;
    }

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getFromDate() { return fromDate; }
    public void setFromDate(String fromDate) { this.fromDate = fromDate; }

    public String getToDate() { return toDate; }
    public void setToDate(String toDate) { this.toDate = toDate; }

    public String getCarImage() { return carImage; }
    public void setCarImage(String carImage) { this.carImage = carImage; }

    @Override
    public String toString() {
        return "Booking [bookId=" + bookId + ", carId=" + carId + ", userName=" + userName +
               ", fromDate=" + fromDate + ", toDate=" + toDate + ", carImage=" + carImage + "]";
    }
}
