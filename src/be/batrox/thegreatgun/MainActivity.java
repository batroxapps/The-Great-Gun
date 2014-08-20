package be.batrox.thegreatgun;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

import be.batrox.thegreatgun.game.PlayActivity;
import be.batrox.thegreatgun.game.GameActivity;
import be.batrox.thegreatgun.game.shop.ShopActivity;
import be.batrox.thegreatgun.tutorial.TutorialActivity;
import be.batrox.thegreatgun.options.OptionsActivity;
import be.batrox.thegreatgun.credits.CreditsActivity;

public class MainActivity extends Activity
{
	// all buttons
	private Button btnNew;
	private Button btnContinue;
	private Button btnTutorial;
	private Button btnOptions;
	private Button btnCredits;
	
	private final Class<?>[] classes = {GameActivity.class, 
										ShopActivity.class,
										TutorialActivity.class,
										OptionsActivity.class,
										CreditsActivity.class};
	
	private final int PLAY_ACT = 0;
	private final int SHOP_ACT = 1;
	private final int TUT_ACT = 2;
	private final int OPT_ACT = 3;
	private final int CRED_ACT = 4;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		init();
    }
	
	private void init()
	{
		initializeButtons();
		loadEvents();
		btnNew.setEnabled(false);
	}
	
	private void initializeButtons()
	{
		btnNew = (Button)findViewById(R.id.menu_btn_new);
		btnContinue = (Button)findViewById(R.id.menu_btn_continue);
		btnTutorial = (Button)findViewById(R.id.menu_btn_tutorial);
		btnOptions = (Button)findViewById(R.id.menu_btn_options);
		btnCredits = (Button)findViewById(R.id.menu_btn_credits);
	}
	
	private void loadEvents()
	{
		loadClickOpenEvent(btnNew, PLAY_ACT);
		loadClickOpenEvent(btnContinue, SHOP_ACT);
		loadClickOpenEvent(btnTutorial, TUT_ACT);
		loadClickOpenEvent(btnOptions, OPT_ACT);
		loadClickOpenEvent(btnCredits, CRED_ACT);
	}
	
	private void loadClickOpenEvent(Button b, int pointer)
	{
		final Class<?> c = classes[pointer];
		b.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v)
			{
				openActivity(c);
				System.out.println("hihihi");
			}
		});
		
	}
	
	private void openActivity(Class<?> c)
	{
		Intent intent = new Intent(this, c);
		startActivity(intent);
	}
	
}
