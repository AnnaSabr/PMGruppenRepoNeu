package desktop;

public class DrinkSkill implements ISkill{

    private ISkillUser user;
    private ISkillResource resource;
    private boolean lock;
    private static final int cooldown = 24;
    private int cooldownFrameCount;

    public DrinkSkill(ISkillUser user, ISkillResource resource){
        this.user = user;
        this.resource = resource;
    }
    
    @Override
    public String display() {
        return "DrinkSkill : useable " + String.valueOf(!this.lock);
    }

    @Override
    public void unlock() {
        this.lock = false;
    }

    @Override
    public void use() {
        if(!this.lock){
            if(this.resource.getResource()){
                this.lock = true;
                //mache etwas
            }
            else{
                //Fehlermeldung
            }
        }
        else {
            //Fehlermeldung ausgeben
        }
    }

    @Override
    public void update() {
        if(this.lock){
            if(this.cooldownFrameCount>= DrinkSkill.cooldown){
                this.cooldownFrameCount = 0;
                this.unlock();
            }
            else{
                this.cooldownFrameCount = this.cooldownFrameCount + 1;
            }
        }
    }
}
