package za.co.sb.legacybol.print.model;

import java.util.List;

import lombok.Data;

@Data
public class DataRO {

  private AccountRO account;

  private List<MovementRO> movements;
}
