package Assignment_3.HashTable;

class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + id;
        for (int i = 0; i < name.length(); i++) {
            hash = hash * 31 + name.charAt(i);
        }
        return (hash);
    }



    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + ", name='" + name + "'}";
    }
}