package amazonia.packages;

import java.time.LocalDate;

public enum DateManager {
   Instance;
   private LocalDate fixed = null;
   
   /**
     Get current LocalDate, or a fixed one if it exists 
   */
   public LocalDate now() {
     if (fixed==null) return LocalDate.now();
     else return fixed;
   }

   /** 
     Set current Date (chage to public if testing from different package)
   */
   void fixDate(LocalDate fixed){
     this.fixed = fixed;
   }

   /**
      Add a number of days to the fixed LocalDate
   */
   void plusDays(long daysToAdd) {
	   fixDate(now().plusDays(daysToAdd));
   }
}