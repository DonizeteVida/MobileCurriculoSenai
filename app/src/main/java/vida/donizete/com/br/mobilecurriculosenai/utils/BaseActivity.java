package vida.donizete.com.br.mobilecurriculosenai.utils;

import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vida.donizete.com.br.mobilecurriculosenai.R;
import vida.donizete.com.br.mobilecurriculosenai.service.UsuarioService;

public class BaseActivity extends AppCompatActivity {

    public static Retrofit retrofit;

    protected void setUpToolbar() {
        Toolbar t = (Toolbar) findViewById(R.id.include_toolbar);

        if (t != null) {
            setSupportActionBar(t);
        }
    }

    protected static Retrofit retrofitGetInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(UsuarioService.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    protected void setUpMenu() {
        ActionBar bar = getSupportActionBar();

        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
            bar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void longMens(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    public void shortMens(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void longMensSnack(String s) {
        Snackbar.make(findViewById(android.R.id.content), s, Snackbar.LENGTH_LONG).show();
    }

    public void shortMensSnack(String s) {
        Snackbar.make(findViewById(android.R.id.content), s, Snackbar.LENGTH_SHORT).show();
    }
}
