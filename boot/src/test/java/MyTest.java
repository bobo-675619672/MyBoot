import mock.MockTarget;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MyTest {

    /**
     * mock测试
     * when & then
     */
    @Test
    public void testWhenAndThen() {
        MockTarget mock = Mockito.mock(MockTarget.class);
        // 1.定义sayHello()返回
        when(mock.sayHello()).thenReturn("mock");
        assertEquals(mock.sayHello(), "mock");
        // 2.真实调用sayHello()
        doCallRealMethod().when(mock).sayHello();
        assertEquals(mock.sayHello(), "hello");
        // 3.定义sayHello(x)返回真实值(与2效果相同)
        when(mock.sayHello(anyString())).thenAnswer(Answers.CALLS_REAL_METHODS);
        assertEquals(mock.sayHello("mock"), "hello mock");
        // 4.定义callMethod(x)返回
        when(mock.callMethod(any())).thenReturn("mock");
        assertEquals(mock.callMethod(new Object()), "mock");
        // 5.定义抛出异常
        when(mock.callMethodWithException(any())).thenThrow(new RuntimeException("mock runtime exception"), new IllegalArgumentException("mock args exception"));
        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {mock.callMethodWithException("exception 1");}).withMessage("mock runtime exception");
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {mock.callMethodWithException("exception 2");}).withMessage("mock args exception").withNoCause();
        // 6.特定输入指定输出
        doAnswer((Answer<String>) invocation -> {
            Object[] args = invocation.getArguments();
            MockTarget mock1 = (MockTarget) invocation.getMock();
            return "prefix " + args[0];
        }).when(mock).sayHello("mock answer");
        assertEquals(mock.sayHello("mock answer"), "prefix mock answer");
        // 7.不执行doSth()直接抛异常
        doNothing().doThrow(RuntimeException.class).when(mock).doSth();
        mock.doSth();
        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(mock::doSth);
    }

    /**
     * mock测试
     * verify
     */
    @Test
    public void testVerify() {
        // mock creation
        List mockedList = mock(List.class);
        mockedList.clear();
        // only clear() invoked
        verify(mockedList, only()).clear();
        verifyNoMoreInteractions(mockedList);

        // 此处不会抛异常，因为是mock的list对象，非实际list对象
        when(mockedList.get(1)).thenReturn("two");
        assertEquals(mockedList.get(1), "two");

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");

        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList, times(1)).clear();
        verify(mockedList, atLeastOnce()).add("one");
        verify(mockedList, atMostOnce()).add("one");
        verify(mockedList, atMost(1)).add("one");
        verify(mockedList, atLeast(1)).add("one");
        verify(mockedList, never()).add("never");
    }


    @Test
    public void testAfterAndTimeout() throws Exception {
        MockTarget mock = Mockito.mock(MockTarget.class);
        doCallRealMethod().when(mock).callMethodWait(anyLong());

        final long timeout = 500L;
        final long delta = 100L;
        // 异步调用
        CompletableFuture<Void> async = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(timeout);
            } catch (InterruptedException ignored) {
            }
            mock.sayHello();
            mock.callMethod("test");
            mock.callMethod("test");
        });

        // timeout() exits immediately with success when verification passes
        // verify(mock, description("invoke not yet, This will print on failure")).callMethod("test");
        verify(mock, timeout(timeout + delta).times(2)).callMethod("test");
        // immediately success
        verify(mock, timeout(10)).sayHello();
        async.get();

        // after() awaits full duration to check if verification passes
        verify(mock, after(10).times(2)).callMethod("test");
        verify(mock, after(10)).sayHello();
    }


    @Test
    public void testDoReturn() {
        // real creation
        List list = new LinkedList();
        List spy = spy(list);

        //optionally, you can stub out some methods:
        int mockSize = 100;
        when(spy.size()).thenReturn(mockSize);
        //size() method was stubbed - 100 is printed
        assertEquals(spy.size(), mockSize);

        // Overriding a previous exception-stubbing:
        when(spy.size()).thenThrow(new IllegalStateException("not init"));
        doReturn(mockSize).when(spy).size();
        assertEquals(spy.size(), mockSize);
        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> spy.get(0));
        doReturn("mock data").when(spy).get(1);

        //using the spy calls real methods
        spy.add("one");
        assertEquals(spy.get(0), "one");

        /*
        Use this method in order to only clear invocations, when stubbing is non-trivial. Use-cases can be:
        You are using a dependency injection framework to inject your mocks.
        The mock is used in a stateful scenario. For example a class is Singleton which depends on your mock.
        Try to avoid this method at all costs. Only clear invocations if you are unable to efficiently test your program.
         */
        clearInvocations(spy);
        verify(spy, times(0)).add("two");
        reset(spy);
        when(spy.size()).thenReturn(0);
        assertEquals(spy.size(), 0);
    }

}
