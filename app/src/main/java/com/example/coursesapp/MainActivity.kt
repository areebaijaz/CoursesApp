package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursesapp.ui.theme.CoursesAppTheme
import com.example.grids.DataSource
import com.example.grids.DataSource.topics
import com.example.grids.Grid

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesAppTheme {
                    GridApp()

            }
        }
    }
}
@Composable
fun GridApp() {
val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier =  Modifier.statusBarsPadding().padding(
            start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(
                layoutDirection
            ),
            end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(
                layoutDirection
            ),
        ).fillMaxSize()
    ) {
       GridLayout()
    }
}
@Composable
fun GridLayout(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
       columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 7.dp,
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        content = {
            items(topics) {  grid  ->
                GridItems(
                    grid = grid,
                    modifier = Modifier.padding(7.dp)
                )

        }
        }
    )
}
@Composable
fun GridItems(grid: Grid, modifier: Modifier = Modifier) {
   Card ( modifier = modifier) {
     Row(modifier = Modifier.width(200.dp)) {
Image(
    painter = painterResource(grid.imageresourceId),
    contentDescription = stringResource(grid.stringresourceId),
    modifier = Modifier.height(110.dp).width(80.dp),
    contentScale = ContentScale.Crop,
)
         Column {
             Text(
                 text = LocalContext.current.getString(grid.stringresourceId),
                 modifier = Modifier.padding(top = 16.dp, bottom = 8.dp,start = 16.dp,
                     end = 16.dp),
                 textAlign = TextAlign.Justify,
                 fontWeight = FontWeight.Bold,
                 fontSize = 20.sp
             )
             Row(modifier) {
                 Icon(
                    painter = painterResource(R.drawable.baseline_blur_on_24),
                     contentDescription = "Menu",
                     modifier = Modifier.padding(start = 16.dp,end  = 8.dp,
                         top = 8.dp),
                 )
                 Text(
                   text = grid.lessonsId.toString(),
                     modifier = Modifier.padding( top = 8.dp),
                     fontSize = 16.sp
                 )
             }
         }
     }
   }
}

@Preview(showBackground = true)
@Composable
private fun GridCardsPreview() {
    CoursesAppTheme {
        GridItems(Grid(R.string.law, lessonsId = 58, R.drawable.law))
    }
}