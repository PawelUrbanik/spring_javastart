package pl.javastart.springjtaoto.dao;

public interface UserDao <K,T>{

    public void save(T obj);
    public T get(K id);
    public void update(T obj);
    public void delete(K id);

}
