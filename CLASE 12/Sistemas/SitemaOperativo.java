package Sistemas;

public class SitemaOperativo {

    protected String sofware;
    protected int  version;
    

    public SitemaOperativo(String sofware, int version) {
        this.sofware = sofware;
        this.version = version;
        
    }

    public String mostrarInfo() {
        return     "Software: " + sofware + 
                  ", Version: " + version;
    }
}
