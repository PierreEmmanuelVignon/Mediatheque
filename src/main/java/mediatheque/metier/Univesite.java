package mediatheque.metier;

public class Univesite
{
    private String nomUniversite;

    public Univesite(String nomU)
    {
        this.nomUniversite = nomU;
    }

    public String getNomUniversite() {
        return nomUniversite;
    }

    public void setNomUniversite(String nomUniversite) {
        this.nomUniversite = nomUniversite;
    }

    @Override
    public String toString() {
        return getNomUniversite();
    }
}
