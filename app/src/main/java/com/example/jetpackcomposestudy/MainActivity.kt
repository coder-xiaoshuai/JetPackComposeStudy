package com.example.jetpackcomposestudy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.jetpackcomposestudy.ui.JetPackComposeStudyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetPackComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Column {
                    Title(title = "JetPack Compose Study")

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
                            )
                        )
                    )
                }

            }
        }
    }
}

@Composable
fun Title(title: String) {
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
fun StudyList(studyList: MutableList<ItemBean>) {
    /**
     * 可滚动的垂直布局
     */
    ScrollableColumn(modifier = Modifier) {
        val context = ContextAmbient.current
        studyList.forEachIndexed { index, item ->
            StudyCardItem(itemBean = item, onClick = {
                when (index) {
                    1 -> {
                        val intent = Intent(context, LoginActivity::class.java)
                        context.startActivity(intent)
                    }
                    6 -> {
                        val intent = Intent(context, RecyclerViewActivity::class.java)
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
            .background(colorResource(id = R.color.lightcoral))
            .fillMaxWidth()
    ) {
        //暂时支持网络布片加载
//        Image(
//            asset = imageResource(R.drawable.study_item_bg),
//            modifier = Modifier.fillMaxWidth().height(100.dp),
//            alignment = Alignment.Center,
//            contentScale = ContentScale.Crop
//        )

        Image(
            asset = imageResource(R.drawable.avatar),
            modifier = Modifier.width(100.dp).height(100.dp).clip(shape = RoundedCornerShape(8.dp))
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeStudyTheme {
        Column() {
            Title(title = "JetPack Compose Study")
            StudyList(
                studyList = arrayListOf(
                    ItemBean(
                        "",
                        "recyclerView",
                        "Jetpack Compose RecyclerView使用详解"
                    )
                )
            )
        }
    }
}