class Test{
    public static void main (String[]args){
        Computer pc=ComputerFactory.buildComputer("mobil","viel Wumms");
        System.out.println("Kerne:"+ pc.getCpu().getCores()+",  GHZ:"+pc.getCpu().getFrequency()+"\nFestplattenspeicher: "+pc.getDrive().getStorageSize()+",  FestplattenArt: "+pc.getDrive().getClass().getSimpleName()+" \nRAM-Groesse: "+pc.getRam().getSize()+" \nPC-Art: "+pc.getClass().getSimpleName());
        Computer pc2=ComputerFactory.buildComputer("blah","viel Wumms");
    }

}
