public class App {
    private int age;
    private int friends;
    private int moneyPerPresent = 200;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public App(int age, int friends) {
      this.age = age;
      this.friends = friends;
    }

    public int getAge() {
        return age;
    }

    public int getFriends() {
        return friends;
    }
}
