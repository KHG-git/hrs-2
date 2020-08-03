package hrs;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Reservation_table")
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String customerName;
    private Integer nights;
    private Date checkinDate;
    private String status;
    private String hotelId;
    private Float price;

    @PrePersist
    public void onPrePersist(){
        Reserved reserved = new Reserved();
        BeanUtils.copyProperties(this, reserved);
        reserved.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        hrs.external.Payment payment = new hrs.external.Payment();
        // mappings goes here
        ReservationApplication.applicationContext.getBean(hrs.external.PaymentService.class)
            .payment(payment);


        ReservationCanceled reservationCanceled = new ReservationCanceled();
        BeanUtils.copyProperties(this, reservationCanceled);
        reservationCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }
    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }




}
