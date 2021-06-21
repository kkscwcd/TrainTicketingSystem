
public class FareCalculator {
    
  
    public static float adultOneWayPrice(int i, int j) {
        float price = 0f;
         // Increase index by 1 because array index start from 0
            i++; 
            j++;

        // Not from airport
        if (i != 9 || j != 9) {
            if (i > j) {
                price = (i - j) * 1.20f;
            } else {
                price = (j - i) * 1.20f;
            }
        } else if (i == 9 || j == 9) {
            //extra fees for airport
            if (i > j) {
                price = ((i - j) * 1.2f) + 15;
            } else {
                price = ((j - i) * 1.2f) + 15;
            }
        }
        return price;
    }

    public static float adultReturnPrice(int i, int j) {
        return adultOneWayPrice(i, j) * 1.8f;
    }

    public static float adultWeeklyPrice(int i, int j) {
        return adultOneWayPrice(i, j) * 6f;
    }
    
    
     public static float adultTicketPrice(int i, int j, String ticketType) {
        if ("One-way".equals(ticketType)) {
            return adultOneWayPrice(i, j);
        } else if ("Return".equals(ticketType)) {
            return adultReturnPrice(i, j);
        } else if ("Weekly".equals(ticketType)) {
            return adultWeeklyPrice(i, j);
        }else{
            return 0f;
        }
    }
    

    public static float childTicketPrice(int i, int j, String ticketType) {
        if ("One-way".equals(ticketType)) {
            return adultOneWayPrice(i, j) * 0.5f;
        } else if ("Return".equals(ticketType)) {
            return adultReturnPrice(i, j) * 0.5f;
        } else if ("Weekly".equals(ticketType)) {
            return adultWeeklyPrice(i, j) * 0.5f;
        }else{
            return 0f;
        }
    }
    
      public static float seniorTicketPrice(int i, int j, String ticketType) {
        if ("One-way".equals(ticketType)) {
            return adultOneWayPrice(i, j) * 0.5f;
        } else if ("Return".equals(ticketType)) {
            return adultReturnPrice(i, j) * 0.5f;
        } else{
            return 0f;
        }
    }

}
