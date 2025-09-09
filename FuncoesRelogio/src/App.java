public class App {
    public static void main(String[] args) {
        Clock brlclock = new BRClock();
        brlclock.setSecond(00);
        brlclock.setMinute(00);
        brlclock.setHour(14);

        System.out.println(brlclock.getTime());

        System.out.println(new USClock().convert(brlclock).getTime());

    }
}
