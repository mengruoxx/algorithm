package concurrent;

import java.lang.ref.SoftReference;

public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        /**
         * 软引用 m -> SR ---> 字节数组    m指向SR这是一个强引用，SR指向一个字节数组这一段才是软引用
          */
        SoftReference<byte[]> m = new SoftReference<byte[]>(new byte[1024*1024*10]);


        /**
         * 将threadLocal对象设为key，将自己缓存的对象设为值
         */
        threadLocal.set("my");

        String value = threadLocal.get();
    }
}
