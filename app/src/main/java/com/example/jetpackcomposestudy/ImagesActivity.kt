package com.example.jetpackcomposestudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                imageUseExamples()
            }
        }
    }

    /**
     * Image使用示例
     */
    @Composable
    fun imageUseExamples() {
        Column() {
            Image(asset = imageResource(R.drawable.avatar), contentScale = ContentScale.Crop)
            Image(
                asset = imageResource(R.drawable.avatar),
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(100.dp).height(100.dp)
            )
            Image(
                asset = imageResource(R.drawable.avatar),
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(100.dp).height(100.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .border(
                        border = BorderStroke(2.dp, Color.Blue),
                        shape = RoundedCornerShape(50.dp)
                    )

            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            imageUseExamples()
        }
    }


}