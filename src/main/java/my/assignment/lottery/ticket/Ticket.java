package my.assignment.lottery.ticket;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Ticket
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="TICKET")
public class Ticket implements Serializable{

    @Id
    private Long ticketNo;
    @Transient
    private Long drawNo;
}