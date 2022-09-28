package my.assignment.lottery.draw;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Lottery draws
 */
@Entity
@Table(name = "draw")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Draw {
    @Id
    private long drawNo;
    private long ticketNo;
}
