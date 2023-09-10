package scriptLib.system.values;

public class values<T> {
    public systemValueType st;
    public userValueType ut;
    public T date;
    public values(systemValueType s,userValueType u,T date){
        this.st = s;
        this.ut = u;
        this.date = date;
    }
}
