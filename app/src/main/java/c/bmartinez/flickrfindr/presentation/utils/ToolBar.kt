package c.bmartinez.flickrfindr.presentation.utils

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import c.bmartinez.flickrfindr.presentation.main_screen.MainViewModel

@Composable
fun ToolBar(
    focusManager: FocusManager,
    viewModel: MainViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
        ,
        color = Color.White,
        elevation = 15.dp,
    ){
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                val query = viewModel.queryTerm
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(.9f)
                        .padding(8.dp)
                    ,
                    value = query.value,
                    onValueChange = { newValue ->
                        viewModel.onQueryTermChange(newValue)
                    },
                    label = {
                        Text(text = "Search")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = null)
                    },
                    trailingIcon = {
                        if (query.value != TextFieldValue("").text) {
                            IconButton(
                                onClick = {
                                    viewModel.onQueryTermClear()
                                }
                            ) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(15.dp)
                                        .size(24.dp)
                                )
                            }
                        }
                    },
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            focusManager.clearFocus(true)
                            viewModel.getPhotos(query.value)
                        }
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        cursorColor = Color.Black,

                        ),
                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface)
                )
            }
        }
    }
}