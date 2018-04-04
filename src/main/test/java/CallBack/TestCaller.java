package CallBack;

import org.junit.Test;

public class TestCaller {
    @Test
    public void test(){
        final Button button = new Button("test");
        button.OnClick(new OnClickListener() {
            public void clickCallBack(String button_name) {
                System.out.println("In callBackMethod:"+button_name+" is on click");
            }
        });
    }
}
