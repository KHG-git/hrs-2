package hrs;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="HotelReservationManagement_table")
public class HotelReservationManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer reservationId;
    private String status;

    @PrePersist
    public void onPrePersist(){
        ReservationConfirmed reservationConfirmed = new ReservationConfirmed();
        BeanUtils.copyProperties(this, reservationConfirmed);
        reservationConfirmed.publishAfterCommit();


        ReservationConfirmedCanceled reservationConfirmedCanceled = new ReservationConfirmedCanceled();
        BeanUtils.copyProperties(this, reservationConfirmedCanceled);
        reservationConfirmedCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
