package scriptLib.system.values;

public class values<T> {
    systemValueType st;
    userValueType ut;
    public T date;
    public values(systemValueType s,userValueType u,T date){
        this.st = s;
        this.ut = u;
        this.date = date;
    }
}
