public class BattleTime {
  private Command fightcommand;
  private Command runcommand;
  private Command catchcommand;

  public BattleTime(Command f, Command r, Command c) {
    this.fightcommand = f;
    this.runcommand = r;
    this.catchcommand = c;
  }

  public void fighting() {
    fightcommand.execute();
  }

  public void catching() {
    catchcommand.execute();
  }
  public void running() {
    runcommand.execute();
  }
}
