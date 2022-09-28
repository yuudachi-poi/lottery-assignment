package my.assignment.lottery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import my.assignment.lottery.draw.Draw;
import my.assignment.lottery.draw.DrawRepository;
import my.assignment.lottery.draw.ScheduledDraw;
import my.assignment.lottery.ticket.Ticket;
import my.assignment.lottery.ticket.TicketRepository;
import my.assignment.lottery.utils.NumberGeneratorUtil;

/**
 * LotteryService
 */
@Service
public class LotteryService {
    @Autowired
    private final TicketRepository ticketRepository;
    @Autowired
    private final DrawRepository drawRepository;
    @Autowired
    private final NumberGeneratorUtil numberGenerator;

    @Autowired
    private final ScheduledDraw scheduledDraw;

    public LotteryService(TicketRepository ticketRepository, DrawRepository drawRepository, NumberGeneratorUtil numberGenerator, ScheduledDraw scheduledDraw) {
        this.ticketRepository = ticketRepository;
        this.drawRepository = drawRepository;
        this.numberGenerator = numberGenerator;
        this.scheduledDraw = scheduledDraw;
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
	}

    public Ticket createTicket(){
        long ticketNo = numberGenerator.generateRandNumber();
        Optional<Ticket> tOptional = this.ticketRepository.findById(ticketNo);
        while(tOptional.isPresent()){
            ticketNo = numberGenerator.generateRandNumber();
            tOptional = this.ticketRepository.findById(ticketNo);
        }
        Ticket ticket = new Ticket(ticketNo, scheduledDraw.getDrawNo());
        this.ticketRepository.save(ticket);
        return ticket;

    }

    public List<Draw> getDraws() {
        return drawRepository.findAll();
	}
    public Draw getDraw(Long drawNo) {
        Optional<Draw> optDraw = drawRepository.findById(drawNo);
        if(!optDraw.isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Draw number is not valid");
        }
        return optDraw.get();
    }
}
