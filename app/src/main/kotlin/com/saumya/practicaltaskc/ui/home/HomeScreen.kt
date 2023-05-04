package com.saumya.practicaltaskc.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.saumya.practicaltaskc.data.source.remote.response.random_user.InfoResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.RandomUserResponse
import com.saumya.practicaltaskc.ui.MainViewModel

@Composable
fun HomeRoute(mainViewModel: MainViewModel = viewModel()) {
    val randomUser by mainViewModel.randomUser.subscribeAsState(initial = null)

    HomeScreen(
        randomUserResponse = randomUser,
        onRefresh = mainViewModel::refreshData
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    randomUserResponse: RandomUserResponse? = RandomUserResponse(
        InfoResponse(0, 0, "", ""),
        emptyList()
    ),
    onRefresh: () -> Unit = {},
) {
    if (randomUserResponse != null && randomUserResponse.resultResponses.isNotEmpty()) {
        val randomUser = remember { randomUserResponse.resultResponses[0] }

        Card(modifier = modifier) {
            ConstraintLayout {
                val (imageRef, nameRef, emailRef, refreshButtonRef) = createRefs()

                SubcomposeAsyncImage(
                    model = randomUser.picture.large,
                    contentDescription = randomUser.name.first,
                    modifier = Modifier
                        .constrainAs(imageRef) {
                            start.linkTo(parent.start, margin = 12.dp)
                            top.linkTo(parent.top, margin = 12.dp)
                        }
                        .size(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    loading = { CircularProgressIndicator() }
                )

                Text(
                    text = "${randomUser.name.title} ${randomUser.name.first} ${randomUser.name.last}",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.constrainAs(nameRef) {
                        start.linkTo(imageRef.end, margin = 16.dp)
                        top.linkTo(parent.top, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                        width = Dimension.fillToConstraints
                    }
                )

                Text(
                    text = randomUser.email,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.constrainAs(emailRef) {
                        start.linkTo(imageRef.end, margin = 16.dp)
                        top.linkTo(nameRef.bottom, margin = 6.dp)
                    }
                )

                Button(
                    onClick = onRefresh,
                    modifier = Modifier.constrainAs(refreshButtonRef) {
                        centerHorizontallyTo(parent)
                        top.linkTo(
                            parent.top, margin = 150.dp
                        )
                    }
                ) {
                    Text(text = "Refresh")
                }
            }
        }
    } else {
        Box(modifier = modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        HomeScreen()
    }
}