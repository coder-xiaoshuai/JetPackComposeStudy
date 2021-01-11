package com.example.jetpackcomposestudy.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabConstants
import androidx.compose.material.TabConstants.defaultTabIndicatorOffset
import androidx.compose.material.TabRow
import androidx.compose.runtime.*
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.jetpackcomposestudy.R
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private var baseInfoFragment by Delegates.notNull<BaseInfoFragment>()
    private var baseWidgetFragment by Delegates.notNull<BaseWidgetFragment>()
    private var baseThemeFragment by Delegates.notNull<BaseThemeFragment>()
    private var fragmentList by Delegates.notNull<List<Fragment>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        baseInfoFragment = BaseInfoFragment()
        baseWidgetFragment = BaseWidgetFragment()
        baseThemeFragment = BaseThemeFragment()
        fragmentList = listOf(baseInfoFragment, baseWidgetFragment, baseThemeFragment)

        findViewById<ComposeView>(R.id.tab_title_container).setContent {
            Column(modifier = Modifier.fillMaxWidth()) {
                MainTitle(title = "Jetpack Compose Study")
                MainTopTab()

                //willl be called the first time a compose function is applied.
                onActive(callback = { /*TODO*/ })

                //will be called when the compose function isn’t part of the composition anymore.
                onDispose(callback = { /*TODO*/ })
            }
        }
        showTargetFragment(baseInfoFragment)
    }

    @Composable
    fun MainTitle(title: String) {
        Text(
            text = title,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            fontSize = 18.sp,
            modifier = Modifier.background(colorResource(id = R.color.purple_700)).padding(16.dp)
                .fillMaxWidth()
        )
    }

    @Composable
    fun MainTopTab() {
        var selectPosition by savedInstanceState { 0 }
        TabRow(
            selectedTabIndex = selectPosition,
            backgroundColor = colorResource(id = R.color.color_chart_red),
            modifier = Modifier.fillMaxWidth().height(48.dp),
            indicator = { tabPositions ->
                TabConstants.DefaultIndicator(
                    color = colorResource(id = R.color.color_card4),
                    height = 3.dp,
                    modifier = Modifier.defaultTabIndicatorOffset(tabPositions[selectPosition])
                )
            }
        ) {
            Tab(
                selected = 0 == selectPosition,
                onClick = {
                    selectPosition = 0
                    showTargetFragment(baseInfoFragment)
                },
                selectedContentColor = colorResource(id = R.color.white),
                unselectedContentColor = colorResource(id = R.color.color_card11)
            ) {

                Text(
                    text = "基础介绍",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp, bottom = 8.dp)
                )

            }

            Tab(
                selected = 1 == selectPosition,
                onClick = {
                    selectPosition = 1
                    showTargetFragment(baseWidgetFragment)
                },
                selectedContentColor = colorResource(id = R.color.white),
                unselectedContentColor = colorResource(id = R.color.color_card11)
            ) {

                Text(
                    text = "常用widget",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp, bottom = 8.dp)
                )

            }

            Tab(
                selected = 2 == selectPosition,
                onClick = {
                    selectPosition = 2
                    showTargetFragment(baseThemeFragment)
                },
                selectedContentColor = colorResource(id = R.color.white),
                unselectedContentColor = colorResource(id = R.color.color_card11)
            ) {

                Text(
                    text = "主题背景",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp, bottom = 8.dp)
                )

            }

        }
    }


    private fun showTargetFragment(targetFragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        fragmentList.forEach {
            if (!it.isAdded) {
                transaction.add(R.id.fragment_container, it)
            }
            transaction.hide(it)
        }
        transaction.show(targetFragment).commit()
    }
}