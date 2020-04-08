package za.co.sb.legacybol.print;

import java.util.Arrays;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import za.co.sb.legacybol.print.model.AccountRO;
import za.co.sb.legacybol.print.model.DataRO;
import za.co.sb.legacybol.print.model.MovementRO;

public class DataProvider {

  MovementRO[] TEST = Arrays.asList(new MovementRO("BALANCE BROUGHT FORWARD", "0.00", "0.00", "0.00", "20200301", "20,352.89"),
      new MovementRO("ELECTRONIC BANKING PAYMENT TO WAGES - M WORKER MARCH 2020", "0.00", "-1,65.00", "0.00", "20200301", "18,702.89"),
      new MovementRO("ACCOUNT PAYMENY SECURITY COMPANY", "0.00", "-421.00", "0.00", "20200304", "18,281.89"),
      new MovementRO("ELECTRONIC BANKING PAYMENT TO XYZ PTY LTD", "0.00", "-6,174.00", "0.00", "20200313", "12,107,89"),
      new MovementRO("IB PAYMENT FFROM JARED MURPHY SUBS", "0.00", "0.00", "500.00", "20200315", "12,607.89")).toArray(new MovementRO[5]);

  @Produces
  @ApplicationScoped
  public DataRO createTestData() {

    Random random = new Random(42L);

    DataRO data = new DataRO();

    AccountRO account = new AccountRO();
    data.setAccount(account);

    MovementRO[] movements = new MovementRO[500];
    for (int i = 0; i < movements.length; i++) {
      movements[i] = TEST[random.nextInt(5)];
    }
    data.setMovements(Arrays.asList(movements));

    return data;
  }

}
