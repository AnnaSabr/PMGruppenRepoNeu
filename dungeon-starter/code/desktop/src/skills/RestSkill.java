package desktop;

class RestSkill implements ISkill{

    private boolean lock;
    private static final int cooldown = 80;
    private int cooldownFrameCount;

    public RestSkill(){
        this.lock = false;
        this.cooldownFrameCount = 0;
    }

    @Override
    public String display() {
        return "Rest : useable " + String.valueOf(!this.lock);
        
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
            if(this.cooldownFrameCount>= RestSkill.cooldown){
                this.cooldownFrameCount = 0;
                this.unlock();
            }
            else{
                this.cooldownFrameCount = this.cooldownFrameCount + 1;
            }
        }     
    }  
}
