package desktop;

public class DrinkSkill implements ISkill{

    private ISkillUser user;
    public DrinkSkill(ISkillUser user){
        this.user = user;
    }
    
    @Override
    public String display() {
        return "DrinkSkill";
    }

    @Override
    public void unlock() {
        
    }

    @Override
    public void use() {
        
    }

    @Override
    public void update() {
        
    }
}
