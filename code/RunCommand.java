public class RunCommand implements Command {
    private Battle battle;

    public RunCommand(Battle b) {
        this.battle = b;
    }

    public void execute() {
        battle.run();
    }
 }
