package my.assignment.lottery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.assignment.lottery.draw.Draw;
import my.assignment.lottery.ticket.Ticket;

@RestController
@RequestMapping(path = "api/v1/lottery", produces="application/json")
public class LotteryController {
    
    private LotteryService service;
    
    @Autowired
    public LotteryController(LotteryService service){
        this.service = service;
    }

	@GetMapping(path ="ticket")
	public List<Ticket> getTickets() {
		return this.service.getTickets();
	}

    @GetMapping(path = "draw")
    public List<Draw> getDraws(){
        return this.service.getDraws();
    }
    @GetMapping(path = "draw/{drawNo}")
    public Draw getDraw(@PathVariable("drawNo") Long drawNo){
        return this.service.getDraw(drawNo);
    }

    @PostMapping(path = "ticket")
    public ResponseEntity<Ticket> createTicket(){
        return new ResponseEntity<Ticket>(this.service.createTicket(), HttpStatus.CREATED);
    }



}

