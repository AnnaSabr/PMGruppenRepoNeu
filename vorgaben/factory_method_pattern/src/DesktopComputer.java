public class DesktopComputer implements Computer {
    private Ram ram;
    private Drive drive;
    private Cpu cpu;

    public DesktopComputer(Ram ram, Drive drive, Cpu cpu) {
        this.ram = ram;
        this.drive = drive;
        this.cpu = cpu;
    }

    public Ram getRam() {
        return this.ram;
    }

    public Drive getDrive() {
        return this.drive;
    }

    public Cpu getCpu() {
        return this.cpu;
    }

    public boolean equals(Computer c) {
        if(c != null){
            return this.getRam().getSize() == c.getRam().getSize() &&
                   this.getDrive().getStorageSize() == c.getDrive().getStorageSize() &&
                   this.getCpu().getCores() == c.getCpu().getCores() &&
                   this.getCpu().getFrequency() == c.getCpu().getFrequency();

        }
        else {
            return false;
        }
    }
}
