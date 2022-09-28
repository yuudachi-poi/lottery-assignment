package my.assignment.lottery.draw;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DrawRepository
 */
@Repository
public interface DrawRepository extends JpaRepository<Draw, Long>{

}