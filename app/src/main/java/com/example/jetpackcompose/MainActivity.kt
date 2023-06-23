package com.example.jetpackcompose


import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

private val list = listOf(
    YoutubePlaylistsModel(
        image = R.drawable.ic_image_1,
        title = "Emotional Well-being & Healing Practices for Children",
        countOfVideos = "32 video series"
    ),
    YoutubePlaylistsModel(
        image = R.drawable.ic_image_2,
        title = "Self Care Before Child Care",
        countOfVideos = "18 video series"
    ),
    YoutubePlaylistsModel(
        image = R.drawable.ic_image_3,
        title = "Make a Life Changing Difference in a Child’s Life",
        countOfVideos = "12 video series"
    ),
    YoutubePlaylistsModel(
        image = R.drawable.ic_image_4,
        title = "Prevent & Respond to Sexual Abuse",
        countOfVideos = "8 video series"
    ),
    YoutubePlaylistsModel(
        image = R.drawable.ic_image_5,
        title = "Child Protection 101",
        countOfVideos = "15 video series"
    ),
    YoutubePlaylistsModel(
        image = R.drawable.ic_image_6,
        title = "Meet Nutritional Needs ",
        countOfVideos = "11 video series"
    ),
    YoutubePlaylistsModel(
        image = R.drawable.ic_image_6,
        title = "Meet Nutritional Needs ",
        countOfVideos = "11 video series"
    ),
    YoutubePlaylistsModel(
        image = R.drawable.ic_image_6,
        title = "Meet Nutritional Needs ",
        countOfVideos = "11 video series"
    ),
    YoutubePlaylistsModel(
        image = R.drawable.ic_image_6,
        title = "Meet Nutritional Needs ",
        countOfVideos = "11 video series"
    ))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    YoutubeFirstScreen(
                        youtubePlaylists = list
                    )
                }
            }
        }
    }
}

@Composable
private fun YoutubeFirstScreen(youtubePlaylists: List<YoutubePlaylistsModel>) {
    LazyColumn(
        content = {
            itemsIndexed(youtubePlaylists) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    Card {
                        Box(modifier = Modifier.width(120.dp)) {
                            Image(
                                modifier = Modifier.fillMaxWidth(),
                                painter = painterResource(id = item.image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .height(24.dp)
                                    .fillMaxWidth()
                                    .align(alignment = Alignment.BottomCenter)
                            ) {
                               Text(
                                    modifier = Modifier
                                       .fillMaxWidth()
                                       .padding(start = 24.dp),
                                    text = "playlist",
                                    color = Color.WHITE,
                                   textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(
                            text = item.title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                        )
                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            text = item.countOfVideos,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    )


}

data class YoutubePlaylistsModel(
    val image: Int,
    val title: String,
    val countOfVideos: String
)

@Preview(showBackground = true)
@Composable
fun YoutubeFirstScreen_preview() {
    YoutubeFirstScreen(
        youtubePlaylists = list
    )
}
