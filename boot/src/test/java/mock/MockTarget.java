package mock;

import java.util.concurrent.TimeUnit;

public class MockTarget {

    public void doSth() {
        System.out.println("do sth.");
    }

    public String sayHello() {
        return "hello";
    }

    public String sayHello(String greetings) {
        return "hello " + greetings;
    }

    public String callMethod(Object p) {
        return "callMethod " + p.toString();
    }

    public String callMethodWait(long million) {
        try {
            TimeUnit.MILLISECONDS.sleep(million);
        } catch (InterruptedException ignored) {
        }
        return "callMethod sleep " + million;
    }

    public Object callMethodWithException(Object p) {
        throw new IllegalStateException("测试异常");
    }

}
