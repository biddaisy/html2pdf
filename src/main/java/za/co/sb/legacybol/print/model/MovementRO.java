package za.co.sb.legacybol.print.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovementRO {

  private String details = "BALANCE BROUGHT FORWARD";

  private String serviceFee = "0.00";

  private String debit = "0.00";

  private String credit = "10.00";

  private String date = "20200401";

  private String balance = "100.50";
}
