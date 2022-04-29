package desktop;

class HittSkill implements ISkill{

    private boolean lock;
    private static final int cooldown = 1;
    private int cooldownFrameCount;
    
    @Override
    public String display() {
        return "HittSkill : useable " + String.valueOf(!this.lock);
    }

    @Override
    public void unlock() {
        this.lock = false;
    }

    @Override
    public void use() {
        if(!this.lock){
            this.lock = true;
            //mache etwas
        }
        else {
            //Fehlermeldung ausgeben
        }
    }

    @Override
    public void update() {
        if(this.lock){
            if(this.cooldownFrameCount>= HittSkill.cooldown){
                this.cooldownFrameCount = 0;
                this.unlock();
            }
            else{
                this.cooldownFrameCount = this.cooldownFrameCount + 1;
            }
        }
    }
    
}
