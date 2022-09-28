package my.assignment.lottery.draw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.Getter;
import my.assignment.lottery.ticket.Ticket;
import my.assignment.lottery.ticket.TicketRepository;
@Service
@Scope("application")
public class ScheduledDraw {

    private final static int DRAW_INTERVAL = 5 * 1000;
    @Getter
    private long drawNo = 0;
    
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    DrawRepository drawRepository;
    
    @Scheduled(initialDelay = DRAW_INTERVAL, fixedRate = DRAW_INTERVAL)
    public void drawTicket(){
        List<Ticket> tickets = ticketRepository.findAll();

        if(tickets.isEmpty()){
            return; //wait for another round if no tickets have been bought
        }
        int drawIndex = (int) Math.round(Math.random() * tickets.size());
        Ticket winTicket = tickets.get(drawIndex);
        Draw currentDraw = new Draw(drawNo++, winTicket.getTicketNo());
        drawRepository.save(currentDraw);
        ticketRepository.deleteAll();
    }
    
}
