interface List<T> {
    public int size();
    public void add(int pos, T data);
    public void add(T data);
    public void set(int pos, T data);
    public T get(int pos);
    public T remove(int pos);
    public T remove();
}
