public class FightCommand implements Command {
    private Battle battle;

    public FightCommand(Battle b) {
        this.battle = b;
    }

    public void execute() {
        battle.fight();
    }
}
