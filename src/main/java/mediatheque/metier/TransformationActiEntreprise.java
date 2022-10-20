package mediatheque.metier;

public class TransformationActiEntreprise extends Transformation<Actif, Entreprise>
{

    @Override
    public Entreprise TransformAtoB(Actif obj) {
        return obj.getEmployeur();
    }
}
