package hrs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Reservationinquiry_table")
public class Reservationinquiry {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String customerName;
        private Integer nights;
        private Date checkinDate;
        private String status;
        private Float price;
        private Integer hotelId;


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
        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }
        public Integer getHotelId() {
            return hotelId;
        }

        public void setHotelId(Integer hotelId) {
            this.hotelId = hotelId;
        }

}
