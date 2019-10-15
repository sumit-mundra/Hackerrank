import java.util.ArrayList;
import java.util.List;

interface Function {
    void apply();
}

public class GoogleTest {

    static Function rateLimit(Function myFunc, int ms, int k) {
        return new MyFunction(myFunc, ms, k);
    }


    public static void main(String[] args) {
        Function myfunc = null;
        Function rlFunc = rateLimit(myfunc, 500, 5);
        rlFunc.apply();
        rlFunc.apply();
    }

}

class MyFunction implements Function {
    private long timeout;
    private Function myFunc;
    private int repTimes;

    private int count;

    private List<Long> execTimes = new ArrayList<>();

    MyFunction(Function func, long timeout, int repTimes) {
        this.timeout = timeout;
        this.myFunc = func;
        this.repTimes = repTimes;
    }

    private void updateExecTimes() {
        List<Long> temp = new ArrayList<>();
        long current = System.currentTimeMillis();
        for (long execTime : execTimes) {
            if (current - execTime < timeout) {
                temp.add(execTime);
            }
        }
        this.count = temp.size();
        this.execTimes = temp;
    }

    @Override
    public void apply() {
        if (count == 0) {
            execTimes.add(System.currentTimeMillis());
            count++;
            myFunc.apply();
            return;
        }

        long currentTime = System.currentTimeMillis();

        if (currentTime - execTimes.get(0) >= timeout) {
            updateExecTimes();
        }
        if (currentTime - execTimes.get(0) < timeout) {
            if (count < repTimes) {
                count++;
                execTimes.add(currentTime);
                myFunc.apply();
            }
        }
    }
}
