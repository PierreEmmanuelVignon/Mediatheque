package mediatheque.metier;

public abstract class Transformation<A, B>
{
    public abstract B TransformAtoB(A obj);

    //public abstract A TransformBtoA(B obj);

}
