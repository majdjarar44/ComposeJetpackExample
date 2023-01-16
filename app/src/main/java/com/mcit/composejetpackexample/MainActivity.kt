package com.mcit.composejetpackexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // Extention function

//            Column(
//                modifier = Modifier.fillMaxSize(),//linear layout // vertical
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                TextViewEx(text = my_text.value)
//                MyTextField()
//                MyOutlined()
//                MyBottom()
//                MyGroupRadioButton()
//                MyFloatingActionButton()
//                progressIndicator()
//                showAlertDialog()
//                row()
//                Row(
//                    Modifier
//                        .background(Color.Red)
//                        .width(300.dp)
//                        .height(300.dp),
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    row()
//                }
//            }
//                Column(
//                    modifier = Modifier
//                        .width(200.dp)
//                        .height(200.dp),
//                    verticalArrangement = Arrangement.SpaceEvenly,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    verticalColumn()
//                }


//                MyBox(modifier = Modifier
//                    .width(200.dp)
//                    .height(200.dp)
//                    .background(Color.Cyan),
//                    contentModifier= Modifier
//                        .background(Color.White)
//                        .padding(10.dp))
//                Box(modifier = Modifier.fillMaxSize()) {
//                    surface(modifier = Modifier.align(Alignment.Center))
//                }
//            Scaffold()
//            }
            columnItems()
        }
    }

}

//@Preview
@Composable
fun TextViewEx(text: String) {
    Text(text = text, color = Color.Cyan)
}

//@Preview
@Composable
fun MyTextField() {
    val textFieldValue = remember {
        mutableStateOf("") // for accept new value is mutable for builder string
    }

    TextField(value = textFieldValue.value, onValueChange = {
        textFieldValue.value = it  // for get new char and build string or words
    }, label = {
        Text(text = "This is Field")
    })
}

//@Preview
@Composable
fun MyOutlined() {
    val textFieldValue = remember {
        mutableStateOf("") // for accept new value is mutable for builder string
    }

    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = {
            textFieldValue.value = it  // for get new char and build string or words
        },
        label = {
            Text(text = "This is Field")
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedBorderColor = colorResource(id = R.color.teal_200)
        )
    )

}

val my_text = mutableStateOf("")

//@Preview
@Composable
fun MyBottom() {
    Button(
        onClick = {
            my_text.value = "My Text Click"
        },
        colors = ButtonDefaults.buttonColors(contentColor = colorResource(id = R.color.purple_200)),
        border = BorderStroke(
            8.dp, color = colorResource(id = R.color.purple_700)
        )
    ) {
        Text(text = stringResource(id = R.string.app_name))

    }
}

//@Preview
@Composable
fun MyGroupRadioButton() {
    val listItem = arrayListOf(0, 1, 2)

    val itemSelected = remember {
        mutableStateOf(listItem.first())
    }
    val colors = RadioButtonDefaults.colors(
        selectedColor = colorResource(id = R.color.purple_700),
        unselectedColor = colorResource(id = R.color.black),
        disabledColor = colorResource(id = R.color.teal_700)
    )
    listItem.forEach { index ->
        RadioButton(selected = itemSelected.value == index, onClick = {
            itemSelected.value = index
        }, colors = colors)
    }

}

//@Preview
@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        content = {
            Icon(
                Icons.Filled.Favorite, stringResource(id = R.string.app_name)
            )
        },
    )
}

//@Preview
@Composable
fun progressIndicator() {
    CircularProgressIndicator()
    LinearProgressIndicator()
}

@Composable
fun showAlertDialog() {
    val showAlertFlag = remember {
        mutableStateOf(true)
    }
    val text = remember {
        mutableStateOf("ok")
    }
    if (showAlertFlag.value) {
        AlertDialog(text = { Text(text = "Title Alert Dialog") },
            title = { Text(text = "Text Alert Dialog") },
            onDismissRequest = {
                showAlertFlag.value = false
            },
            confirmButton = {
                Button(onClick = {}) {
                    Text(text = "Ok")
                }
            },
            dismissButton = {
                Button(onClick = { showAlertFlag.value = false }) {
                    Text(text = "Cancel")

                }
            })
    }
}

@Composable
fun row() {

    Text(
        text = "mjd",
        style = TextStyle(background = (Color.Magenta))
    )
    Text(
        text = "zain",
        style = TextStyle(background = (Color.Magenta)),
    )
    Text(
        text = "hala",
        style = TextStyle(background = (Color.Magenta)),
    )

}


@Composable
fun ColumnScope.verticalColumn() {//use ColumnScope for set weight for each item inside column

    Text(
        text = "majd", fontSize = 17.sp, style = TextStyle(background = Color.Cyan),
        modifier = Modifier.weight(2f)
    )
    Text(
        text = "majd", fontSize = 17.sp, style = TextStyle(background = Color.Cyan),
        modifier = Modifier.weight(1f)
    )
    Text(
        text = "majd",
        fontSize = 17.sp,
        style = TextStyle(background = Color.Cyan),
        modifier = Modifier.weight(1f)
    )


}

@Composable
fun MyBox(modifier: Modifier, contentModifier: Modifier) {
    Box(modifier = modifier.fillMaxSize()) {//at same frameLayout

        Text(
            text = "majd",
            fontSize = 17.sp,
            style = TextStyle(background = Color.Cyan),
            modifier = contentModifier.align(
                Alignment.BottomCenter
            )

        )
        Text(
            text = "majd",
            fontSize = 17.sp,
            style = TextStyle(background = Color.Cyan),
            modifier = contentModifier.align(
                Alignment.TopCenter
            )

        )
        Text(
            text = "majd",
            fontSize = 17.sp,
            style = TextStyle(background = Color.Cyan), modifier = contentModifier.align(
                Alignment.Center
            )

        )

    }
}

@Composable
fun surface(modifier: Modifier) {

    Surface(modifier = modifier.size(200.dp)) {
        Column {
            verticalColumn()
        }
    }
}

@Composable
fun Scaffold() {
    val state: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()
    Scaffold(content = { row() }, topBar = { TopBar(state, scope) }, drawerContent = {})
}

@Composable
fun TopBar(state: ScaffoldState, scope: CoroutineScope) {
    TopAppBar(navigationIcon = {
        IconButton(
            onClick = {
                scope.launch {
                    if (state.drawerState.isClosed)
                        state.drawerState.open()
                    else
                        state.drawerState.close()
                }
            },
            content = {
                Icon(
                    Icons.Default.Menu, contentDescription = ""
                )
            },
        )
    }, title = { Text(text = stringResource(id = R.string.app_name)) })
}

@Composable
fun columnItems() {
    LazyColumn {

//        items(myListItems){
//            initialItemInsideLayout(it)
//        }
        items(myListItems){
            initialItemInsideLayout(item = it)
        }
    }
}

val myListItems = listOf(
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera"),
    myList(R.drawable.ic_launcher_background, "camera")
)

@Composable
fun initialItemInsideLayout(item: myList) {
    Row(modifier = Modifier.padding(8.dp)) {

        Image(
            painter = painterResource(id = item.image),
            contentDescription = "image ",
            modifier = Modifier
                .size(60.dp)
                .padding(8.dp)
        )
        Text(
            text = item.name,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterVertically),
            color = Color.Blue,
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

data class myList(val image: Int, val name: String)