package com.example.voldemarius.hereandnow.activitys;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.voldemarius.hereandnow.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.util.VKUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    //Views
    private Button loginBtn;
    private Button fbBtn;
    private Button vkBtn;
    private EditText email;
    private EditText password;
    private TextView signUp;
    private ImageView imageView;
    //FB
    private CallbackManager callbackManager;
    //
    private Boolean emailState;
    private Boolean passwordState;

    private String[] Scope = new String[]{VKScope.FRIENDS, VKScope.WALL, VKScope.PHOTOS};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        implementViews();
        setUpFonts();
        manualLogin();

        Glide
                .with(getApplicationContext())
                .load(R.drawable.picture1)
                .centerCrop()
                .into(imageView);


        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFbLogin();
            }
        });
        vkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onVkLogin();
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"This feature isn't available yet",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void onVkLogin() {

    }

    private Boolean isEmpty(EditText editText)//Проверка пустое ли поле в EditText
    {
        return editText.getText().toString().trim().length() != 0;
    }
    private void manualLogin()//Кнопка логин теряет свойства, если пользователь не ввёл ничего
    {
        loginBtn.setAlpha(0.5f);
        final Intent intent=new Intent(this,MainActivity.class);
        TextWatcher tw=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (isEmpty(email)&&isEmpty(password)) {
                    loginBtn.setAlpha(1f);
                    loginBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(intent);
                        }
                    });
                }
                else {
                    loginBtn.setAlpha(0.5f);
                    loginBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (isEmpty(email)&&isEmpty(password)) {
                    loginBtn.setAlpha(1f);
                    loginBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(intent);
                        }
                    });
                }
                else {
                    loginBtn.setAlpha(0.5f);
                    loginBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (isEmpty(email)&&isEmpty(password)) {
                    loginBtn.setAlpha(1f);
                    loginBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(intent);
                        }
                    });
                }
                else {
                    loginBtn.setAlpha(0.5f);
                    loginBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                }
            }
        };
        email.addTextChangedListener(tw);
        password.addTextChangedListener(tw);
    }

    private void onFbLogin() { //Инициализация входа через FB
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager=CallbackManager.Factory.create();
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email","user_photos","user_friends","public_profile"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject json, GraphResponse response) {
                        if (response.getError()!=null)
                        {
                            Log.e("LR","Error in onCompleted");
                        }
                        else {
                            Log.e("LR","Success in onCompleted");
                            try {
                                String jsonresult = String.valueOf(json);
                                System.out.println("JSON Result" + jsonresult);

                                String str_email = json.getString("email");
                                String str_id = json.getString("id");
                                String str_firstname = json.getString("first_name");
                                String str_lastname = json.getString("last_name");
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).executeAsync();//Выпонялется асинхронно
            }

            @Override
            public void onCancel() {
                Log.d("CANCEL","onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("ERROR",error.toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
        final Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);


    }


    private void setUpFonts() { //Шрифты
        Typeface ptSansBold=Typeface.createFromAsset(getAssets(),"fonts/PT_SansBold.ttf");
        Typeface ptSansRegular=Typeface.createFromAsset(getAssets(),"fonts/PT_SansRegular.ttf");
        Typeface latoBold=Typeface.createFromAsset(getAssets(),"fonts/Lato-Bold.ttf");
        Typeface latoRegular=Typeface.createFromAsset(getAssets(),"fonts/Lato-Regular.ttf");

        TextView signUpText=(TextView)findViewById(R.id.signIn);
        signUpText.setTypeface(latoBold);
        TextView cozyText=(TextView)findViewById(R.id.cozy);
        cozyText.setTypeface(ptSansRegular);
        loginBtn.setTypeface(ptSansBold);
        fbBtn.setTypeface(ptSansRegular);
        vkBtn.setTypeface(ptSansRegular);
        TextView orText=(TextView)findViewById(R.id.textOr);
        orText.setTypeface(latoRegular);
        TextView dontAcc=(TextView)findViewById(R.id.withoutAccount);
        dontAcc.setTypeface(latoRegular);
        signUp.setTypeface(latoBold);
        email.setTypeface(ptSansRegular);
        password.setTypeface(ptSansRegular);

    }

    private void implementViews() {
        loginBtn=(Button)findViewById(R.id.loginBtn);
        fbBtn=(Button)findViewById(R.id.fbBtn);
        vkBtn=(Button)findViewById(R.id.vkBtn);
        email=(EditText)findViewById(R.id.editEmail);
        password=(EditText)findViewById(R.id.editPassword);
        signUp=(TextView)findViewById(R.id.signUpText);
        imageView=(ImageView)findViewById(R.id.image);
    }
}