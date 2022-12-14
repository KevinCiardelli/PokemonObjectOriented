public class CatchCommand implements Command {
    private Battle battle;

    public CatchCommand(Battle b) {
        this.battle = b;
    }

    public void execute() {
        battle.catching();
    }
}
