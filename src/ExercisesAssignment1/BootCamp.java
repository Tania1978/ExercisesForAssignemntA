
package ExercisesAssignment1;

import static ExercisesAssignment1.BootCampProgram.formatDate;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

public class BootCamp {

    private String name;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private static int count;
    private Period period;

    public BootCamp() {
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public static int getCount() {
        return count;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public static void printBootCamp(BootCamp bootcamp) {
        LocalDate sd = bootcamp.getStartingDate();
        LocalDate ed = bootcamp.getEndingDate();
        DayOfWeek ds = sd.getDayOfWeek();
        DayOfWeek de = ed.getDayOfWeek();
        String dateSt = ds + " " + sd.format(formatDate);
        String dateEnd = de + " " + ed.format(formatDate);
        Period period = Period.between(sd, ed);
        bootcamp.setPeriod(period);
        System.out.println("BootCamp " + bootcamp.getName() + ":  From  " + dateSt + " to " + dateEnd + " Duration: " + period.getYears()
                + " years," + period.getMonths() + " months," + period.getDays() + " days");
    }
}
