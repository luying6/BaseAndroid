package debug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tapas.login.R;

/**
 * 创建人：luying
 * 创建时间：2018/1/2
 * 类说明：
 */

public class LoginDebugActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        Toast.makeText(this, "测试", Toast.LENGTH_LONG).show();
    }
}
