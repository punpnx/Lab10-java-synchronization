public class Q0ChildThreadDriver{
    public static void main(String[] args) {
        int nThread = 100000; // hundred thousands
        SharedNum1 sn = new SharedNum1();
        Thread[] thr = new Thread[nThread];
        for(int i = 0; i < nThread; i++) {
            thr[i] = new ChildSimple(sn);
            thr[i].start();
        }

        for(int i = 0; i < nThread; i++) {
            try { thr[i].join();
            } catch(InterruptedException ie){ }
        }
        if(sn.getVal() < nThread) {
            System.out.printf("v0 val = %d Not ", sn.getVal());
            System.out.printf("100,000\n");
        } else{
            System.out.printf("v0 good job! %d\n", sn.getVal());
            System.out.printf("\n");
        }
    }
}

class ChildSimple extends Thread {
    SharedNum1 resource;

    ChildSimple(SharedNum1 ref) {
        resource = ref;
    }

    public void run() {
        resource.increment();
    }
}



