package di;

public class B {
    boolean condition;

    public B(boolean condition)
    {
        this.condition = condition;
    }

    public int calc()
    {
        if(condition) return 1;
        return 0;
    }

}
