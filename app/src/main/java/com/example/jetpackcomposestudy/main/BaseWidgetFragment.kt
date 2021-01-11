package com.example.jetpackcomposestudy.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.jetpackcomposestudy.*
import com.example.jetpackcomposestudy.R
import com.example.jetpackcomposestudy.bean.ItemBean
import com.example.jetpackcomposestudy.demo.CheckBoxActivity
import com.example.jetpackcomposestudy.demo.DialogDemoActivity
import com.example.jetpackcomposestudy.demo.LifeCycleDemoActivity
import com.example.jetpackcomposestudy.list.ListTestActivity
import com.example.jetpackcomposestudy.login.LoginActivity

class BaseWidgetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                StudyList(
                    studyList = arrayListOf(
                        ItemBean(
                            "",
                            "Text",
                            "text使用详解"
                        ),
                        ItemBean(
                            "",
                            "Button",
                            "Button使用详解"
                        ),
                        ItemBean(
                            "",
                            "Image",
                            "Image使用详解"
                        ),
                        ItemBean(
                            "",
                            "Raw",
                            "Raw使用详解"
                        ),
                        ItemBean(
                            "",
                            "Column",
                            "Column使用详解"
                        ),
                        ItemBean(
                            "",
                            "Box",
                            "Box使用详解"
                        ),
                        ItemBean(
                            "",
                            "recyclerView",
                            "Jetpack Compose RecyclerView使用详解"
                        ),

                        ItemBean(
                            "",
                            "动态列表",
                            "数据和状态绑定实例"
                        ),

                        ItemBean(
                            "",
                            "dialog",
                            "dialog使用"
                        )


                    )
                )
            }
        }
    }

    @Composable
    fun StudyList(studyList: MutableList<ItemBean>) {
        /**
         * 可滚动的垂直布局
         */
        ScrollableColumn(modifier = Modifier) {
            val context = ContextAmbient.current
            studyList.forEachIndexed { index, item ->
                StudyCardItem(itemBean = item, onClick = {
                    when (index) {
                        0 -> {
                            val intent = Intent(context, LifeCycleDemoActivity::class.java)
                            context.startActivity(intent)
                        }
                        1 -> {
                            val intent = Intent(context, LoginActivity::class.java)
                            context.startActivity(intent)
                        }
                        2 -> {
                            val intent = Intent(context, ImagesActivity::class.java)
                            context.startActivity(intent)
                        }
                        3 -> {
                            val intent = Intent(context, CheckBoxActivity::class.java)
                            context.startActivity(intent)
                        }
                        6 -> {
                            val intent = Intent(context, RecyclerViewActivity::class.java)
                            context.startActivity(intent)
                        }

                        7 -> {
                            val intent = Intent(context, ListTestActivity::class.java)
                            context.startActivity(intent)
                        }

                        8 -> {
                            val intent = Intent(context, DialogDemoActivity::class.java)
                            context.startActivity(intent)
                        }
                        else -> {
                            Toast.makeText(context, "${item.content}", Toast.LENGTH_SHORT).show()
                        }
                    }

                })
            }
        }
    }

    @Composable
    fun StudyCardItem(itemBean: ItemBean, onClick: () -> Unit) {
        Box(
            modifier = Modifier.clickable(onClick = onClick).padding(16.dp, 8.dp, 16.dp, 8.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(colorResource(id = R.color.color_card3))
                .fillMaxWidth()
        ) {
            Image(
                asset = imageResource(R.drawable.avatar),
                modifier = Modifier.width(100.dp).height(100.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )


            Column(modifier = Modifier.padding(start = 116.dp).align(Alignment.CenterStart)) {
                Text(
                    text = itemBean.title,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 18.sp,
                )

                Text(
                    text = itemBean.content,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

        }
    }

}