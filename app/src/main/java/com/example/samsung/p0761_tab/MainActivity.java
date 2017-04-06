package com.example.samsung.p0761_tab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        //Инициализация
        tabHost.setup();
        TabHost.TabSpec tabSpec;
        //Создание вкладки и указываем tag
        tabSpec = tabHost.newTabSpec(getString(R.string.tag1));
        //Задание названия вкладки
        tabSpec.setIndicator(getString(R.string.vkladka_1));
        //Указание id-компонента из FrameLayout, он и станет содержимым вкладки
        tabSpec.setContent(R.id.tab1);
        //Добавление в корневой элемент
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec(getString(R.string.tag2));
        /**Указание названия и картинки для вкладки. В данном случае вместо картинки
         * xml-файл, который определяет картинку по состоянию вкладки
         */
        tabSpec.setIndicator(getString(R.string.vkladka_2),
                getResources().getDrawable(R.drawable.tab_icon_selector));
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec(getString(R.string.tag3));
        //Создание View из Layout-файла
        View view = getLayoutInflater().inflate(R.layout.tab_header, null);
        //Установка его, как заголовка
        tabSpec.setIndicator(view);
        tabSpec.setContent(R.id.tab3);
        tabHost.addTab(tabSpec);
        //Вторая вкладка будет выбрана по умолчанию
        tabHost.setCurrentTabByTag(getString(R.string.tag2));
        //Обработка переключения вкладок
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(getBaseContext(), "tabId = " + tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
