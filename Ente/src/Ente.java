public class Ente
{
    private IQuackVerhalten quackVerhalten;
    private FlugVerhalten flugVerhalten;

    public Ente (IQuackVerhalten qv, FlugVerhalten fv)
    {
        this.quackVerhalten = qv;
        this.flugVerhalten = fv;
    }

    public FlugVerhalten getFlugVerhalten() {
        return flugVerhalten;
    }

    public void setFlugVerhalten(FlugVerhalten flugVerhalten) {
        this.flugVerhalten = flugVerhalten;
    }

    public IQuackVerhalten getQuackVerhalten() {
        return quackVerhalten;
    }

    public void setQuackVerhalten(IQuackVerhalten quackVerhalten) {
        this.quackVerhalten = quackVerhalten;
    }

    public void fliegen()
    {
        flugVerhalten.fliegen();
    }

    public void quacken()
    {
        quackVerhalten.quacken();
    }
}
