package com.example.jetpackcomposestudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
                            "知识点1",
                            "知识点2",
                            "知识点3",
                            "知识点4",
                            "知识点5",
                            "知识点6",
                            "知识点7",
                            "知识点8",
                            "知识点9",
                            "知识点10",
                            "知识点11",
                            "知识点12",
                            "知识点13",
                            "知识点14",
                            "知识点15",
                            "知识点16",
                            "知识点17",
                            "知识点18",
                            "知识点19",
                            "知识点20",
                            "知识点21",
                            "知识点22",
                            "知识点23",
                            "知识点24",
                            "知识点25",
                            "知识点26",
                            "知识点27",
                            "知识点28"
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
fun StudyList(studyList: MutableList<String>) {
    /**
     * 可滚动的垂直布局
     */
    ScrollableColumn() {
        studyList.forEach {
            StudyCardItem(bgUrl = "", title = it, onClick = {})
        }
    }
}

@Composable
fun StudyCardItem(bgUrl: String, title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier.clickable(onClick = onClick).padding(16.dp, 8.dp, 16.dp, 8.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(colorResource(id = R.color.lightcoral))
    ) {
        //暂时支持网络布片加载
//        Image(
//            asset = imageResource(R.drawable.study_item_bg),
//            modifier = Modifier.fillMaxWidth().height(100.dp),
//            alignment = Alignment.Center,
//            contentScale = ContentScale.Crop
//        )

        Text(
            text = title,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
            fontSize = 16.sp,
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth().align(Alignment.Center)
        )
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
                    "知识点1",
                    "知识点2",
                    "知识点3",
                    "知识点4",
                    "知识点5",
                    "知识点6",
                    "知识点7",
                    "知识点8",
                    "知识点9",
                    "知识点10",
                    "知识点11",
                    "知识点12",
                    "知识点13",
                    "知识点14",
                    "知识点15",
                    "知识点16",
                    "知识点17",
                    "知识点18",
                    "知识点19",
                    "知识点20",
                )
            )
        }
    }
}